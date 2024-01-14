package cat.kepolisian.controller;

import cat.kepolisian.dto.user.*;
import cat.kepolisian.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@Tag(name = "User")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<InsertUserDtoRes> insertData(@RequestBody @Validated InsertUserDtoReq data) throws Exception{
		InsertUserDtoRes insertData = userService.insert(data);
		return new ResponseEntity<>(insertData, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UpdateUserDtoRes> updateData(@RequestBody @Validated UpdateUserDtoReq data) throws Exception{
		UpdateUserDtoRes updateData = userService.update(data);
		return new ResponseEntity<>(updateData, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<GetAllUserDtoRes> getAll() throws Exception{
		GetAllUserDtoRes getAll = userService.getAll();
		return new ResponseEntity<>(getAll, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GetByUserIdDtoRes> getById(@PathVariable("id") String id) throws Exception{
		GetByUserIdDtoRes getById = userService.getById(id);
		return new ResponseEntity<>(getById, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<DeleteByUserIdDtoRes> deleteById(@PathVariable("id") String id) throws Exception{
		DeleteByUserIdDtoRes deleteById = userService.deleteById(id);
		return new ResponseEntity<>(deleteById, HttpStatus.OK);
	}
}
