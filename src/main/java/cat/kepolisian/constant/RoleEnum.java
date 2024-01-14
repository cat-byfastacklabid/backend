package cat.kepolisian.constant;

import lombok.Getter;

@Getter
public enum RoleEnum {
	ADMIN("admin", "U01"), USER("user", "U02");
	
	private final String detail;
	private final String code;
	
	private RoleEnum(String detail, String code){
		this.detail = detail;
		this.code = code;
	}

}
