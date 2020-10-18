
public class KMPService {

	public static void main(String[] args) {

		KMPService kmp = new KMPService();
		for (int i : kmp.getFailureArr("aabaabaaabc")) {
			System.out.print(i + " ");
		}
	}

	public int[] getFailureArr(String pattern) {
		char[] chars = pattern.toCharArray();
		int[] failureArr = new int[chars.length];
		int j = 0;
		failureArr[0] = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[j] == chars[i]) {
				failureArr[i] = ++j;
			} else {
				while (j > 0) {
					j = failureArr[--j];
					if (chars[j] == chars[i]) {
						failureArr[i] = failureArr[j] + 1;
						++j;
						break;
					}
					if (j == 0 && chars[j] != chars[i]) {
						failureArr[i] = 0;
					}
				}
			}
		}
		return failureArr;
	}

	public int[] getFailureArr1(String pattern) {
		char[] chars = pattern.toCharArray();
		int[] failureArr = new int[chars.length];
		int j = 0;
		failureArr[0] = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[j] == chars[i]) {
				j++;
				failureArr[i] = j;
			} else {
				while (j > 0) {
					j--;
					j = failureArr[j];
					if (chars[j] == chars[i]) {
						j++;
						failureArr[i] = j;
						break;
					}
					if (j == 0 && chars[j] != chars[i]) {
						failureArr[i] = 0;
					}
				}
			}
		}
		return failureArr;
	}

}
