package exam07;

import org.junit.Assert;
import org.junit.Test;

/**
 * 代碼清單7-10
 * 啟動多個線程增加計數
 */
public class CounterAddTest {

	@Test
	public void testForThreadSafety() throws Exception{
		final Counter codeUnderTest = new Counter();
		final int numberOfThreads = 20;
		final int incrementsPerThread = 100;
		
		Runnable runnable = new Runnable(){
			public void run() {
				for(int i=0; i<incrementsPerThread; i++){
					codeUnderTest.increment();
				}
			}			
		};
		
		//啟動線程
		for(int i=0; i<numberOfThreads; i++){
			new Thread(runnable).start();
		}
		
		//等待線程結束並驗證Counter的數值
		Thread.sleep(5000);
		Assert.assertEquals(numberOfThreads * incrementsPerThread, codeUnderTest.value());
	}
}
