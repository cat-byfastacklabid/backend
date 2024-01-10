package cat.kepolisian.dto.questionoptions;

import lombok.Data;

import java.util.List;

@Data
public class GetQuestionOptionDtoRes {
    private String quizTitle;
    private List<GetOptionsFromQuestionDtoDataRes> question;
}
