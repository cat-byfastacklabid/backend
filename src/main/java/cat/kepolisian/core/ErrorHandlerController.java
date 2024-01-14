package cat.kepolisian.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		Map<String, Object> map = new HashMap<>();
		List<String> errors = new ArrayList<>();
		
		e.getBindingResult().getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
		
		map.put("msg", errors);
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
