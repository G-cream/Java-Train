import java.util.HashMap;
import java.util.Map;

public class PermutationCheck {

	private static final int MAX_LENGTH = 100000;

	public int solution(int[] A, int N) {
		if (N > MAX_LENGTH) {
			return -1;
		}

		Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		long currentSum = 0;
		long expectSum = N * (N + 1) / 2; // sum(1, 2, .. n) => n(n+1)/2
		Boolean exsistedFlag;
		for (int a : A) {
			currentSum = currentSum + a;
			exsistedFlag = hashMap.get(a);
			if (exsistedFlag == null) {
				hashMap.put(a, true);
			} 
			else {
				return 0;
			}
		}
		if(currentSum == expectSum)
			// is permutation
			return 1;
		// not permutation
		return 0;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		PermutationCheck pc = new PermutationCheck();
		System.out.println(pc.solution(A, 4));
		int[] B = { 6, 5, 4 };
		PermutationCheck pc1 = new PermutationCheck();
		System.out.println(pc1.solution(B, 4));
	}
}
