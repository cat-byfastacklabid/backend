package cat.kepolisian.dao.impl;

import cat.kepolisian.core.BaseDaoImpl;
import cat.kepolisian.dao.QuestionTypeDao;
import cat.kepolisian.entity.QuestionType;
import cat.kepolisian.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class QuestionTypeImpl extends BaseDaoImpl implements QuestionTypeDao {
    private QuestionTypeRepository typeRepository;

    @Autowired
    public void setQuestionTypeRepository(QuestionTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<QuestionType> getAll() throws Exception {
        return typeRepository.findAll();
    }

    @Override
    public QuestionType getById(String id) throws Exception {
        return typeRepository.getById(id);
    }

    @Override
    public QuestionType save(QuestionType data) throws Exception {
        return typeRepository.saveAndFlush(data);
    }

    @Override
    public QuestionType getByTypeCode(String typeCode) throws Exception {
        return typeRepository.findByTypeCode(typeCode);
    }
}
