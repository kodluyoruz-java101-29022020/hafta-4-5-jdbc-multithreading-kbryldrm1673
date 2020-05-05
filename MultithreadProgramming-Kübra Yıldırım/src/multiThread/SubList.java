package multiThread;

import java.util.ArrayList;
import java.util.List;

public class SubList {

	public static void main(String[] args) {
		try {

			List<Integer> arrlist = new ArrayList<Integer>(1100);

			List<Integer> subList1 = arrlist.subList(0, 250);
			List<Integer> subList2 = arrlist.subList(250, 500);
			List<Integer> subList3 = arrlist.subList(500, 750);
			List<Integer> subList4 = arrlist.subList(750, 1000);

			for (int i = 1; i <= 1000; i++) {

				arrlist.add(i);

			}

			System.out.println("Original arrlist: " + arrlist);

		}

		catch (IndexOutOfBoundsException e1) {
			System.out.println("Exception thrown : " + e1);
		}

		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown : " + e);
		}

	}

}
