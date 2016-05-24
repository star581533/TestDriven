package exam07;

import java.util.concurrent.CyclicBarrier;

/**
 * 代碼清單7-12
 * 同步執行的自定義線程類
 */
public class SynchedThread extends Thread{
	private CyclicBarrier entryBarrier;
	private CyclicBarrier exitBarrier;
	
	public SynchedThread(Runnable runnable, CyclicBarrier entryBarrier, CyclicBarrier exitBarrier){
		super(runnable);
		this.entryBarrier = entryBarrier;
		this.exitBarrier = exitBarrier;
	}
	
	@Override
	public void run() {
		try{
			entryBarrier.await();	//等待其他線程
			super.run();			//執行
			exitBarrier.await();	//暗示完成
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
}
