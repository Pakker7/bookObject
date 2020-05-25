package part13.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class reentrantlock {

	private final ReentrantLock locker = new ReentrantLock(); 
	private final Condition lockerCondition = locker.newCondition();

	public void method () { 
		locker.lock();
		
		try { 
			// 동기화내용들... 
			lockerCondition.await();
			lockerCondition.signal();
			lockerCondition.signalAll();
		} catch (Exception e) { 
			 
		} finally { 
			locker.unlock(); 
		
		}
	}
}
