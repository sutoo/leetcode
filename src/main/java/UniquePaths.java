/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p/>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p/>
 * How many possible unique paths are there?
 * <p/>
 * Created by sutao on 14/11/26.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        return uniquePathsInner(m, n, cache);
    }

    private int uniquePathsInner(int m, int n, int[][] cache) {
        if (m == 1 || n == 1) return 1;
        int value = cache[m - 1][n - 1];
        if (value > 0) {
            return value;
        }

        value = uniquePathsInner(m - 1, n, cache) + uniquePathsInner(m, n - 1, cache);
        cache[m - 1][n - 1] = value;
        return value;
    }
}
