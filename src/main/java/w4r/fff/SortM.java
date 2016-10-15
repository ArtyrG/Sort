package w4r.fff;

import java.util.ArrayList;

public class SortM {
	
	public static void main(String[] args) {
		final int RAND = (int) (Math.random() * 12 + 5); // случайное число от
															// [5; 16], задает
															// размер массива
		ArrayList<Integer> massAr = new ArrayList<Integer>(RAND);

		int[] massiv = new int[RAND];
		System.out.println("Случайный массив для обычного массива : ");
		for (int i = 0; i < RAND; i++) {
			massiv[i] = (int) (Math.random() * 12); // заполняем массив
													// случайными числами от
													// [0;11]
			massAr.add((int) (Math.random() * 12));
			System.out.print(massiv[i] + " ");
		}
	

		SortM sort = new SortM();

		System.out.println();
		System.out.println();
		System.out.println("Методы для обычного массива : ");
		sort.sortMassiv(massiv);
		//12345679
		//кто здесь
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

}