package bikeshop;

public class Bike {

  private boolean working;

  public Bike() {
    this.working = true;
  }

  public boolean isWorking() {
    return working;
  }

  public void repair() {
    if (!isWorking()) {
      this.working = true;
    }
  }

}
