import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * IntStream으로 해볼라고 했는데 StringTokenizer 변수 선언에 문제가 많아 그냥 이중 for문으로 해결함
 * 입력 받고, 이전에 담긴 최대값과 비교하여 더 큰 값을 담고 해당 좌표를 각각 변수에 넣어 출력한다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 *
 */




public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        dp = new int[9][9];
        int max = -1;
        int x=0; int y=0;
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
                if(max < dp[i][j]){
                    max = dp[i][j];
                    y = i+1;
                    x = j+1;
                }
            }
        }

        bw.write(max + "\n" + y + " " + x);
        br.close();
        bw.close();
    }


}
