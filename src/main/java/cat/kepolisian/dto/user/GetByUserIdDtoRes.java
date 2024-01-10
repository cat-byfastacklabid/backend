package cat.kepolisian.dto.user;

import lombok.Data;

@Data
public class GetByUserIdDtoRes {
	private String msg;
	private GetByUserIdDtoDataRes data;
}
