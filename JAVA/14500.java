import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 시간제한과 메모리 제한, 그리고 입력값이 충분히 작아서 하드코딩 방법을 생각하였다.
 * - 모든 모양을 3차원 배열로 선언해준다. 맨 앞은 각 블록 종류(하나의 종류에서 회전한 모양도 서로 다른 것으로 본다)
 * - 두번째는 각 블록 하나하나의 좌표를 담은 요소들의 집합(길이로 보면 된다)
 * - 세번째는 각 블록 하나하나의 y,x 좌표이다
 * - 필드 크기만큼 순회를 해준다
 * - 이때 블록의 모든 배열을 가져오고, 이어서 각 블록의 좌표를 가져와서 현재 기준이 되는 i,j에 맞춰서 서로 더해준 nowY, nowX를 선언한다
 * - 이어가기 전에 먼저 해당 배열이 field 인덱스 범위를 벗어났는지를 확인한다
 * - 벗어나지 않았다면 더해주고 순회를 반복하여, 해당 좌표에 해당하는 field의 값을 블록의 길이만큼 더해준다
 * - 이제 해당 sum 변수가 max보다 큰지 비교하고, 더 크면 바꿔준다.
 * - 이런식으로 모든 블록을 확인하고 최종적으로 max를 출력하면 정답이 된다
 *
 * - 순회 부분 참고: https://sirobako.co.kr/detail/60
 * - DFS로도 풀 수 있다는데, 해당 내용은 학습후에 다시 확인해서 풀 예정
 * - 깡구현 문제라 혼자 풀 수 있었는데, 시간 문제로 깊은 고민 없이 풀이를 보는 만행을 저질렀다... 
 * - 앞으로는 최대한 고민한 다음에 참고를 하는 것으로 하자!
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^3)
 *
 */



public class Main {

    static int[][][] polynomial = {
            //1. 긴 블록
            {{0,0}, {0,1}, {0,2}, {0,3}},
            {{0,0}, {1,0}, {2,0}, {3,0}},

            //2. 네모 블록
            {{0,0}, {0,1},{1,0},{1,1}},

            //3. ㄴ블록
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,2},{0,1},{0,0},{1,0}},
            {{2,1},{1,1},{0,1},{0,0}},
            {{1,0},{1,1},{1,2},{0,2}},
            {{0,1},{1,1},{2,1},{2,0}},
            {{1,2},{1,1},{1,0},{0,0}},
            {{2,0},{1,0},{0,0},{0,1}},
            {{0,0},{0,1},{0,2},{1,2}},

            //4. ㄹ블록
            {{0,0},{1,0},{1,1},{2,1}},
            {{0,2},{0,1},{1,1},{1,0}},
            {{0,1},{1,1},{1,0},{2,0}},
            {{1,2},{1,1},{0,1},{0,0}},

            //5. ㅜ블록
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,1},{1,1},{2,1},{1,0}},
            {{1,2},{1,1},{1,0},{0,1}},
            {{2,0},{1,0},{0,0},{1,1}}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[][] poly : polynomial) {
                    int sum = 0;
                    boolean isOk = true;
                    for (int[] block : poly) {
                        int nowY = i + block[0];
                        int nowX = j + block[1];
                        if(nowX < 0 || nowX >= m || nowY < 0 || nowY >= n){
                            isOk = false;
                            break;
                        }

                        sum += field[nowY][nowX];
                    }

                    if(isOk){
                        max = Math.max(sum, max);
                    }
                }
            }
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

}

