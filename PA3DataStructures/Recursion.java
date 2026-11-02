public class Recursion {

	public static int sumEvenDigits(int n) { // complete this function
		if (n < 10){
			if (n % 2 == 0){
				return n;
			}
			else return 0;
		}
		else{
			int digit = n % 10;
			if (digit % 2 == 0){
				return digit + sumEvenDigits(n / 10);
			}
			else{
				return sumEvenDigits(n / 10);
			}
		}
	}

	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}

	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) { // complete this function
		if ((str.length() == n) && (numOnes > numZeroes)){
			System.out.println(str);
			return;
		}
		else if (str.length() < n){
			binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n);
			binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n);
		}
	}
}