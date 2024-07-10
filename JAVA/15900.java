import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 리프 노드가 홀수면 상원이 승, 짝수면 패
 * 2. 리프노드는 연결된 노드 수가 1개 이하인 경우
 *
 * 해결방법:
 * 1. 단순 리프노드 개수 홀짝으로 판별하려 했으나, 문제를 읽어보니 부모노드로 옮기는 과정을 하고 다른 사람에게 차례가 넘어간다고 하였다
 * 2. 따라서 다른 방법을 선택해야 했고, 그 방법이 dfs로 탐색하여, 깊이를 모두 더했을 때, 짝수면 패, 홀수면 승이라는 것이다
 * 3. 방문 여부와 조회 속도 향상을 위해 boolean 배열과 리스트 배열을 하나 만들어서 해결하였다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(nlogn)
 *
 */

class Node{

    int value;
    List<Integer> child;

    public Node(int value, List<Integer> child) {
        this.value = value;
        this.child = child;
    }
}



public class Main {
    static int ans = 0;
    static List<Node> nodes = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            nodes.add(new Node(i, new ArrayList<>()));
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).child.add(b);
            nodes.get(b).child.add(a);
        }

        dfs(1, 0);

        if(ans % 2 == 0){
            bw.write("No");
        }else{
            bw.write("Yes");
        }

        br.close();
        bw.close();
    }

    static void dfs(int cur, int depth){
        visited[cur] = true;
        for (Integer i : nodes.get(cur).child) {
            if(!visited[i]){
                dfs(i, depth+1);
            }
        }

        if(cur != 1 && nodes.get(cur).child.size() == 1){
            ans += depth;
        }

    }

}

