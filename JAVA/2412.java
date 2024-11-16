import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이 문제는 BFS로 탐색하는 문제다. 이분탐색 문제집으로 되어있어서 고민했는데 도저히 풀이가 나오지 않아 확인해보니 bfs 문제였다
 * 2. 이 문제의 핵심은 메모리 초과를 피하기 위해 리스트 배열로 선언해야한다는 점과 방문 배열 처리를 어떻게 잘 하는지다
 * 3. y축을 기준으로 x축을 넣는 방식으로 문제를 접근하여 해결하였다
 * 4. bfs 동안에 만약 T에 도달하는 경우가 있다면 가장 먼저 도착하는 경우가 최소 이동 횟수가 될 것이므로 ans를 갱신하고 바로 return한다
 * 5. 현재 y축 위치 - 2 부터 +2 위치까지 탐색하며, 그 위치에 해당하는 x축값들만큼 추가 탐색을 진행한다
 * 6. 이때 x축에 있는 값과 현재 x축까지의 값이 차이가 2이하여야만 한다
 * 7. 해당 차이만큼 나는 경우 큐에 넣고, 방문배열을 따로 만들어줄 수 없기 때문에 remove로 대체해준다. 대신 이때 j--를 해서 다음 값을 탐색할 수 있도록 한다.
 * 8. y축은 어차피 범위를 2만큼 차이나도록 했기 때문에 추가적인 확인은 필요 없으며, 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(x좌표최대치 + y좌표최대치)
 * 공간복잡도: O(200003)
 *
 */

public class Main {

    static int ans = -1;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        list = new ArrayList[200003];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
        for (int i = 0; i < 200003; i++) {
            if(list[i] != null){
                Collections.sort(list[i]);
            }
        }

        bfs(t);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int t) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == t){
                ans = now[2];
                return;
            }
            for (int i = now[0] - 2; i <= now[0] + 2; i++) {
                if(i >= 0 && i < 200003){
                    for (int j = 0; j < list[i].size(); j++) {
                        if(Math.abs(now[1] - list[i].get(j)) <= 2){
                            q.add(new int[]{i, list[i].get(j), now[2] + 1});
                            list[i].remove(j);
                            j--;
                        }
                    }
                }
            }
        }

    }

}
