import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 문제에서 주어진대로 간선을 구성해주고, 방문배열과 큐를 활용하여 DFS 탐색을 진행하며 순서에 맞는지 체크하였따
 * 2. 주어진 dfs를 변형하였는데, 처음에는 cur list에 q.peek가 있는동안 while문을 돌면서 방문 여부를 체크하고, 방문을 안했으면 해당 peek를 인수로 넣어 dfs를 돌리는 방법을 선택하였다
 * 3. 하지만 이방법은 73%에서 시간초과가 발생하였고 다른 방법을 모색해야했다
 * 4. 시간초과가 발생하는 이유를 고민해보자면 아마 중복되는 간선 때문이 아닐까 생각하였다.
 *
 * 해결방법:
 * 1. 해결 방법으로 Set을 활용하여, 현재 간선에 연결된 모든 노드를 넣고 set에 큐의 peek가 포함되는지 확인하였다.
 * 2. 이 방법으로 dfs를 돌린 뒤 q가 비어있지 않다면 순서에 맞지 않는 것이므로 초기값이 1인 ans를 0으로 바꾸고 출력하면 정답이 된다.
 * 3. 큐가 비어있다면 그대로 ans를 출력해서 1이 나오도록 하면 된다
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(logn)
 *
 */


public class Main {

    static List<Integer>[] lists;
    static boolean[] visited;
    static Queue<Integer> q;
    static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        visited = new boolean[n+1];
        q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        dfs(1);

        if(!q.isEmpty()){
            ans=0;
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    public static void dfs(int cur){
        if(visited[cur]){
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : lists[cur]) {
            if(!visited[i]){
                set.add(i);
            }
        }


        q.poll();
        visited[cur] = true;
        while(set.contains(q.peek())){
            if(!visited[q.peek()]){
                dfs(q.peek());
            }
        }
    }

}

