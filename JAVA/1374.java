import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 리스트에 넣고 시작시간 순으로 정렬한다 -> 하나씩 뽑아서 종료시간 순으로 정렬되는 우선순위 큐에 배치한다
 * 2. 우선순위 큐가 비어있으면 리스트에 있는 값 넣고 최댓값 갱신 후 continue한다
 * 3. 아니면 만약 우선순위 큐의 peek값의 종료시간이 현재 입력값의 시작시간보다 작거나 같은지 확인한다
 * 4. 작거나 같은 동안 우선순위 큐에서 뽑아준다
 * 5. 이후 리스트의 값은 우선순위 큐에 넣고 정답을 최댓값으로 갱신한다
 * 6. 이후 아직 우선순위 큐에 남은 값과 비교해서 최댓값으로 갱신한다
 * 7. 최댓값 갱신은 우선순위 큐의 크기로 보면 된다
 * 8. 완성한 ans를 출력하면 정답이 된다
 * 9. 참고로 3번 과정에서 단순히 작은 경우만 비교하면 21%에서 틀린다. 반례는 아래와 같다
 * [반례]
 * 10
 * 1 1 10
 * 2 2 10
 * 3 3 10
 * 4 4 10
 * 5 5 10
 * 6 6 10
 * 7 7 10
 * 8 8 10
 * 9 9 10
 * 10 10 15
 * 10. 따라서 작거나 같은 값으로 비교해야한다. 이렇게 하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(m)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[2] - o2[2];
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b,c});
        }
        list.sort((o1,o2) -> {
            return o1[1] - o2[1];
        });

        for (int i = 0; i < list.size(); i++) {
            if(pq.isEmpty()){
                pq.add(list.get(i));
                ans = Math.max(pq.size(), ans);
                continue;
            }

            while(!pq.isEmpty() && pq.peek()[2] <= list.get(i)[1]) {
                pq.poll();
            }
            pq.add(list.get(i));
            ans = Math.max(pq.size(), ans);
        }
        ans = Math.max(pq.size(), ans);

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
