package bikeshop;

public class Bike {

  private boolean working;

  public Bike() {
    this.working = true;
  }

  public boolean isWorking() {
    return working == true;
  }

  public boolean isBroken() {
    return working == false;
  }

  public void repair() {
    if (!isWorking()) {
      this.working = true;
    }
  }

}
