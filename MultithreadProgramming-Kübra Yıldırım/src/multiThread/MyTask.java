package multiThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyTask implements Runnable {

	private Object LOCK = new Object();
	private List<Integer> single = new ArrayList<Integer>(1000);
	private List<Integer> dual = new ArrayList<Integer>(1000);
	private boolean live = true;

	private List<Integer> arrlist = new ArrayList<Integer>(1000);

	private List<Integer> subList1 = arrlist.subList(0, 250);
	private List<Integer> subList2 = arrlist.subList(250, 500);
	private List<Integer> subList3 = arrlist.subList(500, 750);
	private List<Integer> subList4 = arrlist.subList(750, 1000);

	@Override
	public void run() {

		synchronized (LOCK) {

			if (Thread.currentThread().getName() == "t1") {
				Iterator<Integer> itr = subList1.iterator();
				while (itr.hasNext()) {
					int a = itr.next();
					if (a % 2 == 0) {
						dual.add(a);
					} else {
						single.add(a);
					}

				}

			}

			else if (Thread.currentThread().getName() == "t2") {
				Iterator<Integer> itr = subList2.iterator();
				while (itr.hasNext()) {
					int a = itr.next();
					if (a % 2 == 0) {
						dual.add(a);
					} else {
						single.add(a);
					}

				}

			}

			else if (Thread.currentThread().getName() == "t3") {
				Iterator<Integer> itr = subList3.iterator();
				while (itr.hasNext()) {
					int a = itr.next();
					if (a % 2 == 0) {
						dual.add(a);
					} else {
						single.add(a);
					}
				}

			}

			else {
				Iterator<Integer> itr = subList4.iterator();
				while (itr.hasNext()) {
					int a = itr.next();
					if (a % 2 == 0) {
						dual.add(a);
					} else {
						single.add(a);
					}

				}

			}

		}

		synchronized (this) {
			this.notifyAll();
		}

	}

	public void stop() {
		this.live = false;
		printArrayList();
	}

	public void printArrayList() {
		printDualArrayList();
		System.out.println(" ");
		printSingleArrayList();
		System.out.println(" ");
	}

	public int Done() throws InterruptedException {
		synchronized (this) {
			if (!live) {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				this.wait();

			}
		}
		return this.Done();

	}

	public void printDualArrayList() {
		Iterator<Integer> itr = dual.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();

	}

	public void printSingleArrayList() {
		Iterator<Integer> itr1 = single.iterator();
		while (itr1.hasNext()) {
			Object element1 = itr1.next();
			System.out.print(element1 + " ");
		}
		System.out.println();

	}
}
