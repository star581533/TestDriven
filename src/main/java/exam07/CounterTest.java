package exam07;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

	@Test
	public void testBasicFunctionality() throws Exception{
		Counter counter = new Counter();
		Assert.assertEquals(0, counter.value());
		counter.increment();
		Assert.assertEquals(1, counter.value());
		counter.increment();
		Assert.assertEquals(2, counter.value());
	}
}
