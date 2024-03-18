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
 * - visited[n] 배열을 통해 depth 진행상황에서 방문을 했으면 제외시켜줌
 * - 처음에는 순회했을 떄 해당 위치를 방문했을 경우 StringBuilder에 추가하는 방향으로 했으나 가지치기가 제대로 되지않음
 * 또한 순서도 유지가 되지 않는다
 * - 따라서 선택한 방식이 별도의 배열을 선언한다. 이때 배열은 depth 좌표를 가지고 각 depth마다 i+1값을 가진다
 * - 이후 base condition에서 arr[i]를 각각 뽑아서 StringBuilder에 넣어준다.
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
        visited = new boolean[n];
        arr = new int[m];
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

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                backtracking(n,m,depth+1);
                visited[i] = false;
            }
        }



    }
}

