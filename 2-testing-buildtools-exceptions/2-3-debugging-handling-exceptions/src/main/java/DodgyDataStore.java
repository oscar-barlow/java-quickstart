import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DodgyDataStore {

  private final Logger logger = LoggerFactory.getLogger("DodgyDataStore.class");

  public void save(String someData) {
    logger.error("Could not save data: " + someData);
  }


}
