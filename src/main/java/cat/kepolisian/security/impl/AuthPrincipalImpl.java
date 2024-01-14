package cat.kepolisian.security.impl;

import cat.kepolisian.security.AuthPrincipal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthPrincipalImpl implements AuthPrincipal {
	@Override
	public Authentication getAuthentication() throws Exception {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
