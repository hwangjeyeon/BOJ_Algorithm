import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진대로 단순 포문으로 해결하면 된다
 * 2. 단 지그재그 수열의 최소가 2라는 점만 확인해서 최댓값을 찾으면 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
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
        int max = 2, ans = 2;
        for (int i = 0; i < n - 2; i++) {
            if(arr[i] <= arr[i+1] && arr[i+1] <= arr[i+2]){
                ans = 2;
            }else if(arr[i] >= arr[i+1] && arr[i+1] >= arr[i+2]){
                ans = 2;
            }else{
                ans++;
            }
            max = Math.max(max, ans);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }
}

