import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS + 이분탐색 문제디. DP를 최대길이로 설정해서 이전과 동일하게 구현해주면 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(t * N)
 * 공간복잡도: O(N)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int[] dp = new int[n];
            dp[0] = arr[0];
            int len = 1;
            for (int i = 1; i < n; i++) {
                if(dp[len-1] < arr[i]){
                    dp[len] = arr[i];
                    len++;
                }else{
                    int left = 0;
                    int right = len-1;
                    while(left < right){
                        int mid = (left + right) / 2;
                        if(dp[mid] < arr[i]){
                            left = mid + 1;
                        }else{
                            right = mid;
                        }
                    }
                    dp[left] = arr[i];
                }
            }
            bw.write(len+"\n");
        }

        br.close();
        bw.close();
    }

}
