package w4r.fff;

import java.util.ArrayList;

public class Second {
	

		
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
		

			Second sort = new Second();

			System.out.println();
			System.out.println();
			System.out.println("Методы для обычного массива : ");
			sort.sortMassiveRasch(massiv);
			
			

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
		
	}