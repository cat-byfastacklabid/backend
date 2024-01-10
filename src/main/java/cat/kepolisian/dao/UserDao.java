package cat.kepolisian.dao;

import java.util.List;

import cat.kepolisian.entity.User;

public interface UserDao {
	public List<User> getAll() throws Exception;
	public User getById(String id) throws Exception;
	public User save(User data) throws Exception;
	public boolean deleteById(String id) throws Exception;
	public User getByUsername(String username) throws Exception;
}
