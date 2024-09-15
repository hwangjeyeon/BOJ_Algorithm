import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 누적합을 이용하는 문제다. 어떻게 보면 시그마식을 이해하면 누적합을 이용하여 쉽게 풀었을 것 같다
 * 2. 입력값 배열과 누적합 배열을 두개 만들어서 관리한다
 * 3. 정답을 위한 long타입의 ans 변수를 하나 선언한다
 * 4. 이어서 탐색을 시작하는데 a는 현재 값이고, b는 현재값부터 n까지의 합산이다. 이 둘을 곱해야한다
 * 5. arr[i]를 a로 잡고 sum[n] - sum[i]을 한다면 4번을 만족하게 된다
 * 6. 따라서 누적합을 이용하여 ans를 더해가며 구한다면 정답을 구할 수 있다
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
        int[] sum = new int[n+1];


        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += (long) (sum[n] - sum[i]) * arr[i];
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

