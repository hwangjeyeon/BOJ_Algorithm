import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 노드 클래스를 만들어서 관리하였다
 * 2. 연결된 노드 번호와 그 거리를 알기 위해 map으로 관리하였다
 * 
 * 
 * 해결방법:
 * 3. dfs 탐색을 통해서 방문 여부를 체크하고, 방문하지 않았다면 연결된 모든 노드를 탐색한다
 * 4. 탐색할 때, 그 거리를 파라미터로 더해서 넘기면서 a와 b가 같으면 ans에 dist를 넣고 종료하도록 구현하였다
 * 5. 이후 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(n)
 *
 */

class Node{
    int number;
    Map<Integer, Integer> distance;

    public Node(int number) {
        this.number = number;
        distance = new HashMap<>();
    }
}



public class Main {

    static boolean[] visited;
    static int ans;
    static List<Node> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            nodes.add(new Node(i));
        }


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).distance.put(b, c);
            nodes.get(b).distance.put(a, c);
        }

        for (int i = 0; i < m; i++) {
            ans = 0;
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dfs(a, b, 0);
            bw.write(ans+"\n");
        }



        br.close();
        bw.close();
    }

    private static void dfs(int a, int b, int dist) {
        if(a == b){
            ans = dist;
            return;
        }
        
        visited[a] = true;
        for (Map.Entry<Integer, Integer> map : nodes.get(a).distance.entrySet()) {
            if(!visited[map.getKey()]){
                dfs(map.getKey(), b, dist + map.getValue());
            }
        }
        
    }


}

