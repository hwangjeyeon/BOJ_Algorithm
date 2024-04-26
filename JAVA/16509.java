import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. BFS탐색으로 풀면 되는 문제다.
 * 2. 한가지를 더 추가해줘야하는데 문제 조건에서 상의 진행 경로에 장애물이 있으면 움직일 수 있다고 하였다
 * 3. 여기서 장애물이 되는 기물은 왕. 딱 한개 존재한다
 * 4. 따라서 조건에 맞춰서 check1과 chekc2를 만들어준다. 
 * 5. 그리고 만약 범위를 벗어나지 않거나 방문하지 않았다면 추가로 해당 경로에 장애물이 있는지 확인하는 로직을 먼저 검증을 거치도록 해서 있으면 continue하고 아니면 그대로 탐색을 진행하도록 한다
 * 6. 이렇게 해서 arr에 누적된 정답 위치의 값이 정답이 된다. 
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {

    static int[][] arr = new int[10][9];
    static boolean[][] visited = new boolean[10][9];
    static int[][] move = {{-3,-2},{-3,+2},{-2,-3}, {+2,-3}, {-2,+3},{+2,+3}, {+3,-2},{+3,+2}};
    static int[][] check1 = {{-2,-1},{-2,+1},{-1,-2},{+1,-2},{-1,+2},{+1,+2},{+2,-1},{+2,+1}};
    static int[][] check2 = {{-1,0},{-1,0},{0,-1},{0,-1},{0,+1},{0,+1},{+1,0},{+1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());
        bfs(startR,startC, endR,endC);


        if(!visited[endR][endC]){
            bw.write("-1");
        }else{
            bw.write(arr[endR][endC]+"");
        }


        br.close();
        bw.close();
    }

    private static void bfs(int startR, int startC, int endR, int endC) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC,0});
        visited[startR][startC] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = now[0] + move[i][0];
                int nx = now[1] + move[i][1];
                if(ny >=0 && nx >=0 && ny < 10 && nx < 9 && !visited[ny][nx]) {
                    if((now[0] + check1[i][0] == endR && now[1] + check1[i][1] == endC) || (now[0] + check2[i][0] == endR && now[1] + check2[i][1] == endC)){
                        continue;
                    }
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx,now[2]+1});
                    arr[ny][nx] = now[2]+1;
                }
            }

        }
    }
}

