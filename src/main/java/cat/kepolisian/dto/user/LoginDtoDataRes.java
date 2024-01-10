package cat.kepolisian.dto.user;

import lombok.Data;

@Data
public class LoginDtoDataRes {
	private String token;
	private String id;
	private String roleCode;
	private String username;
}
