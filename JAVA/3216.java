import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1.누적합으로 해당 노래까지 재생한 시간이랑 다운로드 한시간을 2차원 배열로 관리한다
 * 2. 이후, 맨 뒤에서부터 확인하는데 모든 노래를 끊김없이 들어야 하므로 최댓값을 확인해야한다
 * 3. 따라서 그 전곡보다 작은 수면 다음곡을 들을 때 끊기므로 현재 위치에서의 다운로드 하는 시간에서 그 이전의 재생하는 시간을 뺀값과 ans를 비교 해서 더 큰 값으로 갱시한다
 * 4. 완성한 결과를 출력하면 정답이 된다
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
        int[][] arr = new int[n+1][2];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()) + arr[i-1][0];
            arr[i][1] = Integer.parseInt(st.nextToken()) + arr[i-1][1];
        }
        int idx = n;
        int ans = 0;
        while(idx > 0){
            ans = Math.max(ans, arr[idx][1] - arr[idx - 1][0]);
            idx--;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
