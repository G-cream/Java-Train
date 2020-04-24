public class RotateArray {

	public int[] Solution(int[] A, int N, int K) {
		K %= N;
		reverse(A, 0, N - 1);
		reverse(A, 0, K - 1);
		reverse(A, K, N - 1);
		for (int i : A)
			System.out.print(i + " ");
		return A;
	}

	public void reverse(int[] array, int begin, int end) {
		while (begin < end) {
			int temp = array[begin];
			array[begin] = array[end];
			array[end] = temp;
			++begin;
			--end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println("Begin:");
		for (int i : arr)
			System.out.print(i + " ");
		
		RotateArray ra = new RotateArray();
		System.out.println("\nAfter:");
		ra.Solution(arr, 3, 1);
	}
}
