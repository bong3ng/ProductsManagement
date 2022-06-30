package ghtk.excel.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTO<T> {
	
	private boolean success = true;
	private String message;
	private List<T> data;
	

}
