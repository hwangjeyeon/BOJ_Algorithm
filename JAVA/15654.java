import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전에는 1부터 n까지의 값을 넣는 백트래킹 문제였다면, 이번에는 입력받은 값들을 기준으로 값을 넣는 백트래킹 문제이다
 * - 입력받은 값들을 배열에 저장하고 사전 순으로 증가하는 순서로 출력하기 위해 오름차순 정렬을 한다
 * - 이후에 똑같이 재귀함수를 통해 백트래킹을 진행한다.
 * - 이번에는 visited 배열을 사용하여, 중복되는 수열을 여러번 출력하지 않게 한다.
 * - 이렇게 완성된 최종 StringBuild를 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int[] input;
    static int[] ans;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        ans = new int[m+1];
        sb = new StringBuilder();
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            input[i] =  Integer.parseInt(st.nextToken());
        }
        input = Arrays.stream(input)
                .sorted()
                .toArray();
        backTracking(n,m,0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int depth) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=0; i<n; i++){
            if(visited[i]){
                continue;
            }
            ans[depth] = input[i];
            visited[i] = true;
            backTracking(n,m,depth+1);
            visited[i] = false;
        }

    }

}
