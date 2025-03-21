import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 구현 + DFS + BFS를 다 섞어서 풀 수 있는 문제다
 * 2. 좌표평면이 아닌 입력값에서 구현 DFS BFS정도만으로 문제를 낸다면 이 정도가 평균 난이도가 아닐까 생각한다
 * 3. 여기서 기록해야할 것은 총 3가지가 있따. 먼저 선거구 번호별로 연결 정보이다. 이 정보는 탐색에 활용할 것이다
 * 4. 그 다음은 인구수다. 두번째 줄에 입력으로 주어지는 이 값은 각 선거구를 선택할 때 얻을 수 있는 가치를 의미한다
 * 5. 마지막은 선거구 지역이다. 모든 번호를 가지는 선거구 지역이 현재 1번과 2번중 어디에 속했는지 판단해야한다
 * 6. 이후, dfs를 시작으로 모든 선거구를 파악하자. dfs의 재귀는 두가지로 나뉜다. 현재 area를 1번이나 2번으로 선택한 경우 각각이다
 * 7. depth가 n+1에 도달하면 이제 구현으로 검증해야한다. 모든 선거구를 파악했기 때문이다
 * 8. 선거구 1과 2의 인구수를 파악하자. base condition에서 순회를 통해 인구수를 파악한다
 * 9. 연결된 지역의 개수를 세기 위해 방문배열과 BFS를 시작한다
 * 10. 모든 선거구를 순회하며 방문하지 않았다면 BFS를 시작한다. 그리고 지역구 개수를 카운팅한다
 * 11. 순회 이후 지역구 개수가 2라면 ans를 최솟값으로 갱신한다. 이때, 두 지역구 인구수 차이의 절댓값으로 갱신한다
 * 12. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(2^n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int n;
    static List<Integer>[] list;
    static int[] population;
    static int ans = Integer.MAX_VALUE;
    static int[] area;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new List[n+1];
        population = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        area = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                list[i+1].add(Integer.parseInt(st.nextToken()));
            }
        }
        dfs(1);
        if(ans == Integer.MAX_VALUE){
            bw.write("-1");
        }else{
            bw.write(ans+"");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int depth) {
        if(depth == n+1){
            int count1 = 0;
            int count2 = 0;
            for (int i = 1; i < n + 1; i++) {
                if(area[i] == 1){
                    count1 += population[i];
                }else{
                    count2 += population[i];
                }
            }
            visited = new boolean[n+1];
            int link = 0;
            for (int i = 1; i < n + 1; i++) {
                if(!visited[i]){
                    bfs(i, area[i]);
                    link++;
                }
            }
            if(link == 2){
                ans = Math.min(ans, Math.abs(count1 - count2));
            }
            return;
        }
        area[depth] = 1;
        dfs(depth+1);

        area[depth] = 2;
        dfs(depth+1);
    }

    private static void bfs(int idx, int num) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);
        while(!q.isEmpty()){
            int cur = q.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                int nxt = list[cur].get(i);
                if(area[nxt] == num && !visited[nxt]){
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }

}
