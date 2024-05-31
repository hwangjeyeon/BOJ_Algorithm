import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 일단 앞면이면 스킵
 * 2. 맨 마지막 값부터 처음까지 역으로 탐색한다. 이때 해당 위치가 1이면 그 처음부터 그 위치까지 현재 위치의 좌표만큼 탐색해서 반전시켜준다
 * 3. 2번일 경우마다 count값을 증가시키며 순회 종료 후, count를 출력하면 정답이 된다
 * 4. 4중 포문으로 풀었는데 n과 m이 100이라서 시간제한에 걸리지 않는다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m*n*m)
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
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if(arr[i][j] == 1){
                    for (int k = 0; k <= i; k++) {
                        for (int l = 0; l <= j; l++) {
                            if(arr[k][l] == 1){
                                arr[k][l] = 0;
                            }else{
                                arr[k][l] = 1;
                            }
                        }
                    }
                    count++;
                }
            }
        }



        bw.write(count+"");

        br.close();
        bw.close();
    }



}

