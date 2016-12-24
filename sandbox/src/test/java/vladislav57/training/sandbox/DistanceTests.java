package vladislav57.training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vlad on 24.12.2016.
 */
public class DistanceTests {

  @Test
  public void testDistance() {
    Point a = new Point(1.0, -2.0);
    Point b = new Point(4.0, 2.0);
    Assert.assertEquals(a.distanceTo(b), 5.0);
  }
}
