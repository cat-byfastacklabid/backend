package cat.kepolisian.security;

import java.io.IOException;
import java.time.Duration;

import cat.kepolisian.dao.UserDao;
import cat.kepolisian.dto.user.AuthenticationDtoRes;
import cat.kepolisian.dto.user.LoginDtoDataRes;
import cat.kepolisian.dto.user.LoginDtoReq;
import cat.kepolisian.dto.user.LoginDtoRes;
import cat.kepolisian.entity.User;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	private JwtBuilderComponent jwtBuilderComponent;
	private UserDao userDao;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager, JwtBuilderComponent jwtBuilderComponent, UserDao userDao) {
		this.authenticationManager = authenticationManager;
		this.jwtBuilderComponent = jwtBuilderComponent;
		this.userDao = userDao;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		LoginDtoReq data = new LoginDtoReq();

		try {
			data = new ObjectMapper().readValue(request.getInputStream(), LoginDtoReq.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		User user = null;
		try {
			user = userDao.getByUsername(authResult.getName());
			String token = jwtBuilderComponent.generateToken(Duration.ofHours(3), user.getId());
			
			LoginDtoDataRes data = new LoginDtoDataRes();
			
			data.setToken(token);
			data.setId(user.getId());
			data.setRoleCode(user.getRole().getRoleCode());
			data.setUsername(user.getUsername());

			LoginDtoRes dtoRes = new LoginDtoRes();
			dtoRes.setMsg("Login Sukses");
			dtoRes.setData(data);
			
			String loginDtoRes = new ObjectMapper().writeValueAsString(dtoRes);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().append(loginDtoRes);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		AuthenticationDtoRes dtoRes = new AuthenticationDtoRes();
		dtoRes.setMsg("Invalid Login");
		String loginDtoRes = new ObjectMapper().writeValueAsString(dtoRes);
		
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().append(loginDtoRes);
	}
}
