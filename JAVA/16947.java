import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 각 번호의 역과 순환선 사이의 거리를 구하기 위해서는 먼저 순환여부를 확인하고 어떤 역이 순환선인지 체크해야한다
 * 2. 순환선은 한개이므로 모든 역을 확인하며 순환선 여부를 체크한다. 현재 역이 순환선이 아니면 초기화해준다
 * 3. 순환선 체크는 먼저 현재 역이 순환선일 것이라는 가정으로 시작한다. 그리고 연결된 역을 탐색한다
 * 4. 만약 연결된 역이 순환선이 아니라면 현재 역 번호를 이전, 그 다음 역번호를 현재, 시작은 맨 처음 그대로 유지해서 다시 재귀로 탐색한다
 * 5. 재귀 탐색의 결과가 true면 순환선이므로 true로 넘겨준다
 * 6. 만약 순환선이 아니라면 다음 역이 이전역과 같지 않으면서 시작역과 다음역이 같은 경우에도 순환선이 되므로 true를 넘겨준다. 위에서 진행한 재귀함수의 종료 조건이 된다
 * 7. 만약 모두 아니라면 현재 역을 false로 바꾸고 false를 리턴한다
 * 8. 이제 모든 역을 탐색하며 순환선이 아닌 역에 대해서 bfs 탐색으로 순환선까지의 거리를 확인한다
 * 9. Node 클래스를 하나 만들어서 vertex의 v와 count를 넣어서 그 번호와 거리를 함께 관리하도록 한다
 * 10. 만약 탐색한 결과 현재 위치가 순환선인 경우 그 count를 리턴해준다
 * 11. 이렇게 완성한 결과를 각각 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Node{
    int v;
    int count;

    public Node(int v, int count) {
        this.v = v;
        this.count = count;
    }
}


public class Main {

    static int n;
    static boolean[] isCycle;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new List[n+1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        isCycle = new boolean[n+1];
        for (int i = 1; i < n + 1; i++) {
            if(checkCycle(i, i, i)){
                break;
            }
            isCycle = new boolean[n+1];
        }

        int[] ans = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            if(!isCycle[i]){
                ans[i] = bfs(i);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            bw.write(ans[i]+" ");
        }


        br.close();
        bw.close();
    }

    private static int bfs(int node) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(new Node(node, 0));
        visited[node] = true;

        while(!q.isEmpty()){
            Node current = q.poll();
            if(isCycle[current.v]){
                return current.count;
            }

            for (int i = 0; i < list[current.v].size(); i++) {
                int nxt = list[current.v].get(i);
                if(!visited[nxt]){
                    visited[nxt] = true;
                    q.add(new Node(nxt, current.count+1));
                }
            }
        }
        return 0;
    }

    private static boolean checkCycle(int prev, int now, int start) {
        isCycle[now] = true;

        for (int i = 0; i < list[now].size(); i++) {
            int nxt = list[now].get(i);
            if(!isCycle[nxt]){
                if(checkCycle(now, nxt, start)) {
                    return true;
                }
            }else if(nxt != prev && nxt == start){
                return true;
            }
        }
        isCycle[now] = false;
        return false;
    }
}
