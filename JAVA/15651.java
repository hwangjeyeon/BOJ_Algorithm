import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백트래킹 학습 중..
 * - 이전 문제들과 비슷한 문제이다
 * - 이번에는 visited배열을 사용할 필요가 없다.
 * - 파라미터는 입력값들인 int n, int m이며 추가로 종료를 위한 int depth까지 선언한다
 * - 반복문 순회속에서 정답 배열에 현재 순회중인 i값을 넣는 ans[depth] = i을 진행한다
 * - 재귀함수는 backTracking(n,m,depth+1)으로 진행하며 종료조건은 depth==m이다.
 * - 종료조건일 때 StringBuilder에 0~m만큼 순회하여 append하고 종료한다
 * - 이후 StringBuilder를 String으로 출력하면 된다.
 * 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */





public class Main {
    static int[] ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        ans = new int[m];

        backTracking(n,m, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int depth) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(ans[i])
                        .append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=1; i<=n; i++){
            ans[depth] = i;
            backTracking(n,m,depth+1);
        }




    }


}
