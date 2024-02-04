import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문제 이해가 중요한 문제이다.
 * - 문제의 핵심 포인트는 나와 내 오른쪽 인덱스의 차이가 1만 나야한다는 조건을 만족시켜야한다는 것이다
 * - 오른쪽부터 차례대로 감소하며 순회하는 반복문에서 내 오른쪽보다 크거나 같다면 그 크기를 구해서 정답에 더해주고 현재 값도 바꿔주면 된다.
 * - 이렇게 완성한 정답을 출력하면 된다
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
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for (int i = n-2; i >=0; i--) {
            if(arr[i] >= arr[i+1]){
                ans += arr[i]-(arr[i+1]-1);
                arr[i] = arr[i+1]-1;
            }
        }


        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}
