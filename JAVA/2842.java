import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 8방 탐색 BFS와 투포인터를 활용해서 해결하는 문제다
 * 2. 어느 고도 범위에서 탐색했을 때, 피로도가 가장 작은지 확인하려면 투포인터로 시간복잡도를 줄여야한다
 * 3. 따라서 최소 높이와 최대 높이를 구한다음, 0, 최대높이 위치, 최소 높이 위치, 리스트 크기를 구한다.
 * 4. 투포인터를 설정한다. left는 0으로 설정하고 right는 현재 최대 높이의 인덱스로 한다
 * 5. left는 최소 높이의 인덱스 보다 작거나 같아야하며, right는 최대 개수 범위를 벗어나면 안된다
 * 6. left와 right 위치의 높이를 투포인터로 해서 bfs에 전달한다
 * 7. bfs에서는 해당 위치의 피로도가 left와 right 범위에 있는 경우만 인정하고 탐색을 이어간다
 * 8. bfs는 모든 집을 방문할 수 있는지 확인하고 방문가능하면 0을 리턴한다.
 * 9. 만약 모든 집을 방문할 수 있으면, 정답을 최소로 갱신한다. 비교할 값은 가장 높은 높이와 낮은 높이의 차이인 right - left차이인 피로도다
 * 10. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^4)
 * 공간복잡도: O(n^2)
 *
 */
public class Main {

    static int n;
    static char[][] arr;
    static int[][] fatigue;
    static int[] dy = {-1,-1,-1,0,0,1, 1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        start = new int[2];
        fatigue = new int[n][n];
        int home = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'P'){
                    start[0] = i;
                    start[1] = j;
                }
                if(arr[i][j] == 'K'){
                    home++;
                }
            }
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                fatigue[i][j] = Integer.parseInt(st.nextToken());
                list.add(fatigue[i][j]);
                if(arr[i][j] == 'P' || arr[i][j] == 'K'){
                    max = Math.max(max, fatigue[i][j]);
                    min = Math.min(min, fatigue[i][j]);
                }
            }
        }
        Collections.sort(list);
        int left = 0;
        int right = list.indexOf(max);
        int minHeight = list.indexOf(min);
        int maxHeight = list.size();
        int ans = Integer.MAX_VALUE;
        while(left <= minHeight && left <= right && right < maxHeight){
            int a = list.get(left);
            int b = list.get(right);
            if(bfs(a,b, home) == 0){
                ans = Math.min(ans, b-a);
                left++;
            }else{
                right++;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int bfs(int min, int max, int h) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(h == 0){
                return h;
            }

            for (int i = 0; i < 8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny,nx) && !visited[ny][nx] &&fatigue[ny][nx] >= min && fatigue[ny][nx] <= max){
                    visited[ny][nx] = true;
                    if(arr[ny][nx] == 'K'){
                        h--;
                    }
                    q.add(new int[]{ny,nx});
                }
            }
        }
        return h;
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < n && nx >=0 && nx < n;
    }
}
