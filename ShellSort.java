import java.util.Random;

public class ShellSort {

	// Method 0
	public static void main(String args[]) {
		int array500[] = new int[500];
		int array10K[] = new int[10000];
		int array20K[] = new int [20000] ; 
		int array50K[] = new int [50000] ; 
		
		initialize(500, array500) ; 
		initialize(10000, array10K) ; 
		initialize(20000, array20K) ; 
		initialize(50000, array50K) ; 
		
	
		System.out.println("SHELL SORT DURATION (miliseconds):");
		System.out.println("500 Elements: " + currentTimeMillis(array500)) ; 
		System.out.println("10K Elements: " + currentTimeMillis(array10K)) ; 
		System.out.println("20K Elements: " + currentTimeMillis(array20K)) ;
		System.out.println("50K Elements: " + currentTimeMillis(array50K)) ;
		
		
		

	}
	public static long currentTimeMillis(int array[]) {
		long startTime = System.currentTimeMillis();

		shellSort(array) ; 

		long endTime = System.currentTimeMillis();
		long timeItTook = endTime - startTime ; 
		
		return timeItTook ; 
	}
	
	public static void initialize (int x, int array[]) {
		Random random = new Random();
		for (int i = 0; i < x; i++) {
			int rand = random.nextInt(1000);
			array[i] = x;

		}
	}
	

	public static int kMaxValue(int size) {

		int maxValue = 0;

		for (int i = 1; i < size; i = (i * 3) + 1) {
			maxValue = i;

		}
		
		return maxValue;

	}

	
	public static void kSortValues(int[] array, int startIndex, int k) {

		for (int nextInt = 0; nextInt < array.length - k; nextInt++) {

			for (int i = nextInt; i < array.length; i += k) {
				int eye = i;

				while (eye >= k && array[eye] < array[eye - k]) {

					int temp = array[eye];
					array[eye] = array[eye - k];
					array[eye - k] = temp;
					eye -= k;

				}

			}

		}

	}

	public static void shellSort(int[] array) {

		for (int i = kMaxValue(array.length); i >= 1; i = (i - 1) / 3) {

			kSortValues(array, kMaxValue(array.length), i);
		}
	

	

	}

}
