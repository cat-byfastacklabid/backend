package cat.kepolisian.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class GetAllUserDtoRes {
	private String msg;
	private List<GetAllUserDtoDataRes> data;
}
