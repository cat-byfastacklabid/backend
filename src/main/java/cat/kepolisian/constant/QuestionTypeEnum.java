package cat.kepolisian.constant;

public enum QuestionTypeEnum {
	KEPRIBADIAN("kepribadian", "Q01"), AKADEMIK("Akademik", "Q02"), KETAHANAN("Ketahanan", "Q03");

	private String detail;
	private String code;

	private QuestionTypeEnum(String detail, String code){
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
