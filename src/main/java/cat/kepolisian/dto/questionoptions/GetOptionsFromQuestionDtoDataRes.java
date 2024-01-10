package cat.kepolisian.dto.questionoptions;

import lombok.Data;

import java.util.List;

@Data
public class GetOptionsFromQuestionDtoDataRes {
    private String questionId;
    private String question;
    private List<GetQuestionOptionDtoDataRes> options;
}
