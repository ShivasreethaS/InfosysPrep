import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[K + 1][N + 1];

        // Length 1
        for (int num = 1; num <= N; num++) {
            dp[1][num] = 1;
        }

        // Build longer arrays
        for (int len = 2; len <= K; len++) {

            for (int previous = 1; previous <= N; previous++) {

                // Try multiples of previous
                for (int next = previous; next <= N; next += previous) {

                    dp[len][next] += dp[len - 1][previous];
                    dp[len][next] %= 10000;
                }
            }
        }

        int answer = 0;

        for (int num = 1; num <= N; num++) {
            answer += dp[K][num];
        }

        System.out.println(answer % 10000);

        sc.close();
    }
}
