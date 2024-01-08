import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 기존 백트래킹 문제와 동일하며 한가지 가지치기 조건만 바뀐다
 * - 비내림차순을 위해, 첫번째 인덱스인 depth가 0인 경우는 제외 그리고 depth-1이 i보다 큰 경우는 continue로 건너뛴다
 * - 위 가지치기를 통해 원하는 결과물을 StringBuilder에 얻을 수 있다
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */





public class Main {

    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        backTracking(n,m, 0);
        bw.write(sb.toString());


        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int depth) {
        if(depth == m){
            for(int i=0; i<m; i++) {
                sb.append(arr[i])
                        .append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=1; i<=n; i++){
            if(depth > 0 && arr[depth-1] > i){
                continue;
            }

            arr[depth] = i;
            backTracking(n,m, depth+1);
        }


    }


}
