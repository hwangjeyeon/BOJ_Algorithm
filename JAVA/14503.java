import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - continue 빼먹어서 2일동안 개고생했던 문제...
 * - 로직만 이해하고 그대로 구현하면 되는 문제이다.
 * - while(true) 순회로 일정 조건이 될때까지 시뮬레이션 돌리면 된다
 * - 현재 좌표를 계속 갱신해주고, 만약 그 칸이 청소가 되어있지 않은 빈칸이라면 청소하고 count값을 증가시킨다
 * - 그리고 상하좌우를 확인해서 청소여부를 확인하고 청소가 안 되어있는 칸이 있으면 false로 있으면 true로 간다
 * - false일 때는 각 방향별로 반시계 방향으로 회전한 뒤, 그 방향에 맞는 앞칸의 청소 여부를 확인해준다. 청소가 되어 있으면 그 앞 방향 좌표로 갱신한다
 * - true일때는 현재 바라보고 있는 방향에 해당하는 조건을 찾아서 그 앞 방향이 1이 아니면 값을 그 앞 좌표로 갱신해준다.
 * - 그리고 1이면 break; 해주고 count를 리턴한뒤 출력한다
 * - 내가 true일때 조건에서 continue를 안해서 2번 예제가 자꾸 53으로 나왔었다.
 * - 2일동안 고민했는데 안 보여서 결국 답지 보고 그 것으로 제출했는데, 로직은 분명 맞았는데 안 풀리는거라 억울해서 다시 보다 보니까 왜 안 나오는지 문제가 되는 부분을 발견하게 되었다.
 * - 값을 갱신한 상태로, 즉 이동한 상태에서 다시 내 앞에 벽인지를 보는 문제가 생겼기에 원하는 결과가 안 나왔던 것이었다.
 * - 이 문제를 갱신하고 continue로 fix해서 문제를 풀게 되었다. 너무 행복하다 ㅋㅋ
 * 
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }


        bw.write(String.valueOf(robotCleaner(r, c, arr, d)));
        br.close();
        bw.close();
    }

    private static int robotCleaner(int r, int c, int[][] arr, int d) {
        int nowR = r;
        int nowC = c;
        int count = 0;
        while(true){
            if(arr[nowR][nowC] == 0) {
                arr[nowR][nowC] = -1;
                count++;
            }

            boolean clean = true;
            //상
            if(arr[nowR-1][nowC] == 0){
                clean = false;
            }

            //하
            if(arr[nowR+1][nowC] == 0){
                clean = false;
            }

            //좌
            if(arr[nowR][nowC-1] == 0){
                clean = false;
            }

            //우
            if(arr[nowR][nowC+1] == 0){
                clean = false;
            }

            if(clean){
                if(d == 0){
                    if(arr[nowR+1][nowC] != 1){
                        nowR = nowR + 1;
                        continue;
                    }
                    if(arr[nowR+1][nowC] == 1){
                        break;
                    }
                }else if(d == 1){
                    if(arr[nowR][nowC-1] != 1){
                        nowC = nowC - 1;
                        continue;
                    }
                    if(arr[nowR][nowC-1] == 1){
                        break;
                    }
                }else if(d == 2){
                    if(arr[nowR-1][nowC] != 1){
                        nowR = nowR - 1;
                        continue;
                    }
                    if(arr[nowR-1][nowC] == 1){
                        break;
                    }
                }else if(d == 3){
                    if(arr[nowR][nowC+1] != 1){
                        nowC = nowC + 1;
                        continue;
                    }
                    if(arr[nowR][nowC+1] == 1){
                        break;
                    }
                }
            }else{
                if(d == 0){
                    d = 3;
                    if(arr[nowR][nowC-1] == 0){
                        nowC = nowC-1;
                    }

                }else if(d == 1){
                    d = 0;
                    if(arr[nowR-1][nowC] == 0){
                        nowR = nowR-1;
                    }

                }else if(d == 2){
                    d = 1;
                    if(arr[nowR][nowC+1] == 0){
                        nowC = nowC+1;
                    }
                }else if(d == 3){
                    d = 2;
                    if(arr[nowR+1][nowC] == 0){
                        nowR = nowR+1;
                    }
                }
            }

        }
        return count;
    }
}

