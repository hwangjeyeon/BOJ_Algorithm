import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. BFS 탐색으로 풀면 쉽게 풀리는 문제다.
 * 2. 2차원배열로 선언해서 0번 인덱스를 왼쪽, 1번 인덱스를 오른쪽 줄로 정의하였다
 * 3. 앞뒤로 이동하는 경우와 점프할 떄를 구분해서 체크후 방문탐색하면 된다. 한가지 주의할점은 최소점은 체크해줘야 하나 최대 지점은 체크할 필요가 없다
 * 4. 최대 지점을 넘어서는 경우는 정답이 되기 떄문에 n보다 커지는 경우 함수를 종료하고 1을 출력한다
 * 5. 만약 모든 탐색동안에 최대지점을 넘어서는 경우가 없으면 0을 출력한다
 * 6. 또한 큐에 들어가는 배열의 3번째 값으로 현재 없어진 다리의 번호를 나타내준다.
 * 7. 따라서 체크 조건으로 현재 x좌표가 없어진 다리번호보다 앞서는지 추가로 체크해주고 탐색하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {
    static boolean[][] visited;
    static boolean isOk = false;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[2][n+1];
        arr = new int[2][n+1];
        for (int i = 0; i < 2; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            }
        }


        bfs(1,n,k);
        if(isOk){
            bw.write("1");
        }else{
            bw.write("0");
        }

        br.close();
        bw.close();
    }

    private static void bfs(int start, int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,start, 1});
        visited[0][start] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int[] move = {now[1] + 1, now[1] - 1, now[1] + k };
            if(now[2] == n+1){
                return;
            }
            for (int i = 0; i < 3; i++) {
                int ny = now[0];
                if(i == 2){
                    if(ny == 0){
                        ny = 1;
                    }else{
                        ny = 0;
                    }
                }
                int nx = move[i];
                if(nx > n){
                    isOk = true;
                    return;
                }

                if(nx > 0 && !visited[ny][nx] && nx > now[2] && arr[ny][nx] == 1){
                    q.add(new int[]{ny, nx, now[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }


    }


}

