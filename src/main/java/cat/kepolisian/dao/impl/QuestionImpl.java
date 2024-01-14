package cat.kepolisian.dao.impl;

import cat.kepolisian.core.BaseDaoImpl;
import cat.kepolisian.dao.QuestionDao;
import cat.kepolisian.entity.Question;
import cat.kepolisian.entity.QuestionType;
import cat.kepolisian.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class QuestionImpl extends BaseDaoImpl implements QuestionDao {
    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() throws Exception {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(String id) throws Exception {
        return questionRepository.getById(id);
    }

    @Override
    public Question save(Question data) throws Exception {
        return questionRepository.saveAndFlush(data);
    }

    @Override
    public List<Question> getByQuestionType(QuestionType questionType) throws Exception {
        return questionRepository.findByQuestionType(questionType);
    }
}
