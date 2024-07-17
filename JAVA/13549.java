import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 이번에는 다익스트라를 이용하여 풀었다. 시간을 가중치로 잡았다
 * 2. 이때 시간이 다르기 때문에 BFS, DFS에는 제약이 따른다. 따라서 다익스트라를 사용하였다
 * 3. 일단 음의 가중치는 존재하지 않는다. 거리를 가중치로한다면 존재하지만 시간은 좌우 이동은 +1, 순간이동은 0이기 때문이다
 * 4. 각각에 대해 입력 범위 내에서 if문으로 다익스트라 검사를 진행한다
 * 5. 배열은 Integer.MAX_VALUE로 해주었다
 * 6. 목표지점인 m의 dist값을 출력하면 정답이 된다.
 *
 * 해결방법:
 * 1. 10%에서 틀리는 문제가 발생하였다
 * 2. visited 배열이 원인이었고 왜 그런가 생각을 해보았을 때, 4 6 입력의 경우 최단거리가 보장되지 않는 것을 확인할 수 있었다
 * 3. 단순 노드 연결처럼되어있지않고 배열처럼 붙어있으면서 3가지 방법으로 붙어있는데다가 가중치도 다르기때문에 발생한 문제가 아니었나 생각한다.
 *
 * 시간복잡도: O(3log|n-m|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dist = new int[200001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(n);

        bw.write(dist[m]+"");

        br.close();
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(start);

        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur * 2 < 100001 && dist[cur] < dist[cur*2]){
                dist[cur*2] = dist[cur];
                pq.add(cur*2);
            }

            if(cur + 1 < 100001 && dist[cur] + 1 < dist[cur+1]){
                dist[cur+1] = dist[cur] + 1;
                pq.add(cur+1);
            }

            if(cur - 1 >= 0 && dist[cur] + 1 < dist[cur - 1]){
                dist[cur-1] = dist[cur] + 1;
                pq.add(cur-1);
            }
        }
    }

}

