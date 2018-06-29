package com.javaquickstart.debugginghandlingexceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class FileReaderTest {

  private final FileReader underTest = new FileReader();

  @Test
  public void shouldConcatenateLinesInAFileGivenFileExists() throws Exception {
    String testFileContents = underTest.readFile("example-text.txt");

    assertThat(testFileContents).isEqualTo("Text that has been joined to all be on one line");
  }

  @Test
  public void shouldThrowRuntimeExceptionGivenFileDoesNotExist() {
    assertThatThrownBy(() -> underTest.alternativeReadFile("a totally made up file name.txt"))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("Could not find file");
  }
}
