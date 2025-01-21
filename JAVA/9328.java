import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BFS 구현 문제다. 이 문제는 상태관리를 잘하면 된다
 * 2. 먼저 첫번째 탐색으로 얻을 수 있는 모든 열쇠를 획득한 다음, 잠겨서 못간 문을 해당 열쇠로 열 수 있는지 확인한다
 * 3. 문서면 ans를 증가시키고, 빈칸이면 그냥 지나간다
 * 4. 문이면 열쇠가 있는지 확인하고 열 수 있으면 열고 빈칸으로 바꾼다
 * 5. 만약 못 열면 잠긴 문 리스트에 넣어주고 더이상 탐색하지 않는다
 * 6. 열쇠인 경우 열쇠 리스트에 넣어준다
 * 7. 열쇠를 발견한 경우 모든 열쇠 리스트를 확인하며, 잠긴 문과 비교해서 열 수 있는 문이 있다면 그 열쇠의 위치를 기준으로 BFS 탐색을 진행한다
 * 8. 완성한 ans를 출력하면 정답이 된다
 * 9. 한가지 주의할점이 이 문제는 h+2 x w+2를해야한다. 왜냐하면 가장자리에서 출발하는 경우를 고려해야하기 때문이다. 그래서 두칸정도 더 덮어씌웠다
 *
 * 해결방법:
 *
 * 시간복잡도: O(T*(h*w + (h*w)))
 * 공간복잡도: O(h*w)
 *
 */

public class Main {

    static int h;
    static int w;
    static char[][] arr;
    static boolean[] keys;
    static int ans;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static List<int[]>[] lock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr = new char[h+2][w+2];
            keys = new boolean[26];
            visited = new boolean[h+2][w+2];
            ans = 0;
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    arr[i][j] = '.';
                }
            }
            for (int i = 1; i < h+1; i++) {
                String s = br.readLine();
                for (int j = 1; j < w + 1; j++) {
                    arr[i][j] = s.charAt(j-1);
                }
            }

            lock = new List[26];
            for (int i = 0; i < 26; i++) {
                lock[i] = new LinkedList<>();
            }
            String s = br.readLine();
            if(!s.equals("0")){
                for (int i = 0; i < s.length(); i++) {
                    int c = s.charAt(i) - 'a';
                    keys[c] = true;
                }
            }

            bfs(0,0);

            bw.write(ans+"\n");
        }


        br.close();
        bw.close();
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny,nx) && !visited[ny][nx] && arr[ny][nx] != '*'){
                    char a = arr[ny][nx];
                    if(a - 'A' >= 0 && a - 'A' < 26){
                        if(keys[a - 'A']){
                            arr[ny][nx] = '.';
                            visited[ny][nx] = true;
                            q.add(new int[]{ny,nx});
                        }else{
                            lock[a - 'A'].add(new int[]{ny,nx});
                        }
                    }else if(a - 'a' >= 0 && a - 'a' < 26){
                        keys[a - 'a'] = true;
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                        for (int j = 0; j < 26; j++) {
                            if(!lock[j].isEmpty() && keys[j]){
                                for (int k = 0; k < lock[j].size(); k++) {
                                    int[] cur = lock[j].get(k);
                                    arr[cur[0]][cur[1]] = '.';
                                    visited[cur[0]][cur[1]] = true;
                                    q.add(new int[]{cur[0], cur[1]});
                                }
                            }
                        }
                    }else if(a == '$'){
                        ans++;
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }else{
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }
                }
            }
        }

    }

    private static boolean isRange(int ny, int nx) {
        return ny >=0 && ny < h+2 && nx >= 0 && nx < w+2;
    }

}
