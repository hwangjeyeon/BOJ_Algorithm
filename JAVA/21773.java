import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 우선순위 큐 쓰는 쉬운 문제다
 * 2. 우선순위를 내림차순하고 같다면 아이디순으로 오름차순하는 우선순위 큐를 하나 만든다
 * 3. 그리고 t만큼 순회하며 하나씩 뽑아서 id를 정답으로 출력한다
 * 4. 이때, 남은 시간의 수를 감소시키고, 만약 0보다 크다면 우선순위 큐에 넣는다
 * 5. 단 우선순위 큐에 넣기 전에 한가지 확인할 것이 있는데, 우선순위 값의 크기를 조절해야한다. 
 * 6. 문제에서는 현재 id가 아닌 다른 프로세스의 우선순위를 늘리라고 했지만 그렇게 하면 시간초과가 발생한다
 * 7. 따라서 현재 뽑은 프로세스의 우선순위를 1 감소하는 것으로 하고 넣어주는 역발상으로 해결했다
 *
 * 해결방법:
 *
 * 시간복잡도: O(t*logn)
 * 공간복잡도: O(logn)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a,c, b});
        }
        
        for (int i = 0; i < t; i++) {
            int[] now = pq.poll();
            now[2]--;
            now[1]--;
            if(now[2] > 0){
                pq.add(now);
            }
            bw.write(now[0]+"\n");
        }


        br.close();
        bw.close();
    }
}
