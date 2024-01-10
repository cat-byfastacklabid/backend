package cat.kepolisian.dto.role;

import lombok.Data;

import java.util.List;

@Data
public class GetAllRoleDtoRes {
	private String msg;
	private List<GetAllRoleDtoDataRes> data;
}
