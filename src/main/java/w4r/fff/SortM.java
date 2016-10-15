package w4r.fff;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс Sort содержит в себе различные методы для сортировки массива по
 * возрастанию
 * 
 * @author Artyr
 * @version 1.0
 */

public class SortM {

	public static void main(String[] args) {
		final int RAND = (int) (Math.random() * 12 + 5); // случайное число от
															// [5; 16], задает
															// размер массива
		ArrayList<Integer> massAr = new ArrayList<Integer>(RAND);

		int[] massiv = new int[RAND];
		System.out.println("Случайный массив для  : ");
		for (int i = 0; i < RAND; i++) {
			massiv[i] = (int) (Math.random() * 12); // заполняем массив
													// случайными числами от
													// [0;11]
			massAr.add((int) (Math.random() * 12));
			System.out.print(massiv[i] + " ");
		}
		System.out.println();
		System.out.println("Случайный массив для ArrayList : ");
		for (int i = 0; i < RAND; i++) {
			System.out.print(massAr.get(i) + " ");
		}

		SortM sort = new SortM();

		System.out.println();
		System.out.println();
		System.out.println("Методы для обычного массива : ");
		sort.sortMassiv(massiv);
		sort.sortMassiveRasch(massiv);
		sort.sortMassiveSort(massiv);
		System.out.println();
		System.out.println();
		System.out.println("Методы для ArrayList: ");

	}

	/**
	 * Реалицация метода пузырька.
	 * 
	 * @param arrayToSort
	 * @return massiveSort
	 */

	int[] sortMassiv(int[] arrayToSort) {

		System.out.println();
		System.out.println("Метод пузырька : ");

		int[] massiveSort = arrayToSort;

		int temp = 0;
		long start = System.nanoTime();
		for (int i = 0; i < massiveSort.length; i++) {
			for (int j = 0; j < massiveSort.length; j++) {
				if (massiveSort[i] < massiveSort[j]) {
					temp = massiveSort[i];
					massiveSort[i] = massiveSort[j];
					massiveSort[j] = temp;
				}
			}
		}
		long finish = System.nanoTime();
		System.out.println("Время выполненыя сортировки :" + (finish - start) + "ns");

		for (int i : massiveSort) {
			System.out.print(i + " ");
		}

		return massiveSort;
	}

	/**
	 * Реалицация метода расческа.
	 * 
	 * @param arrayToSort
	 * @return massiveSort1
	 */

	int[] sortMassiveRasch(int[] arrayToSort) {

		final double FACTOR_DOWN = 1.247;
		int[] massiveSort1 = arrayToSort;
		System.out.println();
		System.out.println("Метод расческа : ");
		int step = (int) (massiveSort1.length / FACTOR_DOWN);
		int temp = 0;
		long start = System.nanoTime();

		for (int i = 0, j = step; j - i != 0;) {
			if (step == 0)
				break;
			int as = step;
			do {
				if (as == massiveSort1.length)
					break;
				if (i == massiveSort1.length)
					break;
				if (massiveSort1[i] > massiveSort1[as]) {
					temp = massiveSort1[i];
					massiveSort1[i] = massiveSort1[as];
					massiveSort1[as] = temp;
					continue;
				}
				i++;
				as++;
			} while (as != massiveSort1.length);
			i = 0;
			step /= FACTOR_DOWN;
		}
		long finish = System.nanoTime();
		System.out.println("Время выполненыя сортировки :" + (finish - start) + "ns");

		for (int i = 0; i < massiveSort1.length; i++) {
			System.out.print(massiveSort1[i] + " ");
		}

		return massiveSort1;
	}

	/**
	 * Готовый метод sort() для сортировки массива
	 * 
	 * @param arrayToSort
	 * @return massive
	 */

	int[] sortMassiveSort(int[] arrayToSort) {
		System.out.println();
		System.out.println("Метод Arrays.sort() : ");
		int[] massive = arrayToSort;

		long start = System.nanoTime();
		Arrays.sort(massive);
		long finish = System.nanoTime();
		System.out.println("Время выполненыя сортировки :" + (finish - start) + "ns");
		for (int s : massive) {
			System.out.print(s + " ");
		}
		return massive;
	}
}
