package cat.kepolisian.dto.user;

import lombok.Data;

@Data
public class LoginDtoReq {
	private String username;
	private String password;
}
