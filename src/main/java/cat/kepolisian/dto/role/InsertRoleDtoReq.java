package cat.kepolisian.dto.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class InsertRoleDtoReq {
	@NotEmpty(message = "Role Code is Empty")
	@Size(max = 5, min = 3, message = "Code min 3 Character and max 5 Character")
	private String roleCode;
	
	@NotEmpty(message = "Role Name is Empty")
	@Size(max = 30, min = 5, message = "Name min 5 Character and max 30 Character")
	private String roleName;

}
