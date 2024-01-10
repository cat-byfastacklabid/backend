package cat.kepolisian.dto.user;

import lombok.Data;


@Data
public class UpdateUserDtoReq {
	private String id;
	private String username;
	private String password;
	private Integer version;
	private Boolean isActive;
}
