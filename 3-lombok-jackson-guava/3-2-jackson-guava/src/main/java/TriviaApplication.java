public class TriviaApplication {

  private static final TriviaService QUESTION_SERVICE = new TriviaService();

  public static void main(String[] args) {
    final TriviaClient triviaClient = new TriviaClient();

    System.out.println(triviaClient.getRandomQuestions(10));

  }

}
