import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BFS + 시뮬레이션 + 구현을 합친 문제다
 * 2. 먼저 bfs 탐색을 통해 연합할 대상이 있는지 확인한다. 이때, 대상이 있다면 시뮬레이션을 지속할 수 있도록 boolean 변수를 변경한다
 * 3. 처음 시도한 방법은 union 배열을 만들어 각 구간을 숫자로 구분하는 방법이었다
 * 4. 모든 BFS가 끝난 뒤, 별도의 unionBFS를 통해 값을 변화시키는 방법이었는데, 당시 5번 예제가 무한루프에 걸려 다른 방법으로 변경하였다
 * 5. 참고로 1~4번 풀이를 소실하긴 했는데, 그때 인덱스 위치를 바꾸는 실수를 저질러서 발생한 문제였다. 만약 다시 테스트 해본다면 정답이 아니었을까 예상한다
 * 6. 새롭게 한 풀이는 방문배열로 통일해서 bfs로 모두 탐색한 후, 별도의 unionBFS로 -1부터 차례대로 감소하여 하나로 묶는 경우다
 * 7. 하지만 이 경우, 방문배열했다는 것만으로 판단해서 연합을 지어버리기 때문에, 반례가 나온다
 * 8. 따라서 새롭게 선택한 방법은 1~4번 풀이를 사용하되, 리스트를 이용하는 방법이다. BFS탐색에서 발견된 값들을 리스트에 넣어주고, 만약 리스트 크기가 1보다 크다면 바로 다음 BFS전에 연합국끼리 값을 변경한다
 * 9. 이렇게 한다면, 연합국 선을 잘 구분지어서 정답을 구할 수 있다
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(n^3 * simulation개수[최대 2000])
 * 공간복잡도: O(n^2)
 *
 */


public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<int[]> list;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(true){
            boolean isOk = true;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        int sum = bfs(i,j,n,l,r);
                        if(list.size() > 1){
                            change(sum);
                            isOk = false;
                        }
                    }
                }
            }


            if(isOk){
                break;
            }
            ans++;

        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void change(int sum) {

        for (int i = 0; i < list.size(); i++) {
            arr[list.get(i)[0]][list.get(i)[1]] = sum / list.size();
        }

    }


    // 연합 설정
    private static int bfs(int y, int x, int n, int l, int r) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new int[]{y,x});
        list.add(new int[]{y,x});
        visited[y][x] = true;

        int sum = arr[y][x];
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];
                if(ny>=0 && ny < n && nx>=0 && nx < n && !visited[ny][nx]){
                    int diff = Math.abs(arr[ny][nx] - arr[cur[0]][cur[1]]);
                    if(diff >= l && diff <= r){
                        visited[ny][nx] = true;
                        list.add(new int[]{ny,nx});
                        sum += arr[ny][nx];
                        q.add(new int[]{ny,nx});
                    }
                }
            }
        }
        return sum;
    }
}
