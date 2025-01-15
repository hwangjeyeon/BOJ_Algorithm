import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 꽤 어려운 깡구현 문제였다.
 * 2. 처음에는 경사로를 먼저 설치하고 체크하려고 했으나, 경사로의 방향을 생각해주어야하기 때문에 중복으로 체크되는 문제가 밸상했다
 * 3. 따라서 체크하면서 해당되는 경우 경사로를 체크하는 방향으로 선회하였다
 * 4. 세로줄과 가로줄을 구분해서 탐색해야한다
 * 5. 공통적으로 다음과 같이 구현한다. 먼저 차이를 구한다
 * 6. 처음에는 절댓값 차이로 구분하려 했으나, 어느쪽이 큰지를 확인해야하므로 그냥 크기를 구한다
 * 7. 만약 크기가 1보다 크거나 -1보다 작은 경우는 false를 리턴한다. 경사로를 설치할 수 없다
 * 8. 이어서 만약 -1인 경우, 다음지점이 더 큰 것이고 k만큼 탐색하면서 조건에 맞는지 확인한다
 * 9. 만약 현재 길이에서 뺀 값이 0보다 작거나 경사로를 이미 설치했는지 체크하는 경사로 방문 배열이 true일 경우 false를 리턴한다
 * 10. 또한 현재 위치의 값과 처음 시작 값이 다른 경우도 false를 리턴한다
 * 11. 만약 모두 해당되지 않는 경우 cline 방문 배열에 true를 체크한다
 * 12. 차이가 1인 경우 현재 지점이 더 큰 것이므로 다음 지점부터 경사로를 설치한다
 * 13. 이번에는 현재 길에어서 더한 값으로 앞서 진행한 검증을 재진행하고, 모두 해당되지 않는 경우 cline 방문 배열에 true를 체크한다
 * 14. 모든 탐색을 통과하는 경우 true를 리턴하며 ans를 증가시킨다
 * 15. 반대의 경우도 똑같이 진행하고, 고정/변동 인덱스 위치만 변화시킨다
 * 16. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2*k)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(checkHor(n,arr,i,k)){
                ans++;
            }
        }

        for (int i = 0; i < n; i++) {
            if(checkVer(n,arr,i,k)){
                ans++;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static boolean checkVer(int n, int[][] arr, int vertical, int k){
        boolean[] cline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = arr[vertical][i] - arr[vertical][i+1];
            if(diff > 1 || diff < -1){
                return false;
            }else if(diff == -1){
                for (int j = 0; j < k; j++) {
                    if(i - j < 0 || cline[i-j]){
                        return false;
                    }
                    if(arr[vertical][i] != arr[vertical][i-j]){
                        return false;
                    }
                    cline[i-j] = true;
                }
            }else if(diff == 1){
                for (int j = 1; j <= k; j++) {
                    if(i+j >= n || cline[i+j]){
                        return false;
                    }
                    if(arr[vertical][i] - 1 != arr[vertical][i+j]){
                        return false;
                    }
                    cline[i+j] = true;
                }
            }
        }

        return true;
    }

    private static boolean checkHor(int n, int[][] arr, int horizontal, int k) {
        boolean[] cline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i][horizontal] - arr[i+1][horizontal];
            if(diff > 1 || diff < -1){
                return false;
            }else if(diff == -1){
                for (int j = 0; j < k; j++) {
                    if(i- j < 0 || cline[i-j]){
                        return false;
                    }
                    if(arr[i][horizontal] != arr[i-j][horizontal]){
                        return false;
                    }
                    cline[i-j] = true;
                }
            }else if(diff == 1){
                for (int j = 1; j <= k; j++) {
                    if(i+j >= n || cline[i+j]){
                        return false;
                    }
                    if(arr[i][horizontal] - 1 != arr[i+j][horizontal]){
                        return false;
                    }
                    cline[i+j] = true;
                }
            }
        }

        return true;
    }

}
