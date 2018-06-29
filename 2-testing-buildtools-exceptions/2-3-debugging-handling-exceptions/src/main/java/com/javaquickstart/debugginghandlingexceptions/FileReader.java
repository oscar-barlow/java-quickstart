package com.javaquickstart.debugginghandlingexceptions;

import static java.lang.String.format;
import static java.lang.String.join;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

  public String readFile(String fileName) throws IOException {
    final Path filePath = getFilePath(fileName);
    final List<String> lines = Files.readAllLines(filePath);
    return join(" ", lines);
  }

  public String alternativeReadFile(String fileName) {
    try {
      final Path filePath = getFilePath(fileName);
      final List<String> lines = Files.readAllLines(filePath);
      return join(" ", lines);

    } catch (IOException e) {
      throw new RuntimeException(format("Could not read file with name: %s", fileName), e);
    }
  }

  private Path getFilePath(String fileName) {
    try {
      final ClassLoader classLoader = getClass().getClassLoader();
      final URL resource = classLoader.getResource(fileName);
      return Paths.get(resource.getPath());

    } catch (NullPointerException e) {
      throw new RuntimeException(format("Could not find file with name: %s", fileName), e);
    }
  }

}
