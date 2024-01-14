package cat.kepolisian.constant;

import lombok.Getter;

@Getter
public enum QuestionTypeEnum {
	KEPRIBADIAN("kepribadian", "Q01"), AKADEMIK("Akademik", "Q02"), KETAHANAN("Ketahanan", "Q03");

	private final String detail;
	private final String code;

	private QuestionTypeEnum(String detail, String code){
		this.detail = detail;
		this.code = code;
	}

}
