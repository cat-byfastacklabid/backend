package cat.kepolisian.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class InsertUserDtoReq {
	@NotEmpty(message = "Username is Empty")
	@Size(max = 50, min = 5, message = "Username min 5 Character and max 30 Character")
	private String username;
	
	@NotEmpty(message = "Password is Empty")
	@Size(min = 8, message = "Password min 8 Character")
	private String password;
	
	@NotNull(message = "Role Id Is Empty")
	private String roleId;
}
