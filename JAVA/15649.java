import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백트래킹 학습을 위해 공부 후, 힌트를 참고해서 풀었습니다.
 * - 재귀함수 파라미터는 다음과 같다:  backTracking(int n, int m, int start)
 * - n은 숫자를 담기 위해서, m은 함수의 종료를 위해서, start는 재귀함수 진행을 위해서 설정하였다
 * - 종료조건은 start==m일때이다. 이때 StringBuilder를 통해 m만큼 순회하여 값들을 append한다.
 * - 1부터 n까지 순회하는데 이때 visited[i] == true인 경우 continue로 건너뛴다
 * - false인 경우 visited[i] = true로 방문을 설정하고, arr[start]에 값을 현재 i값을 넣어준다
 * - 이후 재귀함수를 실행하는데 n과 m은 그대로 하고 start+1을 통해 재귀함수를 진행시킨다
 * - 재귀함수 뒤에는 visited[i] = false를 통해 중복되지는 않으나 다른 수열에서 재활용할 수 있게 하여, 원하는 값이 나오도록 한다
 * - 이렇게 완성한 최종 StringBuilder를 출력한다.
 *
 * 시간복잡도: O(n!) -> 백트래킹의 가지치기를 하지 않는 최악의 경우
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];
        sb = new StringBuilder();
        backTracking(n,m, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int start) {
        if(start == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            arr[start] = i;
            backTracking(n,m,start+1);
            visited[i] = false;
        }

    }


}
