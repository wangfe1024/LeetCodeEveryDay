package year2021.month7.jz10b;

public class NumWays {

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 7;
        int n3 = 0;
        System.out.println(numWays1(n1));
        System.out.println(numWays1(n2));
        System.out.println(numWays1(n3));
    }

    private static int numWays1(int n) {
        if (n < 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int ans = first + second;
        for (int i = 2; i <= n; i++) {
            ans = (first + second) % 1000000007;
            first = second;
            second = ans;
        }
        return ans;
    }

    public static int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}

/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1
提示：

0 <= n <= 100
注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
