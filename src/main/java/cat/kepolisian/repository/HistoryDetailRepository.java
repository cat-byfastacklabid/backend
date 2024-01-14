package cat.kepolisian.repository;

import cat.kepolisian.entity.HistoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDetailRepository extends JpaRepository<HistoryDetail, String> {
}
