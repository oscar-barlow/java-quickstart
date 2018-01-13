package Question;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Question {

  public Question(String category, Boolean type, String difficulty, String question,
      String correct_answer, List<String> incorrect_answers) {
    this.category = category;
    this.type = type;
    this.difficulty = difficulty;
    this.question = question;
    this.correct_answer = correct_answer;
    this.incorrect_answers = incorrect_answers;
  }

  private String category;
  private Boolean type;
  private String difficulty;
  private String question;
  private String correct_answer;
  private List<String> incorrect_answers;

}
