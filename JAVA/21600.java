import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 투포인터로 해결하였다.
 * 2. count를 매 순회마다 증가시키며 arr[i]와 비교한다. 만약 count가 더 크면 순회를 통해 count-- start++해준다
 * 3. start는 계단의 길이 범위가 시작하는 지점으로 투포인터의 left를 말한다
 * 4. 위 과정이 끝나고나서 max와 count를 비교해서 더 큰 값을 max에 넣는다
 * 5. 이렇게 완성한 max를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
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
        int max = 0;
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            count++;
            while(count > arr[i]){
                count--;
                start++;
            }
            max = Math.max(max, count);
        }

        bw.write(max+"");


        br.close();
        bw.close();
    }

}

