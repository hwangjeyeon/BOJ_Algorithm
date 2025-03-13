import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 오늘 릿코드 데일리문제에서 접한 누적합의 차분배열 개념을 적용하면 쉽게 풀 수 있다
 * 2. 차분 배열의 경우, 특정 구간에 합/차를 적용해야하는데 시간초과가 발생할 때 활용할 수 있는 개념이다
 * 3. 누적합 배열을 만들어서 시작과 끝+1 지점에 합과 차를 적용해두고, 끝나고 난뒤 n만큼 순회하며 이전값과 현재 누적값을 더해 현재 누적합 배열의 값을 갱신하면 된다
 * 4. 이후 누적합 배열을 활용해서 arr배열을 갱신하고 출력하면 정답이 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n+2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            sum[a] += val;
            sum[b+1] -= val;
        }

        for (int i = 1; i < n+1; i++) {
           sum[i] = sum[i-1] + sum[i];
        }
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i] + sum[i];
        }

        for (int i = 1; i < n + 1; i++) {
            bw.write(arr[i] + " ");
        }

        br.close();
        bw.close();
    }

}
