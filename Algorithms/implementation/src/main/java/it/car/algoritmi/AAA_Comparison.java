package it.car.algoritmi;

import java.util.Arrays;


public class AAA_Comparison {

	public static void main(String args[]){

		//		Random randomGenerator = new Random();
		//		for (int idx = 1; idx <= 500; ++idx){
		//			int randomInt = randomGenerator.nextInt(10000);
		//			System.out.print(randomInt + ", ");
		//		}

		//		data = data_test;

		long start;

		// BubbleSort
		start = System.nanoTime();
		int[] bubbleRes = BubbleSort.sort(Arrays.copyOf(data, data.length));
		System.out.println("BubbleSort:     " + (System.nanoTime() - start));

		//SelectionSort
		start = System.nanoTime();
		int[] selRes = SelectionSort.sort(Arrays.copyOf(data, data.length));
		System.out.println("SelectionSort:   " + (System.nanoTime() - start));

		//InsertionSort
		start = System.nanoTime();
		int[] insertRes = InsertionSort.sort(Arrays.copyOf(data, data.length));
		System.out.println("InsertionSort:  " + (System.nanoTime() - start));

		//ShellSort
		start = System.nanoTime();
		int[] shellRes = ShellSort.sort(Arrays.copyOf(data, data.length));
		System.out.println("ShellSort:       " + (System.nanoTime() - start));

		//MergeSort
		start = System.nanoTime();
		int[] mergeRes = MergeSort.sort(Arrays.copyOf(data, data.length));
		System.out.println("MergeSort:       " + (System.nanoTime() - start));

		for(int i = 0 ; i < data.length; i++){
			if(bubbleRes[i] != selRes[i] || selRes[i]!= insertRes[i] || insertRes[i] != shellRes[i] || shellRes[i] != mergeRes[i]){
				System.out.println("ERRORE");
				break;
			}
		}

	}

	static int[] data_test = new int[]{101, 1, 67, 2, 23, 90};

	static int[] data = new int[]{5479, 5248, 7543, 6522, 2713, 4927, 6325, 580, 6603, 6331, 
		3106, 127, 5386, 1807, 25, 6972, 4649, 6006, 7472, 3081, 1068, 
		8463, 8781, 1416, 52, 3200, 5506, 2747, 8130, 1735, 4198, 8875, 
		506, 4012, 2418, 9719, 9622, 9490, 9428, 1674, 1283, 4124, 4339, 
		6869, 6108, 7372, 8257, 5036, 7122, 3991, 7366, 1117, 6868, 7092, 
		1374, 7658, 4705, 5827, 2065, 7960, 2215, 8330, 3626, 3744, 2278, 
		8587, 8423, 18, 5351, 8465, 5564, 3978, 3987, 4009, 2292, 2027, 
		6881, 5054, 8806, 343, 3119, 3132, 8560, 4496, 971, 1062, 50, 361, 
		7007, 195, 1561, 4470, 2424, 547, 8134, 9587, 1361, 3200, 2411, 2128, 
		9873, 7920, 9793, 3257, 1229, 4646, 1833, 7699, 6347, 9416, 5005, 8146, 
		7380, 9483, 6242, 9192, 2645, 9450, 141, 8057, 3123, 4086, 2383, 9706, 4136, 
		3079, 8302, 7895, 526, 433, 1313, 7699, 3447, 6962, 9495, 3418, 4535, 7607, 
		4693, 6755, 4926, 8110, 7434, 2849, 3846, 1735, 8561, 4633, 213, 4083, 8147, 
		2509, 4271, 5919, 2998, 4199, 2284, 6746, 6709, 9634, 5233, 1089, 7117, 3457, 
		8190, 1979, 3330, 1651, 5843, 3840, 5660, 9582, 704, 7142, 833, 648, 7703, 
		6755, 5840, 581, 6560, 9318, 9159, 6907, 7817, 9137, 82, 1985, 4600, 7087, 
		6545, 1494, 1695, 2611, 5588, 6749, 6682, 8225, 4406, 8774, 9671, 8725, 4515, 
		8184, 2467, 1633, 3446, 9323, 3101, 2821, 9732, 2354, 6361, 2647, 4815, 1125, 
		1300, 6098, 2232, 333, 5375, 4522, 5188, 6312, 3402, 1645, 3258, 5884, 5918, 9493};

}
