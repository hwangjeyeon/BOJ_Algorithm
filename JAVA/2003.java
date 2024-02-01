import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 투포인터와 누적합 알고리즘을 활용해서 풀었습니다
 * - sum이 m보다 크거나 같으면 현재 start위치의 값을 빼고 값을 증가시킨다
 * - sum이 m보다 작으면 end위치의 값을 빼고 값을 증가시킨다
 * - sum이 m과 같으면 count 값을 증가시킨다
 * - 종료조건은 end랑 n이 같은 경우이다.
 * - 참고로 end == n일때 종료조건을 else if로 두번째에 놔야하는데 그 이유는 end==n일지라도 start 포인터를 이용하여 sum>=m일때 탐색할 구간이 남아있을 수 있기 때문이다
 * - 위 조건을 만족하도록 하여 count를 출력하면 정답이 된다.
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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;
        while(true){
            if(sum >= m){
                sum -= arr[start];
                start++;
            }else if(end == n){
                break;
            }else{
                sum += arr[end];
                end++;
            }

            if(sum == m){
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
