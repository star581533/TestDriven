package exam07;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

/**
 * 代碼清單7-13
 * 測試驗證線程受阻且已經執行完畢
 */
public class ThreadCheckTest {

	@Test
	public void testBlockingBehavior() throws Exception{
		final AtomicBoolean blocked = new AtomicBoolean();
		
		Thread buyer = new Thread(){
			@Override
			public void run() {
				//					new BlackMarket().buyTicket();
				blocked.set(false);
			}
		};
	}
}
