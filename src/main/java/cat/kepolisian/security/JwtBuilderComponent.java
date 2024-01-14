package cat.kepolisian.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.crypto.SecretKey;


@Component
public class JwtBuilderComponent {
	private final SecretKey secretKey;
	
	public JwtBuilderComponent() {
		secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}
	
	public String generateToken(Duration duration, String id) {
		LocalDateTime expiredDate = LocalDateTime.now().plusSeconds(duration.getSeconds());
		JwtBuilder jwtBuilder = Jwts.builder().signWith(secretKey).setExpiration(Timestamp.valueOf(expiredDate)).setIssuer(id);
		
		return jwtBuilder.compact();
	}
	
	public String getClaimId(String token) {
		return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getIssuer();
	}
}
