package cat.kepolisian.controller;

import javax.validation.Valid;

import cat.kepolisian.service.RoleService;
import cat.kepolisian.dto.role.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("roles")
@Tag(name = "Role")
public class RoleController {
	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@PostMapping
	public ResponseEntity<InsertRoleDtoRes> insertData(@RequestBody @Valid InsertRoleDtoReq data) throws Exception{
		InsertRoleDtoRes insertData = roleService.insert(data);
		return new ResponseEntity<>(insertData, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UpdateRoleDtoRes> updateData(@RequestBody @Valid UpdateRoleDtoReq data) throws Exception{
		UpdateRoleDtoRes updateData = roleService.update(data);
		return new ResponseEntity<>(updateData, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<GetAllRoleDtoRes> getAll() throws Exception{
		GetAllRoleDtoRes getAll = roleService.getAll();
		return new ResponseEntity<>(getAll, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GetByRoleIdDtoRes> getById(@PathVariable("id") String id) throws Exception{
		GetByRoleIdDtoRes getById = roleService.getById(id);
		return new ResponseEntity<>(getById, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<DeleteByRoleIdDtoRes> deleteById(@PathVariable("id") String id) throws Exception{
		DeleteByRoleIdDtoRes deleteById = roleService.deleteById(id);
		return new ResponseEntity<>(deleteById, HttpStatus.OK);
	}
	
	@GetMapping("role/{code}")
	public ResponseEntity<GetRoleIdByCodeDtoRes> getIdByCode(@PathVariable("code") String code) throws Exception{
		GetRoleIdByCodeDtoRes getIdByCode = roleService.getIdByCode(code);
		return new ResponseEntity<>(getIdByCode, HttpStatus.OK);
	}
}
