package cat.kepolisian.constant;

public enum RoleEnum {
	ADMIN("admin", "U01"), USER("user", "U02");
	
	private String detail;
	private String code;
	
	private RoleEnum(String detail, String code){
		this.detail = detail;
		this.code = code;
	}
	
	public String getDetail() {
		return this.detail;
	}
	
	public String getCode() {
		return this.code;
	}
}
