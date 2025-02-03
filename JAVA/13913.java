import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. bfs이후 base condition에서 dfs 돌릴려고 했는데, 그것보다는 time이랑 parent를 분리해서 배열로 관리하는게 더 편하다
 * 2. 위 방식으로 bfs를 돌려서 time과 parent를 채워준다. time은 0이 최초이기 때문에 -1로 초기화한다
 * 3. bfs 이후, 완성한 가장빠른 시간 ans를 출력한다. 이어서 time[k]가 -1인지 확인한다
 * 4. 만약 time[k]가 -1이면 출력을 준비해야한다. 먼저 임시 변수 pos를 k로 초기화한다
 * 5. 그리고 pos가 n이 아닐 떄까지 stack에 push한다
 * 6. 마지막으로 n을 출력하고, stack의 모든 값을 pop해서 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(3*100_000)
 * 공간복잡도: O(100_000)
 *
 */
public class Main {

    static int[] dx = {-1,1};
    static int n;
    static int k;
    static int ans;
    static int[] time;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;
        bfs();


        bw.write(ans+"\n");
        Stack<Integer> stack = new Stack<>();
        if(time[k] != -1){
            int pos = k;
            while(pos != n){
                stack.push(pos);
                pos = parent[pos];
            }
            bw.write(n+" ");
            while(!stack.isEmpty()){
                bw.write(stack.pop() + " ");
            }
        }


        br.close();
        bw.close();
    }

    private static void bfs() {
        time = new int[100001];
        Arrays.fill(time, -1);
        parent = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if(now == k){
                ans = time[now];
                return;
            }
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if(i < 2){
                    nx = now + dx[i];
                }else{
                    nx = now * 2;
                }
                if(isRange(nx) && time[nx] == -1){
                    time[nx] = time[now] + 1;
                    parent[nx] = now;
                    q.add(nx);
                }
            }
        }

    }

    private static boolean isRange(int nx) {
        return nx >= 0 && nx < 100_001;
    }
}
