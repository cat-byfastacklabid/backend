package cat.kepolisian.service;

import cat.kepolisian.dto.user.*;
import cat.kepolisian.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	public GetAllUserDtoRes getAll() throws Exception;
	public GetByUserIdDtoRes getById(String id) throws Exception;
	public InsertUserDtoRes insert(InsertUserDtoReq data) throws Exception;
	public UpdateUserDtoRes update(UpdateUserDtoReq data) throws Exception;
	public DeleteByUserIdDtoRes deleteById(String id) throws Exception;
	public User getByUsername(String data) throws Exception;
}
