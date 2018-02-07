import java.util.*;
import org.junit.Test;

import junit.framework.Assert;

public class PythagoreanTripletsUnitTests {

	@Test
	public void test() {

		// Act
		List<int[]> triplets = Task5.getPythagoreanTriplets(10);
		
		
		// Assert
		Assert.assertEquals(triplets.size(), 2);
		
		int[] firstTriplet = triplets.get(0);
		Assert.assertEquals(3, firstTriplet[0]);
		Assert.assertEquals(4, firstTriplet[1]);
		Assert.assertEquals(5, firstTriplet[2]);
		
		int[] secondTriplet = triplets.get(1);
		Assert.assertEquals(6, secondTriplet[0]);
		Assert.assertEquals(8, secondTriplet[1]);
		Assert.assertEquals(10, secondTriplet[2]);
		
	}

}
