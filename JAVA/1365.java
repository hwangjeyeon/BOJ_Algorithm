import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS + 이분탐섹 유형의 문제다
 * 2. 출력만 변형하면 된다. 최대 길이 결과를 구한다음 N에서 빼준 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*logn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if(dp[len-1] < arr[i]){
                dp[len++] = arr[i];
            }else{
                int left = 0;
                int right = len-1;
                while(left < right){
                    int mid = (left + right)/2;
                    if(dp[mid] < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                dp[left] = arr[i];
            }
        }
        bw.write((n-len) + "");

        br.close();
        bw.close();
    }

}
