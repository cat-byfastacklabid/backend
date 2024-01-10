package cat.kepolisian.dao;

import cat.kepolisian.entity.Question;
import cat.kepolisian.entity.QuestionType;

import java.util.List;

public interface QuestionDao {
    public List<Question> getAll() throws Exception;
    public Question getById(String id) throws Exception;
    public Question save(Question data) throws Exception;

    public List<Question> getByQuestionType(QuestionType questionType) throws Exception;
}
