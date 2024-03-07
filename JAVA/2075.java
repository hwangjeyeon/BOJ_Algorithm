import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 메모리가 너무 적어서 배열로 하면 메모리 초과가 일어날 것 같아 우선순위 큐를 사용해서 풀었다.
 * 2. 내림차순 정렬한 뒤, n만큼 다시 순회해서 ans에 값을 저장한 뒤 출력하면 된다
 * 3. 근데 주어진 입력값으로는 배열로 해도 메모리 초과는 발생하지 않는다...
 * 4. 정리할 때, 관련 내용을 깊게 정리할 계획이다.
 *
 * - 문제 해결:
 * 1. 정리할 때, 배열의 특징, 우선순위큐의 특징 정리 및 비교할 것
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = pq.poll();
        }
        bw.write(ans+"");
        br.close();
        bw.close();
    }

}

