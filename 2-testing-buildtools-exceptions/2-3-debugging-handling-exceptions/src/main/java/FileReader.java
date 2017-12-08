import static java.lang.String.format;
import static java.lang.String.join;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

  public String readFile(String fileName) throws IOException {
    Path filePath = Paths.get("src/main/resources/" + fileName);
    List<String> lines = Files.readAllLines(filePath);
    return join(" ", lines);
  }

  public String alternativeReadFile(String fileName) {
    try {
      Path filePath = Paths.get("src/main/resources/" + fileName);
      List<String> lines = Files.readAllLines(filePath);
      return join(" ", lines);
    } catch (IOException e) {
      throw new RuntimeException(format("Could not find file with name: %s", fileName), e);
    }
  }

}
