package bikeshop;

import java.util.List;

public class BikeShop {

  private List<Bike> bikes;

  public BikeShop(List<Bike> bikes) {
    this.bikes = bikes;
  }

  public List<Bike> getBikes() {
    return bikes;
  }

  public void addBike(Bike bike) {
    bikes.add(bike);
  }

  public boolean allWorking() {
    return getBikes().stream()
        .allMatch(Bike::isWorking);
  }

  public void repairBikes() {
    getBikes().stream()
        .filter(Bike::isBroken)
        .forEach(Bike::repair);
  }
}
