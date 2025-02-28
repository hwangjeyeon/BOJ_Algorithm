import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. HashMap과 우선순위 큐 써서 해결했다. 태그를 보니 트리맵 써도 해결할 수 있을 것 같다
 * 2. name을 key로 하고, PrioritityQueue<Integer>를 value로 한 뒤, 내림차순 정렬하면 된다
 * 3. 1은 값을 입력하고, 2는 값을 빼서 ans에 더해주면 된다
 * 4. 2에서 주의할점은 null인 경우 continue해줘야한다는 것이고, 1에서 주의할 점은 map에서 가져올 때, null인경우와 아닌 경우를 구분해서 인스턴스를 생성해야하는 점이다
 * 5. 또한 쿼리의 합이 int형 범위를 벗어나지 않는다고 했는데, 그건 한가지 name에 대한 k의 합을 말하는 것이다. 따라서 정답의 타입은 long으로 선언해야한다
 * 6. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(q * k)
 * 공간복잡도: O(k)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long ans = 0;
        for (int tc = 0; tc < n; tc++) {
            String[] s = br.readLine().split(" ");
            String name = s[1];
            if(s[0].equals("1")){
                PriorityQueue<Integer> pq = map.get(name) == null ? new PriorityQueue<>((o1, o2) -> o2 - o1) : map.get(name);
                int k = Integer.parseInt(s[2]);
                for (int i = 0; i < k; i++) {
                    pq.add(Integer.parseInt(s[i+3]));
                }
                map.put(name, pq);
            }else{
                int k = Integer.parseInt(s[2]);
                int count = 0;
                PriorityQueue<Integer> pq = map.get(name);
                if(pq == null){
                    continue;
                }
                while(!pq.isEmpty() && count < k){
                    ans += pq.poll();
                    count++;
                }
                map.put(name, pq);
            }

        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
