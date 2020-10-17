import java.util.*;

public class Main5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String type = input.next();
		int size = input.nextInt();
		Object key = new Object();
		int elementIndex = -1;

		if ("Integer".equals(type)) {
			Integer[] list = new Integer[size];
			for (int i = 0; i < list.length; i++) {
				list[i] = input.nextInt();
			}
			key = input.nextInt();
			elementIndex = binarySearch(list, (Integer) key);

		} else if ("Double".equals(type)) {
			Double[] list = new Double[size];
			for (int i = 0; i < list.length; i++) {
				list[i] = input.nextDouble();
			}
			key = input.nextDouble();
			elementIndex = binarySearch(list, (Double) key);

		} else if ("Character".equals(type)) {
			Character[] list = new Character[size];
			for (int i = 0; i < list.length; i++) {
				list[i] = input.next(".").charAt(0);
			}
			key = input.next(".").charAt(0);
			elementIndex = binarySearch(list, (Character) key);

		} else if ("String".equals(type)) {
			String[] list = new String[size];
			for (int i = 0; i < list.length; i++) {
				list[i] = input.next();
			}
			key = input.next();
			elementIndex = binarySearch(list, (String) key);
		}
		if (elementIndex == -1) {
			System.out.println("Not found.");
			input.close();
			return;
		}
		if ("Double".equals(type)) {
			System.out.printf("%.3f is found in the %d'th place.\n", key, elementIndex);

		} else {
			System.out.println(key + " is found in the " + elementIndex + "'th place.");
		}

		input.close();
	}

	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		Arrays.sort(list);
		int min = 0, max = list.length - 1, mid = (min + max) / 2;
		while (min <= max) {
			mid = (min + max) / 2;
			if (key.compareTo(list[mid]) == 0) {
				return mid;
			} else if (key.compareTo(list[mid]) < 0) {
				max = mid - 1;
			} else if (key.compareTo(list[mid]) > 0) {
				min = mid + 1;
			}
		}
		return -1;
	}

}