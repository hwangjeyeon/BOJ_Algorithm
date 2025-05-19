import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 내림차순 우선순위 큐 써서 모두 소진될때까지 순회하면 된다
 * 2. 결과는 리스트에 넣는다. 초기 리스트 값으로 0을 넣어주고, 포인터 역할을 할 last 변수를 하나 선언한다
 * 3. 그리고 조건에 맞춰서 리스트에 넣고 now의 값을 줄인 다음 now가 k이하인지 확인하고 맞다면 continue한다
 * 4. 아니라면 다시 pq에 넣고 반복한다
 * 5. 위 과정동안 ans로 진행한 일자를 세어주고 그값을 출력한 뒤, list에서 0인 경우를 제외하고 출력하면 정답이 된다
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
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;

        List<Integer> list = new ArrayList<>();
        int last = 0;
        list.add(0);
        while(!pq.isEmpty()){
            ans++;
            int now = pq.poll();
            list.add(list.get(last++)/2 + now);
            now -= m;
            if(now <= k){
                continue;
            }
            pq.add(now);

        }

        bw.write(ans+"\n");
        for (Integer i : list) {
            if(i == 0 ){
                continue;
            }
            bw.write(i+"\n");
        }

        br.close();
        bw.close();
    }
}
