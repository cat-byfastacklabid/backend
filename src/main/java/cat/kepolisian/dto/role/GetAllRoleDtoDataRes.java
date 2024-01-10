package cat.kepolisian.dto.role;

import lombok.Data;

@Data
public class GetAllRoleDtoDataRes {
	private String id;
	private String roleName;
	private Integer version;
	private Boolean isActive;
}
