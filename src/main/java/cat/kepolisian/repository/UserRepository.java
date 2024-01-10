package cat.kepolisian.repository;

import cat.kepolisian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Modifying
	public int removeById(String id) throws Exception;
	public User findByUsername(String username) throws Exception;
}
