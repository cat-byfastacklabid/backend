package cat.kepolisian.dao.impl;

import cat.kepolisian.dao.RoleDao;
import cat.kepolisian.entity.Role;
import cat.kepolisian.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class RoleDaoImpl implements RoleDao {
	private RoleRepository roleRepository;
	
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<Role> getAll() throws Exception {
		return roleRepository.findAll();
	}
	
	@Override
	public Role getById(String id) throws Exception {
		return roleRepository.getById(id);
	}
	
	@Override
	public Role save(Role data) throws Exception {
		return roleRepository.saveAndFlush(data);
	}
	
	@Override
	public boolean deleteById(String id) throws Exception {
		int result = roleRepository.removeById(id);
		return result > 0;
	}

	@Override
	public Role getByRoleCode(String roleCode) throws Exception {
		return roleRepository.findByRoleCode(roleCode);
	}
}
