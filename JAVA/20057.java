import java.io.*;
import java.util.*;

/**
 * 풀이 과정: 
 * 1. 배열의 최대 크기가 작기 때문에 구현으로 가능하다
 * 2. 이동 경로에 따른 시뮬레이션 환경을 미리 세팅해둔다. 잘 세팅해두면 이동경로에 따른 범위 검증을 하지 않아도 된다
 * 3. 맨 마지막 이동만 신경써주자. 우 -> 좌로 이동할 때, 이동 크기가 유일하게 증가하지 않는다.
 * 4. 한번에 토네이도를 이동시키면 안되고, 이동 경로를 한칸씩 이동하며 작업을 진행해야 한다
 * 5. 모래를 흩날리는 작업은 비율은 고정시켜두고, 상하좌우 방향에 따라 9개의 위치를 지정해서 해당 위치에 모래 비율만큼 흩날리도록 한다
 * 6. 또한 마지막에 알파지점에 모래를 이동시키기 위해 방향에 따라 추가 이동경로를 편의 배열로 만들어둔다. 
 * 7. 범위를 벗어나면 ans에 넣고 아니면 지정한 위치에 모래를 비율만큼 배치시킨다
 * 8. 최종장에 도달하면 바로 종료하도록 시뮬레이션을 세팅하고 범위 밖을 벗어난 모래의 양을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */
public class Main {

    static int n;
    static int[][] arr;
    static int ans = 0;
    static int[][] percentPosY = {{0,-1,1,-2,-1,1,2,-1,1}, {2,1,1,0,0,0,0,-1,-1}, {0,-1,1,-2,-1,1,2,-1,1}, {-2,-1,-1,0,0,0,0,1,1}};
    static int[][] percentPosX = {{-2,-1,-1,0,0,0,0,1,1}, {0,-1,1,-2,-1,1,2,-1,1}, {2,1,1,0,0,0,0,-1,-1}, {0,1,-1,2,1,-1,-2,1,-1}};
    static double[] percent = {0.05, 0.1, 0.1, 0.02, 0.07, 0.07, 0.02, 0.01, 0.01};
    static int[] alphaY = {0,1,0,-1};
    static int[] alphaX = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nowY = n/2;
        int nowX = n/2;
        int count = 1;
        int d = 0;
        while(true){


            switch (d){
                case 0:
                    for (int i = 0; i < count; i++) {
                        nowX--;
                        sand(nowY, nowX,d);
                    }
                    d++;
                    break;
                case 1:
                    for (int i = 0; i < count; i++) {
                        nowY++;
                        sand(nowY, nowX,d);
                    }
                    d++;
                    count++;
                    break;
                case 2:
                    for (int i = 0; i < count; i++) {
                        nowX++;
                        sand(nowY, nowX, d);
                    }
                    d++;
                    break;
                case 3:
                    for (int i = 0; i < count; i++) {
                        nowY--;
                        sand(nowY, nowX,d);
                    }
                    d = 0;
                    count++;
                    break;
            }

            // 마지막 토네이도 예외처리
            if(nowY == 0 && nowX == n-1){
                count--;
            }

            if(nowY == 0 && nowX == 0){
                break;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void sand(int nowY, int nowX, int d) {
        int sum = arr[nowY][nowX];
        for (int i = 0; i < 9; i++) {
            int ny = nowY + percentPosY[d][i];
            int nx = nowX + percentPosX[d][i];
            if(!isRange(ny,nx)){
                int tmp = (int) (arr[nowY][nowX] * percent[i]);
                sum -= tmp;
                ans += tmp;
                continue;
            }

            int tmp = (int) (arr[nowY][nowX] * percent[i]);
            sum -= tmp;
            arr[ny][nx] += tmp;
        }
        arr[nowY][nowX] = 0;
        int ny = alphaY[d] + nowY;
        int nx = alphaX[d] + nowX;
        if(!isRange(ny,nx)){
            ans += sum;
            return;
        }
        arr[ny][nx] += sum;
    }

    private static boolean isRange(int ny, int nx) {
        return ny >=0 && ny < n && nx >= 0 && nx < n;
    }

}
