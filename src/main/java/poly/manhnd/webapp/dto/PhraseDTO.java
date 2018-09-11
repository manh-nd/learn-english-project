package poly.manhnd.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhraseDTO {

	private Long id;
	private String phrase;
	private String description;
	private String meaning;

}
