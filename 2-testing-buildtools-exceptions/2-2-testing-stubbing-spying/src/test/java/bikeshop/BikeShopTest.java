package bikeshop;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BikeShopTest {

  private BikeShop underTest;

  @Mock
  Bike bike1;

  @Mock
  Bike bike2;

  @Before
  public void setUp() throws Exception {
    List<Bike> bikes = new ArrayList<Bike>(asList(bike1, bike2));
    underTest = new BikeShop(bikes);
  }

  @Test
  public void shouldReturnTrueGivenAllBikesWork() throws Exception {
    Mockito.when(bike1.isWorking()).thenReturn(true);
    Mockito.when(bike2.isWorking()).thenReturn(true);

    assertTrue(underTest.allWorking());
  }

  @Test
  public void shouldReturnFalseGivenAtLeastOneBikeIsNotWorking() throws Exception {
    Bike bike3 = Mockito.mock(Bike.class);
    Mockito.when(bike3.isWorking()).thenReturn(false);
    underTest.addBike(bike3);

    assertFalse(underTest.allWorking());
  }

  @Test
  public void shouldRepairBrokenBikes() throws Exception {
    Bike bike3 = Mockito.mock(Bike.class);
    Mockito.when(bike3.isWorking()).thenReturn(false);
    underTest.addBike(bike3);

    underTest.repairBikes();

    Mockito.verify(bike3).repair();
    Mockito.verify(bike2, Mockito.never()).repair();
    Mockito.verify(bike1, Mockito.never()).repair();
  }
}