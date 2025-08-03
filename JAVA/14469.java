import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 도착시간과 검문시간을 받고, 도착시간 기준으로 오름차순 정렬해서, 먼저 도착한 소를 검사한다
 * 2. 만약 ans보다 도착시간이 크다면 도착시간 + 검문시간을 ans로 하고 아니라면 검문시간을 더해주면 도니다
 * 3. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
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
        int ans = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < n; i++) {
            if(ans < arr[i][0]){
                ans = arr[i][0] + arr[i][1];
            }else{
                ans += arr[i][1];
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
