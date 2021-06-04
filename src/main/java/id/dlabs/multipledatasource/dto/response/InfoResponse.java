package id.dlabs.multipledatasource.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoResponse {
	private String id;
	private String message;
	private String messageEn;
	private String messageId;
	private String field;
	private String redirect;
}
