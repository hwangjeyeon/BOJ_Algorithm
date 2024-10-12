import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 방문배열을 활용하여 해결하였다
 * 2. 이중포문으로 탐색하며, 안쪽 포문에 대해서는 j부터 시작해서 j만큼 더하는 방향으로 탐색하고, 해당하는 k번째 인덱스의 값만 값을 반전시킨다
 * 3. 이후 1부터 n까지 순회를 돌며 true인 개수를 세어주고 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T*n^2)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            boolean[] visited = new boolean[n+1];
            for (int j = 1; j < n+1; j++) {
                for (int k = j; k < n + 1; k+=j) {
                    visited[k] = !visited[k];
                }
            }

            for (int j = 1; j < n + 1; j++) {
                if(visited[j]){
                    ans++;
                }
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}

