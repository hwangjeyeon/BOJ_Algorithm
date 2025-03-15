import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 포트간 연결할 때, 꼬이지 않으려면 번호가 증가하는 형태의 줄들을 고르면 된다
 * 2. 즉, LIS + 이분탐색으로 해결하면 되는 문제다
 * 3. 이분탐색 영역만 조금 정리하면 이분탐색 대상은 인덱스이고, 만약 dp[mid] < arr[i]라면 더 적합한 left를 찾기 위해 left = mid+1을 한다
 * 4. 크거나 같다면 정답을 찾기 위해 right = mid한다. 인덱스 범위를 벗어나지 않기 위해 mid-1은 하지 않는다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
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
                int right = len - 1;
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
        bw.write(len+"");

        br.close();
        bw.close();
    }

}
