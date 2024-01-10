package cat.kepolisian.dao.impl;

import cat.kepolisian.core.BaseDaoImpl;
import cat.kepolisian.dao.AnswerDao;
import cat.kepolisian.entity.Answer;
import cat.kepolisian.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class AnswerImpl extends BaseDaoImpl implements AnswerDao {
    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAll() throws Exception {
        return answerRepository.findAll();
    }

    @Override
    public Answer getById(String id) throws Exception {
        return answerRepository.getById(id);
    }

    @Override
    public Answer save(Answer data) throws Exception {
        return answerRepository.saveAndFlush(data);
    }

    @Override
    public List<Answer> getByQuestionId(String questionId) throws Exception {
        return answerRepository.findByQuestionId(questionId);
    }
}
