package cat.kepolisian.service;

import cat.kepolisian.dto.questionoptions.GetQuestionOptionDtoRes;

public interface AnswerService {
    public GetQuestionOptionDtoRes getQuestionKepribadian() throws Exception;
    public GetQuestionOptionDtoRes getQuestionAkademik() throws Exception;
    public GetQuestionOptionDtoRes getQuestionKetahanan() throws Exception;
}
