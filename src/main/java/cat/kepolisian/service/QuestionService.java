package cat.kepolisian.service;

import cat.kepolisian.dto.user.GetAllUserDtoRes;

public interface QuestionService {
    public GetAllUserDtoRes getAll() throws Exception;
}
