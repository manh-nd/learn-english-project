package poly.manhnd.webapp.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import poly.manhnd.webapp.entities.GrammarQuestion;

@Data
public class QnAList {

	private List<QnA> list = new ArrayList<>();

	private List<GrammarQuestion> questions = new ArrayList<>();

	private float mark;

}
