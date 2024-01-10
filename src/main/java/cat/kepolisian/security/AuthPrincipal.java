package cat.kepolisian.security;

import org.springframework.security.core.Authentication;

public interface AuthPrincipal {
	public Authentication getAuthentication() throws Exception;
}
