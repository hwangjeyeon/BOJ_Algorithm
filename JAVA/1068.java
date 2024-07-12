import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 따로 클래스 안 만들고 리스트 배열로 해결하였다
 * 2. 시작지점을 찾기 위해 root 변수를 활용하였고, 양방향 연결도 진행하였다
 * 3. 삭제되는 지점이 root면 0을 출력하고 아닌 경우 dfs 탐색을 한다
 * 4. 방문여부를 체크하면서 리프 노드의 개수를 세어준다
 * 5. 이때 연결된 노드가 삭제 노드가 아니고, 방문하지 않았다면 개수를 세어준 뒤, 연결된 노드를 루트로 하여 dfs 탐색을 한다
 * 6. 모든 연결 노드를 확인한 후, 노드의 개수가 0이라면 리프노드이므로 ans를 증가시킨다
 * 7. 완성한 ans를 출력하면 정답이 된다
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a == -1){
                root = i;
            }else{
                list[a].add(i);
                list[i].add(a);
            }
        }
        int delete = Integer.parseInt(br.readLine());
        if(delete == root){
            bw.write("0");
        }else{
            dfs(root, delete);
            bw.write(ans+"");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int cur, int delete) {
        visited[cur] = true;
        int nodes = 0;
        for (Integer i : list[cur]) {
            if(i != delete && !visited[i]){
                nodes++;
                dfs(i, delete);
            }
        }

        if(nodes == 0){
            ans++;
        }
    }

}

