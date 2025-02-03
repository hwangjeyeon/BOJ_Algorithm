import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이전 숨바꼭질 문제에서 다음 한가지만 생각하면 된다. 다음 지점을 방문하지 않았거나, 방문하려는 곳의 기록시간이 현재 시간과 동일하면 가장 빠른 시간의 개수가 되낟
 * 2. 만약 가장 빠른 시간이 현재 찾는 위치의 시간보다 작다면 더 빠른 시간이 나올 수 없으므로 bfs 탐색을 종료한다
 *
 * 해결방법:
 *
 * 시간복잡도: O(100_000)
 * 공간복잡도: O(100_000)
 *
 */
public class Main {

    static int[] dx = {-1,1};
    static int n;
    static int k;
    static int ans;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 987654321;
        count = 0;
        bfs();

        bw.write(ans+"\n" + count);


        br.close();
        bw.close();
    }

    private static void bfs() {
        int[] time = new int[100_001];
        Arrays.fill(time, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if(now == k){
                ans = time[now];
                count++;
            }

            if(ans < time[now]){
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if(i < 2){
                    nx = now + dx[i];
                }else{
                    nx = now * 2;
                }

                if(isRange(nx) && (time[nx] == -1 || time[nx] == time[now] + 1)){
                    time[nx] = time[now] + 1;
                    q.add(nx);
                }
            }
        }

    }

    private static boolean isRange(int nx) {
        return nx >= 0 && nx < 100_001;
    }
}
