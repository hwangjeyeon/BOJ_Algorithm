import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 누적합 알고리즘을 이용해서 풀었다.
 * - 배열에 값을 저장하고 처음을 제외한 이후 모든 인덱스는 이전 인덱스의 값을 더해준다
 * - start와 end를 각각 입력받고 end 인덱스의 값을 start-1 인덱스의 값에서 뺀 ans 변수를 정답으로 출력하면 정답이 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i != 1){
                arr[i] += arr[i-1];
            }
        }
        int m = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ans = arr[end] - arr[start-1];
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}
