package year2021.month7.jz60;

import java.util.Arrays;

public class DicesProbability {

    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;
        System.out.println(Arrays.toString(dicesProbability(n1)));
        System.out.println(Arrays.toString(dicesProbability(n2)));
    }

    public static double[] dicesProbability(int n) {
        /*
         * DP, time is O(n^2), space is O(n)
         * 状态定义：
         * dp[n,k]为共有 n 个骰子，摇出来的和为 k 的概率
         * 状态转移方程：
         * dp[n,k] = sum{ dp[n-1, k-i] * (1/6) }, i = 1, 2, ..., 6
         * 另，n 个骰子，和范围为[n, 6n]，故有 5n+1 中可能
         * */
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }

}

/*
* 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

 

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

 

示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 

限制：

1 <= n <= 11

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
