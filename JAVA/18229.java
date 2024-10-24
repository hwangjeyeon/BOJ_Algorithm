import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값을 배열로 관리한다
 * 2. 차원을 뒤집어서 순회한다.
 * 3. arr배열에 각 값을 더해서 갱신한다. 만약 k 이상인 경우가 있다면 j+1을 사람의 번호로, i+1을 횟수로 하여 break해서 탈출하고 출력한다.
 * 4. 바깥쪽 포문은 p값의 변동사항을 확인해서 break해주면 된다
 *
 * - 문제 해결:
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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int[][] input = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = -1;
        int p = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[j] += input[j][i];
                if(arr[j] >= k){
                    answer = (i+1);
                    p = (j+1);
                    break;
                }
            }
            if(answer != -1){
                break;
            }
        }
        bw.write(p +" " + answer);

        br.close();
        bw.close();
    }
}

