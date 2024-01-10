package cat.kepolisian.dao;

import java.util.List;

import cat.kepolisian.entity.Role;

public interface RoleDao {
	public List<Role> getAll() throws Exception;
	public Role getById(String id) throws Exception;
	public Role save(Role data) throws Exception;
	public boolean deleteById(String id) throws Exception;
	public Role getByRoleCode(String roleCode) throws Exception;
}
