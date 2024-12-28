import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 해당 문제는 가능한 십진수를 정점으로 생각하고 정점과 명령어를 잇는 모든 경우를 간선으로 생각했을 때, BFS로 해결할 수 있다
 * 2. DSLR에 따라 각각 수식으로 계산하면 된다
 * 3. D는 n = cur.now*2%10_000, S는 n = cur.now == 0 ? 9999 : cur.now-1, L은 n = cur.now%1000 * 10 + cur.now / 1000, R은 n = cur.now % 10 * 1000 + cur.now / 10로 계산한다
 * 4. 최소한의 명령어를 찾는 것므로 시간초과를 방지할 방문배열을 활용할 수 있으며, 정답을 찾는 경우 바로 종료하고 정답을 출력하면 된다
 *
 *
 * 해결방법:
 * 1. 처음 방법에서 3% 틀렸습니다를 얻었는데, L과 R을 문자열로 바꾼뒤 로테이션하는 방법으로 구현했기 때문이다
 * 2. 문제를 잘못 이해해서 위와 같이 구현했다. 예를들어 123이라고 하더라도 네자릿수 각각에는 숫자가 반드시 포함되어 있다. 따라 0123이 정확한 수식이다
 * 3. 따라서 이것을 L하면 로테이션하는 방법일 경우 231이 되어버리는데, 정확한 방법으로하면 1230이 된다
 * 4. 문제를 잘못해석하고 구현을 잘못했기 때문에 틀린 문제였다. 사실 문제를 읽을 때, 네자릿수로 표현한 부분이 마음에 걸렸는데, 이렇게 발목을 잡아버렸다
 * 5. 마음에 걸리는 부분이 있다면 꼭 정확하게 이해하고 구현하자!
 * 6. 새로운 방법은 천의 자릿수는 N%1000으로 나머지를 추출한뒤, 10을 곱해서 자릿수를 이동하고, 다시 N/1000으로 천의 자릿수를 더하면 완성된다
 * 7. 반대도 마찬가지다 N%10으로 일의 자릿수를 추출한 뒤, 1000을 곱해서 천의 자리로 이동하고, 다시 N/10으로 남은 자릿수를 더하면 완성된다.
 *
 *
 * 시간복잡도: O(T * (10_000 + 4*10_000))
 * 공간복잡도: O(10_000)
 *
 */
class Pair{
    int now;
    String list;

    public Pair(int now, String list) {
        this.now = now;
        this.list = list;
    }
}


public class Main {

    static boolean[] visited;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited = new boolean[10_000];
            ans = "";
            bfs(a,b);
            bw.write(ans + "");
            if(i != T-1){
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private static void bfs(int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, ""));
        visited[start] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.now == end){
                ans = cur.list;
                return;
            }

            firstLogicForD(cur, q);
            secondLogicForS(cur, q);
            thirdLogicForL(cur, q);
            fourthLogicForR(cur, q);


        }
    }

    private static void fourthLogicForR(Pair cur, Queue<Pair> q) {
        int n;
        n = cur.now % 10 * 1000 + cur.now / 10;
        if(!visited[n]){
            visited[n] = true;
            q.add(new Pair(n, cur.list+"R"));
        }
    }

    private static void thirdLogicForL(Pair cur, Queue<Pair> q) {
        int n;
        n = cur.now%1000 * 10 + cur.now / 1000;
        if(!visited[n]) {
            visited[n] = true;
            q.add(new Pair(n, cur.list + "L"));
        }
    }

    private static void secondLogicForS(Pair cur, Queue<Pair> q) {
        int n;

        n = cur.now == 0 ? 9999 : cur.now-1;
        if(!visited[n]){
            visited[n] = true;
            q.add(new Pair(n, cur.list+"S"));
        }
    }

    private static void firstLogicForD(Pair cur, Queue<Pair> q) {
        int n = cur.now*2%10_000;
        if(!visited[n]){
            visited[n] = true;
            q.add(new Pair(n, cur.list+"D"));
        }
    }

}
