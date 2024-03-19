import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식 backtracking(n,m, depth, start)
 * 2. base condition if(m==depth)
 * 3. 재귀식 (n,m,depth+1, i)
 *
 * - 이전 문제와 같이 중복되는 수를 출력해도 되므로, 방문 배열을 사용하지 않아도 된다.
 * - 비내림차순, 즉 오름차순 정렬을 해야하므로 start 파라미터를 만들고 인수로 i을 넘겨서 순회할 때, i를 start로 초기화해서 순회하도록 한다
 * - 참고로 자기 자신을 포함도 해야하므로 인수로 i를 넘겨준다. 자기자신을 포함시키고 싶지 않으면 i+1을 넘기면된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        backtracking(n,m,0, 1);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int m, int depth, int start) {
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            backtracking(n, m,depth+1, i);
        }
    }
}

