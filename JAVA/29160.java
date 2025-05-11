import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 크기 12의 우선순위 큐 배열을 사용하면 쉽게 해결할 수 있다
 * 2. 조건은 배열에 들어가는 값들은 내림차순 정렬된다
 * 3. 먼저 n만큼의 값들을 우선순위 큐 배열에 넣어준다
 * 4. 그리고 k만큼 순회하면서 3월 8월 11월 작업을 진행한다
 * 5. 3월 작업은 8월 작업과 동시에 할 수 있다. 일단 각 포지션의 가장 큰값을 빼낸다음 -1한 값을 넣어준다. 음수가 되는 경우는 0으로 초기화해서 넣어준다
 * 6. 이어서 11월 작업을 진행한다 
 * 7. ans에 가장 큰 값을 뽑아서 더해주면된다
 * 8. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] pq = new PriorityQueue[12];
        for (int i = 0; i < 12; i++) {
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq[p].add(w);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = 0;
            for (int j = 1; j < 12; j++) {
                int a = 0;
                if(pq[j].peek() != null){
                    a = pq[j].poll();
                }
                pq[j].add(Math.max(a - 1, 0));

            }

            for (int j = 1; j < 12; j++) {
                if(pq[j].peek() != null){
                    ans += pq[j].peek();
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
