import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 다익스트라로 해결하였다
 * 2. 시작지점을 0으로 초기화하고 우선순위큐를 이용하여 연결된 모든 노드를 확인하였다
 * 3. 만약 연결된 지점이 현재 지점에서 1을 더한 값(모든 간선의 가중치가 1이라 했으므로)보다 크다면 dist에 해당 값을 더하고 pq에 넣어준다
 * 4. 이렇게 완성한 다익스트라를 통해 dist를 순회해서 k랑 같은 값이 있으면 정답 리스트에 넣어주고 정답 리스트가 비어있으면 -1을 출력 아니면 그 내용물을 출력한다.
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static List<Integer>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        dijkstra(n,m,k,x);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if(dist[i] == k){
                ans.add(i);
            }
        }

        if(ans.isEmpty()){
            bw.write(-1+"\n");
        }else{
            for (Integer an : ans) {
                bw.write(an+"\n");
            }
        }


        br.close();
        bw.close();
    }

    private static void dijkstra(int n, int m, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dist[x] = 0;
        pq.add(x);

        while(!pq.isEmpty()){
            int tmp = pq.poll();
            for (Integer i : list[tmp]) {
                if(dist[i] > dist[tmp] + 1){
                    dist[i] = dist[tmp] + 1;
                    pq.add(i);
                }
            }

        }

    }


}

