package id.dlabs.multipledatasource.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	private String status;
	private T data;	
	private InfoResponse info;
	
	public Response(T object)
	{
		this.status = Response.SUCCESS;
		this.data = object;
	}
	
	
	public void setError(InfoResponse info) {
		this.status = Response.ERROR;
		this.info = info;
	}
	
	public void setError(String id, String message) {
		this.status = Response.ERROR;
		
		InfoResponse error = new InfoResponse();
		error.setId(id);
		error.setMessage(message);

		this.info = error;
	}
	
	public void setError(String id) {
		this.status = Response.ERROR;
		
		InfoResponse error = new InfoResponse();
		error.setId(id);

		this.info = error;
	}
	
	public void setError(String id, String message, String field, String redirect) {
		this.status = Response.ERROR;
		
		InfoResponse error = new InfoResponse();
		error.setId(id);
		error.setMessage(message);
		error.setField(field);
		error.setRedirect(redirect);

		this.info = error;
	}
	
	public void setSuccess(T object){
		this.status = Response.SUCCESS;
		this.data = object;
	}

	public static <T> Response<T> toSuccess(T data) {
		return Response.<T>builder()
				.data(data)
				.status(Response.SUCCESS)
				.build();
	}

	public static <T> Response<T> toError(T data, InfoResponse infoResponse) {
		return Response.<T>builder()
				.data(data)
				.status(Response.ERROR)
				.info(infoResponse)
				.build();
	}
}
