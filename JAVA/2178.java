import java.io.*;
import java.util.*;


/**
 * 풀이 방법: BFS 탐색 알고리즘으로 문제를 풀었습니다
 * 접근 방법:
 * 1. 최단 거리를 구하는 문제이므로 BFS는 적합하지 않습니다. 따라서 BFS 탐색 알고리즘을 선택하였습니다.
 * 2. 이전에 풀었던 1012번 유기농 배추와 비슷한 방식으로 배열을 이용하여 세팅한 다음 탐색해 나가는 방법으로 풀어야겠다고 생각했습니다
 * 풀이 과정:
 * - 이번에는 배열 테두리를 -1로 감싸지 않고 배열 인덱스 아웃 문제를 해결하기 위해 탐색 한계를 지정했습니다.-> "0보다 크거나 같아야 하고, M,N보다 작아야 함"
 * 1. bfs 탐색 알고리즘을 구현합니다. -> 상하좌우에 1이 있는 경우 해당 위치 탐색
 *
 * 문제 발생:
 * - 이전까지만 해도 단순 탐색하는 것은 문제가 없었으나, 이번에는 최단 거리를 구하는 방식이라 다르게 접근해야했습니다.
 * - 모든 탐색해야 하는 지역은 탐색할 수 있었지만 최단 거리를 구하는 방법은 알 수 없었습니다.
 *
 * 해결방법:
 * - bfs로 탐색할 때, 탐색할때 마다의 횟수를 해당 배열에 집어넣는 것입니다.
 * -> 예를들어 처음은 1, 그다음 처음의 상하좌우에 1이 있으면 2를 넣기 -> 이런식으로 접근하였습니다.
 * - 최종적으로 우리가 도달해야하는 (N-1, M-1) 좌표에는 최단거리로 갈 수 있는 숫자가 들어가 있고, 그 숫자를 출력하면 되었습니다.
 *
 * 풀고난 후:
 * - 이제 배열에서 BFS 탐색 알고리즘을 적용해서 구현하는 것은 쉬웠으나, 새롭게 접근할 수 있는 BFS 탐색 알고리즘을 접하고 나니 아직 더 배워야 한다는 것을 깨닫게 되었습니다
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] fields = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                    fields[i][j] = s.charAt(j)-48;
            }
        }

        int ans = 1;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(0);
        bfs.add(0);
        fields[0][0] = 1;
        while(!bfs.isEmpty()){
            int y = bfs.poll();
            int x = bfs.poll();


               if(y-1 >= 0 && fields[y-1][x] == 1){ // 내 위가 0보다 크거나 같아야 함
                   bfs.add(y-1);
                   bfs.add(x);
                   fields[y-1][x] = fields[y][x] + 1;

               }
                if(y+1 < N && fields[y+1][x] == 1){ // 내 아래가 N보다 작아야 함
                    bfs.add(y+1);
                    bfs.add(x);
                    fields[y+1][x] = fields[y][x] + 1;
                }
                if(x-1 >=0 && fields[y][x-1] == 1){ // 내 왼쪽이 0보다 크거나 같야아 함
                    bfs.add(y);
                    bfs.add(x-1);
                    fields[y][x-1] = fields[y][x] + 1;
                }
                if(x+1 < M && fields[y][x+1] == 1){ // 내 오른쪽이 M보다 작아야 함
                    bfs.add(y);
                    bfs.add(x+1);
                    fields[y][x+1] = fields[y][x] + 1;
                }
        }
        ans = fields[N-1][M-1];
        bw.write(ans + "");
        br.close();
        bw.close();

    }
}
