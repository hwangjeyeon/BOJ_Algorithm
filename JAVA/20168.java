import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 *
 * 해결방법:
 * 1. start에서 end지점까지 가는 최단거리를 구하는 문제라면 다익스트라로 쉽게 풀 수 있는 문제다
 * 2. 하지만 이 문제는 최단거리에 해당하는 각 골목들에 대해 최대로 내는 요금을 구하는 방식이라 다익스트라만으로는 한계가 있다
 * 3. 이 문제를 풀기 위해서는 다익스트라에 이분탐색을 추가하여야 한다
 * 4. 1부터 1001까지를 양 끝으로 잡아준다. 1001은 골목별 수금액의 최대치 + 1이다
 * 5. 중간값을 찾고자하는 최단 거리 (start, end) 범위와 함께 넘겨주며 그 결과값이 true면 범위를 좁혀서 high = mid - 1 다시 탐색해준다. 이때 ans에 mid값을 넣어준다
 * 6. 만약 false면 범위를 늘려서 low = mid + 1 다시 탐색해준다. 탐색은 low가 high보다 작거나 같은동안 반복한다
 * 7. 다익스트라에서는 우선순위 큐를 통해서 기존과 같이 진행해준다. 이분탐색 특성상 반복이 되기 때문에 배열의 초기화도 함수 호출될때 진행해준다. 또한 방문 배열도 똑같이 호출될때마다 새로 생성한다.
 * 8. 기존과 동일하나 다음 두가지를 추가로 진행한다. 만약 다음 비용이 mid값보다 크다면 스킵해준다
 * 9. return 결과로 dist[end] <= money를 넘겨준다
 * 10. 8번의 경우는 mid보다 작은 값만을 내는 경로만 탐색하겠다는 의미이며, 9번은 그 결과로 최단거리로 목적지에 도달할 수 있는지와, 그 금액이 money보다 작은가이다.
 * 11. 만약 참이라면 한 골목에서 내야하는 최대 요금의 최솟값을 찾기 위해 최대 범위를 줄여준다
 * 12. 만약 거짓이라면 최단거리 경로 내에 mid보다 큰 요금이 존재한다는 것이고, 그 값을 찾기 위해 최소 범위를 늘려준다
 * 13. ans를 -1로 하여, 최단거리를 찾지 못한 경우는 11번을 만족시키지 못하는 경우니까 -1이 그대로 출력되도록 하며, 아닌 경우는 값이 갱신될테니 그 값을 ans에 넣어 출력하도록 한다.
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */
class Node{
    int number;
    int cost;

    public Node(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}

public class Main {

    static int[] dist;
    static List<Node>[] list;
    static int money;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        binarySearch(start, end);
        bw.write(ans+"");

        br.close();
        bw.close();
    }


    private static void binarySearch(int left, int right){
        int low = 1;
        int high = 1001;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;

            if(dijkstra(left, right, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
    }

    private static boolean dijkstra(int start, int end, int mid) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        boolean[] visited = new boolean[11];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.number]){
                continue;
            }
            visited[cur.number] = true;

            for (int i = 0; i < list[cur.number].size(); i++) {
                Node next = list[cur.number].get(i);
                if(next.cost > mid){
                    continue;
                }

                if(dist[cur.number] + next.cost < dist[next.number]){
                    dist[next.number] = dist[cur.number] + next.cost;
                    pq.add(new Node(next.number, dist[next.number]));
                }
            }

        }
        return dist[end] <= money;
    }
}

