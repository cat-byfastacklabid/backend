package cat.kepolisian.dao.impl;

import cat.kepolisian.dao.UserDao;
import cat.kepolisian.entity.User;
import cat.kepolisian.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class UserDaoImpl implements UserDao {
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAll() throws Exception {
		return userRepository.findAll();
	}
	
	@Override
	public User getById(String id) throws Exception {
		return userRepository.getById(id);
	}
	
	@Override
	public User save(User data) throws Exception {
		return userRepository.saveAndFlush(data);
	}
	
	@Override
	public boolean deleteById(String id) throws Exception {
		int result = userRepository.removeById(id);
		return result > 0;
	}

	@Override
	public User getByUsername(String username) throws Exception {
		return userRepository.findByUsername(username);
	}


}
