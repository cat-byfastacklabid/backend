package cat.kepolisian.repository;

import cat.kepolisian.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, String> {
    public QuestionType findByTypeCode(String typeCode) throws Exception;
}
