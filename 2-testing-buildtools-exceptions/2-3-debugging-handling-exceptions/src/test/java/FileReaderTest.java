import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class FileReaderTest {

  private final FileReader underTest = new FileReader();

  @Test
  public void shouldConcatenateLinesInAFileGivenFileExists() throws Exception {
    String testFileContents = underTest.readFile("example-text.txt");

    assertThat(testFileContents).isEqualTo("This is some text in a file. I decided to split it over several lines. Because I thought that would be more interesting!");
  }

  @Test
  public void shouldThrowRuntimeExceptionGivenFileDoesNotExist() throws Exception {
    assertThatThrownBy(() -> underTest.alternativeReadFile("a totally made up file name.txt"))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("Could not find file");
  }
}