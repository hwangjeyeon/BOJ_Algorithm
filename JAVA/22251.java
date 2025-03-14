import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이 문제는 약간의 노가다성 구현과 백트래킹을 조합하면 되는 문제다
 * 2. 단순히 반전여부로 판단하기보다는 현재 숫자에서 다른 숫자로 변경할 때 필요한 개수를 생각하면 쉽다
 * 3. 그리고 백트래킹으로 현재 자릿수, 몇번째 자리숫자인지, 지금 숫자, 변경 개수를 파라미터로 받는다
 * 4. 만약 지금 숫자가 최대 층수보다 크거나 변경개수를 초과하면 그냥 종료한다
 * 5. 지금 자릿수가 k랑 동일하면 현재 숫자가 0이 아닌 경우 ans를 증가한다. 이후 종료한다
 * 6. 0~9까지의 숫자를 백트래킹한다 자릿수는 +1하고 몇번째 자리 숫자인지는 10을 곱하면된다
 * 7. i*몇번째 자릿수 + now하면 자릿수를 변경한 숫자가 된다. 변경 개수는 cnt + num[x/idx%10][i]한 값을 넘겨주면된다
 * 8. 완성한 ans에서 자기자신을 빼야하므로 ans-1을 하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(10^K)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    static int[][] num = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static int n;
    static int k;
    static int p;
    static int x;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ans = 0;
        backtracking(0,1,0,0);

        bw.write((ans-1)+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int idx, int now, int cnt) {
        if(now > n || cnt > p){
            return;
        }
        if(depth == k){
            if(now != 0){
                ans++;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            backtracking(depth+1, idx*10, i*idx+now, cnt+num[x/idx%10][i]);
        }
    }


}
