package cat.kepolisian.dto.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateRoleDtoReq {
	@NotNull(message = "Role Id is Empty")
	private String id;
	
	@NotEmpty(message = "Role Name is Empty")
	@Size(max = 30, min = 5, message = "Name min 5 Character and max 30 Character")
	private String roleName;
	
	@NotNull(message = "Version is Empty")
	private Integer version;
	private Boolean isActive;
}
