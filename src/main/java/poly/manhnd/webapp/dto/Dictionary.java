package poly.manhnd.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {

	private String en;
	private String vi;
	private String audioPath;

	public Dictionary(String en, String vi) {
		super();
		this.en = en;
		this.vi = vi;
	}

}
