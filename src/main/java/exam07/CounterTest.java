package exam07;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

	@Test
	public void testBasicFunctionality() throws Exception{
		Counter counter = new Counter();
		Assert.assertEquals(0, counter.value());
		
	}
}
