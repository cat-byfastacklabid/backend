package cat.kepolisian.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import cat.kepolisian.core.BaseServiceImpl;
import cat.kepolisian.dao.RoleDao;
import cat.kepolisian.entity.Role;
import cat.kepolisian.service.RoleService;

import cat.kepolisian.dto.role.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
	private RoleDao roleDao;
	
	@Autowired
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	@Override
	public GetAllRoleDtoRes getAll() throws Exception {
		GetAllRoleDtoRes getAll = new GetAllRoleDtoRes();
		
		List<Role> roles = roleDao.getAll();
		List<GetAllRoleDtoDataRes> listRole = new ArrayList<>();

		for (int i = 0; i < roles.size(); i++) {
			Role role = roles.get(i);
			GetAllRoleDtoDataRes data = new GetAllRoleDtoDataRes();

			data.setId(role.getId());
			data.setRoleName(role.getRoleName());
			data.setVersion(role.getVersion());
			data.setIsActive(role.getIsActive());

			listRole.add(data);
		}
		
		getAll.setData(listRole);
		getAll.setMsg(null);

		return getAll;
	}
	
	@Override
	public GetByRoleIdDtoRes getById(String id) throws Exception {
		GetByRoleIdDtoRes getById = new GetByRoleIdDtoRes();
		
		Role role = roleDao.getById(id);
		GetByRoleIdDtoDataRes data = new GetByRoleIdDtoDataRes();

		data.setRoleName(role.getRoleName());
		data.setVersion(role.getVersion());
		data.setIsActive(role.getIsActive());

		getById.setData(data);
		getById.setMsg(null);

		return getById;
		
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public InsertRoleDtoRes insert(InsertRoleDtoReq data) throws Exception {
		InsertRoleDtoRes insert  = new InsertRoleDtoRes();
		
		Role role = new Role();
		
		role.setRoleCode(data.getRoleCode());
		role.setRoleName(data.getRoleName());

//		if(getId() != null){
//			role.setCreatedBy(getId());
//		}else {
			role.setCreatedBy("Admin");
//		}

		Role insertRole = roleDao.save(role);

		InsertRoleDtoDataRes dataDto = new InsertRoleDtoDataRes();
		dataDto.setId(insertRole.getId());

		insert.setData(dataDto);
		insert.setMsg("Insert Success");

		return insert;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public UpdateRoleDtoRes update(UpdateRoleDtoReq data) throws Exception {
		UpdateRoleDtoRes update = new UpdateRoleDtoRes();
		
		if (data.getVersion() != null) {
			Role role = roleDao.getById(data.getId());

			role.setRoleName(data.getRoleName());
			role.setVersion(data.getVersion());
			role.setUpdatedBy(getId());
			
			if(data.getIsActive() != null) {				
				role.setIsActive(data.getIsActive());
			}

			Role updateRole = roleDao.save(role);

			UpdateRoleDtoDataRes dataDto = new UpdateRoleDtoDataRes();
			dataDto.setVersion(updateRole.getVersion());

			update.setData(dataDto);
			update.setMsg("Update Success");
		}
		
		return update;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public DeleteByRoleIdDtoRes deleteById(String id) throws Exception {
		DeleteByRoleIdDtoRes deleteById = new DeleteByRoleIdDtoRes();
		
		boolean delete = roleDao.deleteById(id);
		
		if(delete) {
			deleteById.setMsg("Delete Success");
		}
		
		return deleteById;
	}
	
	@Override
	public GetRoleIdByCodeDtoRes getIdByCode(String code) throws Exception {
		GetRoleIdByCodeDtoRes getIdByCode = new GetRoleIdByCodeDtoRes();
		
		Role role = roleDao.getByRoleCode(code);
		GetRoleIdByCodeDtoDataRes data = new GetRoleIdByCodeDtoDataRes();

		data.setId(role.getId());

		getIdByCode.setData(data);
		getIdByCode.setMsg(null);

		return getIdByCode;
	}
}
