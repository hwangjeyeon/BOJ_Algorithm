import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 최소스패닝트리 구현 방법 중 하나인 크루스칼 알고리즘을 통해 풀었다.
 * - 크루스칼 + 유니온파인드를 이용하였다.
 * - 기본적으로 간선의 정보를 담고 있는 2차원 배열 graph 배열을 만들어둔다
 * - 0번 인덱스는 나가는 정점 1번 인덱스는 들어오는 정점 2번 인덱스는 가중치를 저장한다
 * - 이어서 해당 배열을 2번 인덱스를 기준으로 오름차순 정렬한다
 * - parent배열을 초기화하는데 처음에는 자기 자신을 가리키도록 초기화한다
 * - 이어서 크루스칼 알고리즘이 담긴 메소드를 실행한다
 * - 해당 메소드에서 cost 변수를 선언해서 최소 비용 가중치를 담는다
 * - graph 배열 길이만큼 순회하는데, 이때 나가는 정점과 들어오는 정점의 정보를 담은 0번과 1번 인덱스를 각각 find해서 가리키고 있는 부모노드를 불러온다
 * - 만약 같지 않다면 union해준다. 이때 union은 더 작은 값을 부모 노드로 가리키도록 한다
 * - 이어서 해당 정점들이 최소스패닝트리(최소신장트리)(MST)에 추가되므로, 가중치 정보가 담긴 2번 인덱스 값을 cost에 더해준다
 * - 이렇게 완성된 cost를 StringBuilder에 담아 출력하면 정답이 된다
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b){
        int na = find(a);
        int nb = find(b);

        if(na < nb){
            parent[nb] = na;
        }else{
            parent[na] = nb;
        }

    }

    static void kruskal(){
        long cost = 0;
        for (int i = 0; i < graph.length; i++) {
            if(find(graph[i][0]) != find(graph[i][1])){
                cost += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        sb.append(cost);
    }

    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph = new int[e][3];
        parent = new int[v+1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[i][0] = a;
            graph[i][1] = b;
            graph[i][2] = c;
        }

        Arrays.sort(graph, (o1,o2) -> o1[2] - o2[2]);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        kruskal();

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
