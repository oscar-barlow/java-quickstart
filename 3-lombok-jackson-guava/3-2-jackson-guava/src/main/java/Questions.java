import Question.Question;
import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;

@Value
@Builder
public class Questions {

  public Questions(List<Question> questions) {
    this.questions = questions;
  }

  private List<Question> questions;

}
