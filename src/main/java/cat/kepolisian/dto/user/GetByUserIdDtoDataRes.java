package cat.kepolisian.dto.user;

import lombok.Data;

@Data
public class GetByUserIdDtoDataRes {
	private String id;
	private String username;
	private String password;
	private String roleName;
	private Integer version;
	private Boolean isActive;
}
