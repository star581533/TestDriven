package exam07;

/**
 * 代碼清單7-9
 * 在單線程情況下正確的實現
 */
public class Counter{
	
	private int counter;
	
	public void increment(){
		counter++;
	}
	
	public int value(){
		return counter;
	}
}
