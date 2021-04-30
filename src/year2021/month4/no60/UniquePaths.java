package year2021.month4.no60;

public class UniquePaths {
    public static void main(String[] args) {
        int m1 = 3;
        int n1 = 7;
        System.out.println(uniquePaths(m1, n1));
        int m2 = 3;
        int n2 = 2;
        System.out.println(uniquePaths(m2, n2));
        int m3 = 7;
        int n3 = 3;
        System.out.println(uniquePaths(m3, n3));
        int m4 = 3;
        int n4 = 3;
        System.out.println(uniquePaths(m4, n4));

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}

/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

 

示例 1：


输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6
 

提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
