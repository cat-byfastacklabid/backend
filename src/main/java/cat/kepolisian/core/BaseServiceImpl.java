package cat.kepolisian.core;

import cat.kepolisian.security.AuthPrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class BaseServiceImpl{
	private AuthPrincipal authPrincipal;
	private Random random = new Random();
	
	@Autowired
	public void setAuthPrincipal(AuthPrincipal authPrincipal) {
		this.authPrincipal = authPrincipal;
	}
	
	public String getAlphaNumericString(int n) {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder(n);
	
		for (int i = 0; i < n; i++) {

			int index = (alphaNumericString.length() * random.nextInt());
			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	protected String getId() throws Exception {
		return authPrincipal.getAuthentication().getPrincipal().toString();
	}
}