package cat.kepolisian.security;

import java.io.IOException;

import cat.kepolisian.dto.user.AuthorizationDtoRes;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter extends BasicAuthenticationFilter {
	private JwtBuilderComponent jwtBuilderComponent;

	public AuthorizationFilter(AuthenticationManager authenticationManager, JwtBuilderComponent jwtBuilderComponent) {
		super(authenticationManager);
		this.jwtBuilderComponent = jwtBuilderComponent;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		
		String token = header.substring(7);
		
		String id = null;
		AuthorizationDtoRes dtoRes = null;
		try {
			id = jwtBuilderComponent.getClaimId(token);
			dtoRes = new AuthorizationDtoRes();
		} catch (ExpiredJwtException e) {
			dtoRes.setMsg("Token Expired");
		} catch (ClaimJwtException e) {
			dtoRes.setMsg("Invalid Token");
		}
		
		if (dtoRes.getMsg() != null) {
			String authorizationRes = new ObjectMapper().writeValueAsString(dtoRes);
			response.getWriter().append(authorizationRes);
			return;
		}
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(id, null, null);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}
}
