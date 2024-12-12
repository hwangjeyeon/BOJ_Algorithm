import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이전에 구간 합 구하기 4의 방식을 이용해서 누적합을 구한다.
 * 2. 그다음 부분행렬을 확인하기 위해 기준이되는 지점과 최대값을 찾기 위해 확장하면서 탐색할 지점을 완전탐색하여 최대값을 찾는다
 * 3. 이때 확장하는 지점은 기준이 되는 지점보다 작지 않게 탐색하며, 최댓값은 앞서 누적합을 구하는 방식을 활용하여 비교하고 구한다
 * 4. 완성한 최댓값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2 * m^2)
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
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = new int[n+1][m+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + arr[i][j] - sum[i-1][j-1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                for (int k = i; k < n+1; k++) {
                    for (int l = j; l < m+1; l++) {
                        max = Math.max(max, sum[k][l] - sum[i-1][l] - sum[k][j-1] + sum[i-1][j-1]);
                    }
                }
            }
        }


        bw.write(max+"");


        br.close();
        bw.close();
    }

}
