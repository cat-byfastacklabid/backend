package cat.kepolisian.service.impl;

import cat.kepolisian.core.BaseServiceImpl;
import cat.kepolisian.constant.RoleEnum;
import cat.kepolisian.dao.RoleDao;
import cat.kepolisian.dao.UserDao;
import cat.kepolisian.dto.user.*;
import cat.kepolisian.entity.Role;
import cat.kepolisian.entity.User;
import cat.kepolisian.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private final UserDao userDao;
	private final RoleDao roleDao;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public GetAllUserDtoRes getAll() throws Exception {
		GetAllUserDtoRes getAll = new GetAllUserDtoRes();

		List<User> users = userDao.getAll();
		List<GetAllUserDtoDataRes> listUser = new ArrayList<>();

        for (User user : users) {
            GetAllUserDtoDataRes data = new GetAllUserDtoDataRes();

            data.setId(user.getId());
            data.setUsername(user.getUsername());
            data.setPassword(user.getPassword());
            data.setRoleName(user.getRole().getRoleName());
            data.setVersion(user.getVersion());
            data.setIsActive(user.getIsActive());

            listUser.add(data);
        }

		getAll.setData(listUser);
		getAll.setMsg(null);

		return getAll;
	}
	
	@Override
	public GetByUserIdDtoRes getById(String id) throws Exception {
		GetByUserIdDtoRes getById = new GetByUserIdDtoRes();

		User user = userDao.getById(id);
		GetByUserIdDtoDataRes data = new GetByUserIdDtoDataRes();

		data.setId(user.getId());
		data.setUsername(user.getUsername());
		data.setPassword(user.getPassword());
		data.setRoleName(user.getRole().getRoleName());
		data.setVersion(user.getVersion());
		data.setIsActive(user.getIsActive());

		getById.setData(data);
		getById.setMsg(null);

		return getById;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public InsertUserDtoRes insert(InsertUserDtoReq data) throws Exception {
		InsertUserDtoRes insert  = new InsertUserDtoRes();

		User user = new User();
		user.setUsername(data.getUsername());
		
		String password = passwordEncoder.encode(data.getPassword());
		user.setPassword(password);
		
		Role role = roleDao.getByRoleCode(RoleEnum.ADMIN.getCode());
		user.setRole(role);
		
		user.setCreatedBy(role.getId());
		
		User userInsert = userDao.save(user);

		InsertUserDtoDataRes dataDto = new InsertUserDtoDataRes();
		dataDto.setId(userInsert.getId());

		insert.setData(dataDto);
		insert.setMsg("Insert Success");

		return insert;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public UpdateUserDtoRes update(UpdateUserDtoReq data) throws Exception {
		UpdateUserDtoRes update = new UpdateUserDtoRes();

		if (data.getVersion() != null) {
			User user = userDao.getById(data.getId());

			user.setUsername(data.getUsername());
			user.setVersion(data.getVersion());
			
			if(getId() != null) {
				user.setUpdatedBy(getId());
			}
			
			if (data.getIsActive() != null) {
				user.setIsActive(data.getIsActive());
			}

			User userUpdate = userDao.save(user);

			UpdateUserDtoDataRes dataDto = new UpdateUserDtoDataRes();
			dataDto.setVersion(userUpdate.getVersion());

			update.setData(dataDto);
			update.setMsg("Update Success");
		}
		
		return update;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public DeleteByUserIdDtoRes deleteById(String id) throws Exception {
		DeleteByUserIdDtoRes deleteById = new DeleteByUserIdDtoRes();
		
		boolean delete = userDao.deleteById(id);
		
		if(delete) {
			deleteById.setMsg("Delete Success");
		}
		
		return deleteById;
	}
	
	@Override
	public User getByUsername(String data) throws Exception {
		return userDao.getByUsername(data);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = getByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Invalid Username Or Password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
}
