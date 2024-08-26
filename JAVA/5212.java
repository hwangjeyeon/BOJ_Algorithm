import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 4가지로 나눠서 탐색하면 된다
 * 2. 먼저 입력을 char 타입의 2차원 배열에 받아 관리한다
 * 3. dfs 4방 탐색에서 사용하던 dx, dy 배열을 이용하여 탐색에 사용한다
 * 4. 50년 뒤의 결과를 똑같은 형태의 char타입 2차원 배열을 만들어서 보관한다
 * 5. 이중 포문을 돌면서 현재 위치가 'X'이면, 4방 탐색을 하고,인덱스 범위를 벗어나는 경우와 벗어나지 않는데 .인 경우는 count를 세어준다
 * 6. count가 3이상인 경우 find 배열에 .을 넣어주며 아닌 경우 X를 넣어준다
 * 7. 그냥 .인 경우 그냥 .을 넣어준다
 * 8. 이제 직사각형의 범위를 찾기 위해 상하좌우의 네 모서리 범위를 탐색한다
 * 9. left와 right, top, bottom은 각 위치의 반대로 초기화해주고, 탐색하면서 범위를 좁혀나간다
 * 10. 이때 범위는 현재 위치가 'X'인 경우, left와 top은 최소 right와 bootm은 최대로 초기화한다
 * 11. 이제 마지막으로 앞서 완성한 범위를 기준으로 출력하면 정답이 된다.
 * 12. 탐색은 i의 경우 top부터 bottom까지, j의 경우 left부터 right까지이다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(r*c*4)
 * 공간복잡도: O(r*c)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = input[j].charAt(0);
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        char[][] find = new char[r][c];
        // 2중포문 돌면서 4방 탐색
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = 0;
                if(arr[i][j] == 'X'){
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 0 || ny >= r || nx < 0 || nx >= c){
                            count++;
                        }else{
                            if(arr[ny][nx] == '.'){
                                count++;
                            }
                        }
                    }
                    if(count >= 3){
                        find[i][j] = '.';
                    }else{
                        find[i][j] = 'X';
                    }
                }else{
                    find[i][j] = '.';
                }
            }
        }

        // 직사각형 범위를 위해 좌우 가로, 상하 세로 탐색
        int left = c;
        int right = -1;
        int top = r;
        int bottom = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(find[i][j]== 'X'){
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }

        //위 범위를 기준으로 출력
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                bw.write(find[i][j]);
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }
}

