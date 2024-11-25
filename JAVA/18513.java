import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. BFS + 자료구조를 이용하는 문제다
 * 2. 단순히 bfs와 방문배열 구조로 갈 경우 메모리 초과가 발생한다. 따라서 SET이나 MAP을 사용해서 방문을 관리해야한다
 * 3. 미리 샘터 위치를 넣어두고, 방문할때마다 넣는 식으로 탐색하면 된다
 * 4. K가 0보다 작거나 같을 때 종료시키고, 거리는 탐색될때마다 1씩 늘어나면서 그 위치만큼 정답 변수에 더하는 식으로 한다
 *
 * - 문제 해결:
 * 1. 80%에서 계속 틀렸는데, 해결책은 샘터의 범위를 집의 범위로 착각해서 탐색 범위를 한정지었기 떄문이다
 * 2. 샘터의 범위는 집의 범위가 아니다. 따라서 제한 없이 탐색할 수 있다.
 * 3. 또한 거리합산은 충분히 int 범위를 벗어날 수 있으므로 long타입으로 해야한다 
 * 4. 이점을 고려했을 때, ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n+k)
 * 공간복잡도: O(n+k)
 *
 */

public class Main {

    static long ans = 0;
    static HashSet<Long> set;
    static int[] dx = {1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            set.add(arr[i]);
        }

        bfs(n,k, arr);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int k, long[] arr) {
        Queue<long[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(new long[]{arr[i], 0});
        }
        while(!q.isEmpty()){
            long[] now = q.poll();

            for (int i = 0; i < 2; i++) {
                long nx = now[0] + dx[i];

                if(!set.contains(nx)){
                    set.add(nx);
                    ans += now[1] + 1;
                    k--;
                    if (k <= 0) {
                        return;
                    }
                    q.add(new long[]{nx, now[1]+1});
                }

            }

        }

    }
}
