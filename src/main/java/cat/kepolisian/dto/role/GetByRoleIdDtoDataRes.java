package cat.kepolisian.dto.role;

import lombok.Data;

@Data
public class GetByRoleIdDtoDataRes {
	private String roleName;
	private Integer version;
	private Boolean isActive;
}
