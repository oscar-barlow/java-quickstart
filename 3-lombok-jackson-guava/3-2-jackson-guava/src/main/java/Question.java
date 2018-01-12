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

  private final String category;
  private final Boolean type;
  private final String difficulty;
  private final String question;
  private final String correct_answer;
  private final List<String> incorrect_answers;

}
