import java.io.*;


/**
 * 풀이 과정:
 * 점화식 뽑아내는 과정:
 * 분석:
 * 1 1 -> 1
 *
 * 2 1+1 2 -> 2
 *
 * 3 -> 4
 * 1+1+1
 * 1+2
 * 2+1
 * 3
 *
 *
 * 4 -> 7
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 1+3
 * 2+1+1
 * 2+2
 * 3+1
 *
 * 5 -> 13
 * 1+1+1+1+1
 * 1+1+1+2
 * 1+1+2+1
 * 1+2+1+1
 * 1+2+2
 * 1+3+1
 * 1+1+3
 * 2+1+1+1
 * 2+2+1
 * 2+1+2
 * 2+3
 * 3+1+1
 * 3+2
 *
 * 6 -> 24
 *
 * 7-> 44
 * 결과:
 * d[n] = d[n-1] + d[n-2] + d[n-3]
 * 1. 위 분석 및 검증 과정을 통해 점화식 결과를 뽑아내었고, 이 점화식으로 DP bottom-up 방식으로 메모이제이션을 해서 풀었습니다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new long[n+1];
            if(n == 0){
                bw.write(0 + "\n");
            } else if(n == 1){
                bw.write(1 + "\n");
            }else if(n==2){
                bw.write(2 + "\n");
            }else{
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for(int j=4; j<n+1; j++){
                    dp[j] = (dp[j-1]+dp[j-2]+dp[j-3])%1000000009;
                }
                bw.write(dp[n] + "\n");
            }

        }
        br.close();
        bw.close();


    }

}
