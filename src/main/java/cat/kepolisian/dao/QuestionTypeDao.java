package cat.kepolisian.dao;

import cat.kepolisian.entity.QuestionType;

import java.util.List;

public interface QuestionTypeDao {
    public List<QuestionType> getAll() throws Exception;
    public QuestionType getById(String id) throws Exception;
    public QuestionType save(QuestionType data) throws Exception;
    public QuestionType getByTypeCode(String typeCode) throws Exception;
}
