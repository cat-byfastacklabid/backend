package cat.kepolisian.repository;

import cat.kepolisian.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {
    public List<Answer> findByQuestionId (String questionId) throws Exception;
}
