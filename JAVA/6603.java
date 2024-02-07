import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백트래킹을 이용해서 푸는 문제이다
 * - 진행 정도인 depth를 함수 종료 조건으로 황용한다.
 * - depth가 r과 같아지면 StirngBuilder에 넣고 종료한다
 * - 아닐 경우 백트래킹을 하는데, 파라미터로 받은 start와 visited배열을 이용한다
 * - start부터 n까지 순회하는동안에 먼저 현재 i의 visited 배열 내 인덱스를 true로 바꾸고, 재귀함수를 호출하는데 depth와 i에 1을 더한 값을 인수로 넘겨준다
 * - 재귀함수 뒤에는 visited 배열의 값을 false로 바꾼다. 
 * - 이렇게 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void lotto(int[] arr, boolean[] visited, int n, int r, int depth, int start){
        if(depth == r){
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            lotto(arr,visited, n,r, depth+1, i+1);
            visited[i] = false;
        }

    }

    static void print(int[] arr, boolean[] visited, int n){
        for (int i = 0; i < n; i++) {
            if(visited[i]){
                sb.append(arr[i]).append(" ");
            }
        }
        sb.append("\n");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = -1;
        while(true){
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            if(T == 0){
                break;
            }
            sb = new StringBuilder();
            int[] arr = new int[T];
            boolean[] visited = new boolean[T];
            for (int i = 0; i < T; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            lotto(arr, visited, T, 6,0, 0);
            bw.write(sb.toString());
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}

