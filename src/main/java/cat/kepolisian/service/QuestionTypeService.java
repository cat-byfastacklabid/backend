package cat.kepolisian.service;

import cat.kepolisian.dto.user.*;

public interface QuestionTypeService {
    public GetAllUserDtoRes getAll() throws Exception;
    public GetByUserIdDtoRes getById(String id) throws Exception;
    public InsertUserDtoRes insert(InsertUserDtoReq data) throws Exception;
    public UpdateUserDtoRes update(UpdateUserDtoReq data) throws Exception;
}
