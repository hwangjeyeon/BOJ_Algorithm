import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 연결리스트를 이용한 dfs 풀이로 해결하였다
 * 2. 각 Node의 정보를 담아줄 클래스를 하나 만들었다
 * 3. 그리고 각 노드 별로 연결된 노드들을 확인해줄 정보를 담을 리스트 배열을 만들었다
 * 4. 양방향이므로 입력값을 양방향으로 만들어준다
 * 5. 이어서 dfs를 진행한다. 순회를 통해서 모든 리스트의 배열을 순회하면서 dfs를 진행하는데, 순회 할때마다 visited 배열을 초기화해준다
 * 6. dfs에서는 해당 리스트 배열에 담겨있는 모든 값을 순회해서 그 가중치를 합산한다. 그리고 max와 비교해서 더 큰 값을 넣어준다
 * 7. 완성한 max를 출력하면 정답이 된다
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */
class Node{
    int point;
    int weight;

    public Node(int point, int weight) {
        this.point = point;
        this.weight = weight;
    }
}


public class Main {

    static int max = 0;
    static boolean[] visited;
    static List<Node>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        lists = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            lists[first].add(new Node(second, weight));
            lists[second].add(new Node(first, weight));
        }
        for (int i = 1; i < n+1; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i,0);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }

    private static void dfs(int start, int sum) {
        for(Node n : lists[start]){
            if(!visited[n.point]){
                visited[n.point] = true;
                dfs(n.point, sum + n.weight);
            }
        }
        max = Math.max(sum, max);
    }


}

