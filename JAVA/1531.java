import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 각 위치에 m개를 초과하는 종이가 올려져있어야한다
 * 2. 먼저 들어온 두 좌표를 두고 기하적으로 생각하면된다 
 * 3. 왼쪽 모서리 x좌표에서 오른쪽 모서리 x좌표까지 순회하며 동일한 모서리 y좌표만큼 순회하면서 arr의 값을 늘리면된다
 * 4. 그리고 최종적으로 다시 1부터 100까지의 좌표를 각각 순회하면서 m을 초괴하는 경우를 세어준다
 * 5. 완성한 결과인 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*|x2-x1|*|y2-y1|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[101][101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2+1; j++) {
                for (int k = y1; k < y2 + 1; k++) {
                    arr[j][k]++;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if(arr[i][j] > m){
                    ans++;
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
