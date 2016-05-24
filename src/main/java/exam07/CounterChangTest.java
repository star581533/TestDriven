package exam07;

import java.util.concurrent.CyclicBarrier;

import org.junit.Assert;
import org.junit.Test;

/**
 * 代碼清單7-11
 * 改進後的測試
 */
public class CounterChangTest {

	@Test
	public void testForThreadSafetUsingCyclicBarrierToMaximizeConcurrency() throws Exception{
		final Counter codeUnderTest = new Counter();
		final int numberOfThreads = 20;
		final int incrementsPerThread = 100;
		//為正創康的線程創建barrier並加上當前線程
		CyclicBarrier entryBarrier = new CyclicBarrier(numberOfThreads + 1);
		CyclicBarrier exitBarrier = new CyclicBarrier(numberOfThreads + 1);		
		
		Runnable runnable = new Runnable(){
			public void run() {
				for(int i=0; i<incrementsPerThread; i++){
					codeUnderTest.increment();
					System.out.println(codeUnderTest.value());
				}
			}			
		};
		//定制線程在barrier處等待
		for(int i=0; i<numberOfThreads; i++){
			new SynchedThread(runnable, entryBarrier, exitBarrier).start();
		}
		
		Assert.assertEquals(0, codeUnderTest.value());
		entryBarrier.await();		//線程開始執行
		exitBarrier.await();		//等待所有線程結束
		Assert.assertEquals(numberOfThreads * incrementsPerThread, codeUnderTest.value());		
	}
}
