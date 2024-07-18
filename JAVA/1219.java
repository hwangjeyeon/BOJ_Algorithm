import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 *
 * 해결방법:
 * 1. 벨만포드 알고리즘을 활용하는 문제다.
 * 2. 이 문제는 기존 음의 사이클을 검사하는 벨만포드와 다르게 양의 사이클을 검사하는 문제이다
 * 3. 오민식이 버는 돈을 최대로 하려고 하고, 무한히 많이 가지고 있을 수 있다는 점에서 음의 사이클은 중요하지 않고 양의 사이클이 발생하는지 체크해서 조건에 맞게 출력하는 것이 핵심이다
 * 4. 따라서 기존의 방식과 다르기 Long.MIN_VALUE로 최소값으로 dist 배열을 초기화해준다
 * 5. 이후 벨만포드 알고리즘을 도는데 dist[start]를 money[start]로 초기화해준다
 * 6. 순회는 n의 최대 입력값인 50번을 더 도는 n+51번 순회를 하면서 n개의 모든 정점을 순회한다.
 * 7. n+51번 순회하는 것은 최소한 한번 더 돌면서 양의 사이클이 발생했는지 여부를 체크하기 위함이다
 * 8. 시작지점이 Long.MIN_VALUE라면 스킵해주고 만약 시작지점 Long.MAX_VALUE라면 양의 사이클이므로,현재 지점에 연결된 노드도 사이클이 된다. 따라서 연결된 노드에도 Long.MAX_VALUE를한다
 * 9. 두 조건을 모두 건너 뛴다면 연결된 지점의 dist가 현재 지점의 dist + 현재 지점의 money - 연결된 지점까지의 비용값보다 작은지 체크하고 만족한다면 연결된 지점의 값을 갱신한다
 * 10. 이때 i가 n보다 크거나 같다면 사이클이 발생했다는 것이므로, Long.MAX_VALUE로 초기화한다.
 * 11. 이렇게 벨만포드를 돌은 결과 dist 목적지가 MIN_VALUE면 도착하지 않았다는 것이고 LONG_VALUE라면 돈을 무한히 가지고 있을 수 있다는 것이다
 * 12. 위 두 조건을 모두 통과하면 dist 목적지의 값을 출력한다. 
 *
 *
 * 시간복잡도: O(n^2*m)
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

    static long[] dist;
    static List<Node>[] list;
    static long[] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        money = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Long.parseLong(st.nextToken());
        }

        Arrays.fill(dist, Long.MIN_VALUE);

        bellmanFord(start, n);

        if (dist[end] == Long.MIN_VALUE) {
            bw.write("gg");
        }else if(dist[end] == Long.MAX_VALUE){
            bw.write("Gee");
        }else{
            bw.write(dist[end]+"");
        }

        br.close();
        bw.close();
    }

    private static void bellmanFord(int start, int n) {
        dist[start] = money[start];

        for (int i = 0; i < n + 51; i++) {
            for (int j = 0; j < n+1; j++) {
                for (Node node : list[j]) {
                    if(dist[j] == Long.MIN_VALUE){
                        continue;
                    }
                    if(dist[j] == Long.MAX_VALUE){
                        dist[node.number] = Long.MAX_VALUE;
                    }else if(dist[node.number] < dist[j] + money[node.number] - node.cost){
                        dist[node.number] = dist[j] + money[node.number] - node.cost;
                        if(i >= n){
                            dist[node.number] = Long.MAX_VALUE;
                        }
                    }

                }
            }
        }
    }

}

