package dp;

public class Max_Dot_Product {

	public int maxDotProduct(int[] nums1, int[] nums2) {
		int dp[][][] = new int[nums1.length][nums2.length][2];
		for (int i = 0; i < nums1.length; i++) {

			for (int j = 0; j < nums2.length; j++) {
				dp[i][j][0] = -1;
				dp[i][j][1] = -1;

			}
		}
		return sol(nums1, 0, nums2, 0, 0, 0, dp);
	}

	public int sol(int a[], int i, int b[], int j, int sum, int k, int[][][] dp) {

		if (i >= a.length || j >= b.length) {
			return k == 1 ? 0 : Integer.MIN_VALUE / 2;
		}
		if (dp[i][j][k] != -1) {
			return dp[i][j][k];

		}

		int c1 = sol(a, i + 1, b, j + 1, sum, 1, dp); // Include both
		int c2 = sol(a, i + 1, b, j + 1, sum, k, dp); // Leave both
		int c3 = sol(a, i + 1, b, j, sum, k, dp); // i+1
		int c4 = sol(a, i, b, j + 1, sum, k, dp); // j+1

		return dp[i][j][k] = Math.max(c1 + a[i] * b[j], Math.max(c2, Math.max(c3, c4)));
	}

}
