import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 맨 왼쪽과 맨 위쪽에 대해서는 이전 왼쪽이나 이전 아래쪽에 대해서만 보기 때문에 예외처리로 각각에 대해 이전값을 누적하는 순회를 한다
 * 2. 이어서 왼쪽, 위쪽에 대해서 더 큰 값을 현재 배열에 넣어준다
 * 3. n-1,m-1 인덱스 값이 제일 클 수밖에 없다. 따라서 해당 위치의 값을 출력한다.
 * 
 * 해결방법:
 * 1. dp로 따로 만들고 했더니 알 수 없는 곳에서 계속 틀리는 문제가 발생하였다
 * 2. 정확한 원인은 모르나 arr을 그냥 재활용하는 방법으로 바꾸니 해결되었다
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
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < m; i++) {
            arr[0][i] += arr[0][i-1];
        }
        for (int i = 1; i < n; i++) {
            arr[i][0] += arr[i-1][0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] += Math.max(arr[i][j-1], arr[i-1][j]);
            }
        }

        bw.write(arr[n-1][m-1]+"");

        br.close();
        bw.close();
    }


}

