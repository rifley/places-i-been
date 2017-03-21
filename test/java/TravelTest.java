import org.junit.*;
import static org.junit.Assert.*;

public class TravelTest {

  @Test
  public void Travel_instantiatesTravelList(){
    Travel myTravel = new Travel("Moscow, Russia");
    assertEquals(true, myTravel instanceof Travel);
  }

  @Test
  public void Travel_getsDestination_String() {
    Travel myTravel = new Travel("Moscow, Russia");
    assertEquals("Moscow, Russia", myTravel.getDestination());
  }
}
