import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. 처음에는 m만큼 순회돌면서 그 값들을 문자열로 바꿔서 리스트에 넣고 3중 포문에서 그 리스트만큼 순회를 도는 방법을 생각했다
 * 2. 이 방법은 시간 초과가 발생한다 n^3*m일때 m의 최대 입력이 1만이라 시간초과가 발생한다
 * 3. 두번째 방법은 미리 배열을 생성해서 표시를 해두는 것이다
 * 4. 이 방법을 통해 true로 미리 표시해두었다
 * 5. [a][b]와 [b][a]모두 true로 표시해둔다 a와 b둘중 어떤 것이 큰지 알 수 없기 때문이다
 * 6. 삼중 포문중 두번째 포문때, 먼저 [i][j]가 해당되는지 체크해준다.
 * 7. 이어서 삼중 포문때, [j][k]와 [i][k]가 해당되는지 체크해준다. 모두 만족시키면 count++해준다
 * 8. 완성한 count를 출력하면 정답이다.
 *
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(nm)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        boolean[][] arr = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if(arr[i][j]){
                    continue;
                }
                for (int k = j+1; k <= n; k++) {
                    if(!arr[j][k] && !arr[i][k]){
                        count++;
                    }
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

}
