package ghtk.excel.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
	public boolean success;
	public String message;
	
}
