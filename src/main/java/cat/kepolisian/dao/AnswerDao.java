package cat.kepolisian.dao;

import cat.kepolisian.entity.Answer;

import java.util.List;

public interface AnswerDao {
    public List<Answer> getAll() throws Exception;
    public Answer getById(String id) throws Exception;
    public Answer save(Answer data) throws Exception;
    public  List<Answer> getByQuestionId(String questionId) throws Exception;
}
