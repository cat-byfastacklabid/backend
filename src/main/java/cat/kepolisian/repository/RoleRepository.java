package cat.kepolisian.repository;

import cat.kepolisian.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	@Modifying
	public int removeById(String id) throws Exception;
	public Role findByRoleCode(String roleCode) throws Exception;
}
