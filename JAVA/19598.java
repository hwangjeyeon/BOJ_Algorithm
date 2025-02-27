import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 어제 풀었던 문제와 동일한 풀이로 풀면 된다
 * 2. 시작시간으로 오름차순 정렬된 리스트로 입력값을 받고, 종료시간으로 정렬된 우선순위 큐에 넣는다
 * 3. 비어있으면 일단 넣고 최대길이를 비교하고 스킵한다
 * 4. 그 이외에는 만약 큐의 peek의 종료시간이 현재 시작시간보다 작거나 같은 동안 poll하고, 이후 현재 리스트이 값을 pq에 넣는다
 * 5. 그다음 pq의 크기를 비교해서 더 큰값을 ans에 넣는다
 * 6. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(nlogn)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.add(new int[]{a, b});
        }
        lists.sort((o1,o2) -> {
            return o1[0] - o2[0];
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(pq.isEmpty()){
                pq.add(lists.get(i));
                ans = Math.max(ans, pq.size());
                continue;
            }

            while(!pq.isEmpty() && pq.peek()[1] <= lists.get(i)[0]){
                pq.poll();
            }
            pq.add(lists.get(i));
            ans = Math.max(ans, pq.size());
        }
        ans = Math.max(ans, pq.size());

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
