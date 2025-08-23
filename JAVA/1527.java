import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 백트래킹으로 현재 수 cur *10 에 4를 더하는 경우와 7을 더하는 경우를 구한다
 * 2. base Condition으로는 b보다 큰경우 종료하고, a이상인 경우는 ans를 증가시키면 된다
 * 3. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        backtracking(a,b, 0L);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int a, int b, long cur) {
        if(cur > b){
            return;
        }
        if(cur >= a){
            ans++;
        }
        backtracking(a, b, cur*10+4);
        backtracking(a, b, cur * 10 + 7);
    }

}
