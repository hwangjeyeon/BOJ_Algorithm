import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 역으로 생각해서 풀면 되는 문제다
 * 2. 주어진 수의 합이 모두 0이 될 떄까지 역으로 홀수인 경우 -1하고, 짝수인경우 2로 나눠주면된다
 * 3. 도중에 0이 되는 경우가 있으면 반복문을 탈출하고 ans를 출력하면 정답이 된다.
 *
 *
 * 해결방법:
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
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int ans = 0;

        while(sum != 0){
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]%2 == 1){
                    arr[i]--;
                    tmp++;
                }
            }
            if(tmp != 0){
                sum -= tmp;
                ans += tmp;
                continue;
            }
            for (int i = 0; i < n; i++) {
                arr[i] /= 2;
            }
            sum /= 2;
            ans++;
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
