import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. DFS인줄 알았는데 DP문제였다 ㅋㅋ
 * 2. 중간에 못가는 길 때문에 조금 까다로운 dp였다. 그리고 이 문제의 핵심은 선이지 점이 아니다
 * 3. 즉 i,j라는 특정 지점이 아니고 i,j / k,l사이의 선을 차단하는 것이 핵심이다
 * 4. 그리고 또 n,m까지라서 n+1, m+1만큼의 크기로 지정도 해줘야 한다
 * 5. 한가지 더 체크해야할 것은 i는 가로, j는 세로다. 이 문제의 그림에 따라 맞춰서 탐색하도록 선언하였따
 * 6. 가로선과 세로선을 체크해줄 두 배열을 boolean 타입으로 똑같은 크기로 선언해주었다
 * 7. 이어서 두 좌표를 입력 받을 때, 다음을 체크해야한다
 * 8. 일단 두 좌표의 거리가 1이라고 했다. 즉 가로 한칸이나 세로 한칸만큼만 떨어져 있다는 것이고, 그 말은 가로가 같거나 세로가 같은 경우가 존재한다는 것이다
 * 9. 따라서 세로가 같은 경우, 두 지점중 가로의 위치가 작은 지점에 true를 체크해주고, 반대로 가로가 같은 경우도 두 지점 중 세로의 위치가 작은 지점에 true를 표시해준다
 * 10. 최단거리로 이동하기 때문에, 작은 지점을 기준으로 true 표시를 해주었다
 * 11. dp의 0,0은 1이다. 이어서 모든 세로끝과 가로끝에 대해서도 1로 초기화한다. 왜냐하면 최단거리로 움직이기 때문에 내 아래나 내 왼쪽에 해서만 이동할 수 있기 때문이다.
 * 12. 물론 세로끝과 가로끝에 공사 길이 있다면 초기화하는 도중 break로 탈출하여 이후 길에 대해서 모두 0으로 초기화되도록 한다
 * 13. 가로 세로 모두 1부터 시작하여 탐색을 시작한다. 해당 지점으로 오는 i-1, j의 가로 길이 끊어져 있지 않다면 그 지점의 dp를 현재 dp에 더해준다
 * 14. 또한 해당 지점으로 오는 i, j-1의 세로 길이 끊어져 있지 않다면 그 지점의 dp를 현재 dp에 대해준다
 * 15. 이렇게 완성한 dp[n][m]을 출력하면 정답이 된다.
 *
 * - 문제 해결:
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

        long[][] dp = new long[n+1][m+1];

        boolean[][] horizon = new boolean[n+1][m+1];
        boolean[][] vertical = new boolean[n+1][m+1];



        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if(b == d){
                if(a > c){
                    horizon[c][b] = true;
                }else{
                    horizon[a][b] = true;
                }
            }else{
                if(b > d){
                    vertical[a][d] = true;
                }else{
                    vertical[a][b] = true;
                }
            }
        }
        dp[0][0] = 1;

        for (int i = 1; i < n+1; i++) {
            if(horizon[i-1][0]){
               break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < m+1; i++) {
            if(vertical[0][i-1]){
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(!horizon[i-1][j]){
                    dp[i][j] += dp[i-1][j];
                }

                if(!vertical[i][j-1]){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }


        bw.write(dp[n][m] + "");

        br.close();
        bw.close();
    }

}

