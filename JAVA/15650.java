import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백트래킹 공부 2일차
 * - 재귀는 여전히 어렵다... 재귀 구현 능력을 키울 방법을 키워야겠다. 다른 배열이나 리스트 같은 자료구조들과 다르게 작동 원리가 머리속에서 쉽게 그려지지 않는다..
 * - 이 방법은 기존 15649번 문제에서 시작 지점만 추가해주면 되는문제다
 * - 따라서 기존 start를 depth로 바꿔주고 start 파라미터를 추가했다
 * - 반복문에서 int i=start부터 시작하고, 재귀함수에서는 i+1을 넘겨준다.
 * - 이렇게 되면, 기존에 왼쪽에서 방문한 숫자의 경우 오른쪽에서 방문하지 않는다.
 * - 최종적으로 완성된 결과를 StringBuilder를 통해 출력해준다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */





public class Main {

    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];
        sb = new StringBuilder();
        backTracking(n,m, 0, 1);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int depth, int start) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }



        for(int i=start; i<=n; i++){
            if(visited[i]){
                continue;
            }
            arr[depth] = i;
            visited[i] = true;
            backTracking(n,m,depth+1, i+1);
            visited[i] = false;
        }
    }


}
