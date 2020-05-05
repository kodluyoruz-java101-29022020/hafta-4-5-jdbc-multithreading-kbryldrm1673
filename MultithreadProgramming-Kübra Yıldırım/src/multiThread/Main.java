package multiThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		MyTask task1 = new MyTask();
		Thread t1 = new Thread(task1);
		t1.start();

		MyTask task2 = new MyTask();
		Thread t2 = new Thread(task2);
		t2.start();

		

	

	}

}
