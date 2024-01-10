package cat.kepolisian.service;

import cat.kepolisian.dto.role.*;

public interface RoleService {
	public GetAllRoleDtoRes getAll() throws Exception;
	public GetByRoleIdDtoRes getById(String id) throws Exception;
	public InsertRoleDtoRes insert(InsertRoleDtoReq data) throws Exception;
	public UpdateRoleDtoRes update(UpdateRoleDtoReq data) throws Exception;
	public DeleteByRoleIdDtoRes deleteById(String id) throws Exception;
	public GetRoleIdByCodeDtoRes getIdByCode(String code) throws Exception;	
}
