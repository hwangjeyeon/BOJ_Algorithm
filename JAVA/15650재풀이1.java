import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식 backtracking(n,m, depth, start)
 * 2. base condition if(m==depth)
 * 3. 재귀식 (n,m,depth+1, i+1)
 *
 * - 1번 문제에서 한가지가 추가되었다. 오름차순 정렬이 되도록 출력해야한다
 * - 따라서 한 줄 출력에서 맨앞보다 큰 수만이 뒤에 올 수 있다
 * - 오름차순 정렬을 위해 시작하는 위치를 함수 인수로 넘겨야한다
 * - 선택한 방법은 i+1을 넘기는 것이다. 그렇게 해서 그 다음 순회때 i을 start로 초기화하면 그 이전 값들은 순회하지 않게 된다
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
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
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
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtracking(n,m,depth+1, i+1);
                visited[i] = false;
            }
        }



    }
}

