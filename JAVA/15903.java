import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 우선순위 큐를 이용하는 문제이다.
 * - 우선순위 큐를 이용하여 들어오는 입력값이 자동으로 오름차순 정렬되게 한다
 * - x와 y는 가장 두수가 뽑혀야지 가장 작은 점수를 만들 수 있다. 이 부분이 우선순위 큐를 오름차순 정렬로 사용하게 되는 이유 중 하나이다
 * - x와 y를 더하고 각각을 더한 sum값으로 초기화한 뒤 다시 우선순위 큐에 넣어준다. 참고로 앞선 x와 y는 poll로 뽑아낸 가장 작은 두 수이다
 * - 이 방법을 m번 순회하여 진행한다. sum이 들어갈 때, 기존 가장 작은 두수가 sum으로 바뀌면서 다시 오름차순 정렬되기 때문에 다시 정렬을 할 필요가 없다.
 * - 이제 마지막으로 우선순위 큐에 있는 모든 수를 뽑아서 ans에 더해주고 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            pq.offer(a);
        }

        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x+y;
            x = sum;
            y = sum;
            pq.add(x);
            pq.add(y);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += pq.poll();
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

}

