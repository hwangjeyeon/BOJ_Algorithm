import java.io.*;


/**
 * 풀이 과정:
 * 중간고사 종료 후 이차원 배열을 활용한 DP공부할 예정, 그 이전까지는 점화식 추리하는 문제거나 Math.max or Math.min 문제 복습겸 풀 예정
 * - 이 문제는 점화식이 이미 주어졌기 떄문에 그냥 그대로 구현하면 된다
 * t(0)=1
 * t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)
 * 따라서,
 * dp[i] += dp[j]*dp[i-j-1]; 라는 점화식으로 쉽게 도출을 할 수 있다.
 * 
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        dp = new long[n+1];
        if(n == 0){
            dp[0] = 1;
        }else if(n==1){
            dp[1] = 1;
        }else if(n==2){
            dp[2] = 2;
        }else{
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<n+1; i++){
                for(int j=0; j<i; j++){
                    dp[i] += dp[j]*dp[i-j-1];
                }
            }
        }

        bw.write(dp[n]+"");
        bw.close();
    }

}
