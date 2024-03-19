import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식 backtracking(n,m, depth)
 * 2. base condition if(m==depth)
 * 3. 재귀식 (n,m,depth+1)
 *
 * - 이번에는 다시 visited 배열을 사용한다
 * - 그리고 이번 문제는 한가지 규칙을 파악해야한다. 재귀 내에서는 중복되도 되나, 반복문안에서는 숫자가 이전값과 같으면 안된다
 * - 따라서 순회 밖에서 before=0 변수를 초기화해주고 안에서는 현재 input[i]가 before랑 같지 않은 경우 앞선 로직을 실행하도록 조건을 추가한다
 *
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
    static int[] input;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backtracking(n,m,0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int m, int depth) {
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i] && before != input[i]){
                visited[i] = true;
                arr[depth] = input[i];
                before = input[i];
                backtracking(n, m,depth+1);
                visited[i] = false;
            }

        }
    }
}

