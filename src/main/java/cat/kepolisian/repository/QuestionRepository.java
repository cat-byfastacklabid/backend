package cat.kepolisian.repository;

import cat.kepolisian.entity.Question;
import cat.kepolisian.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    public List<Question> findByQuestionType(QuestionType questionType) throws Exception;
}
