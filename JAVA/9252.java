import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LCS 길이를 구하는 것은 이전 LCS 문제와 동일하게 하면 된다. 만약 두 지점이 같다면 i-1, j-1 지점에 +1 한 값을 넣어준다
 * 2. 같지 않을 경우 i-1 지점과 j-1 지점중 더 큰 값을 넣어준다
 * 3. 이 문제는 LCS를 출력해야하기 때문에 조금 더 난이도가 있는 문제다. 그려둔 표를 기반으로 이해해서 구현해야한다
 * 4. 맨 끝지점부터 내려가면서 구하면 된다. LCS란 결국 공통이 되는 부분이기 때문에, 만약 내 왼쪽 지점과 위쪽 지점이 같지 않다면 i와 j를 모두 줄이고 스택에 해당 지점의 문자를 넣는다
 * 5. 만약 왼쪽 지점이 같으면 i를 줄이고 위쪽 지점이 같다면 j를 줄인다
 * 6. 이렇게 완성한 스택의 모든 값을 하나씩 꺼내서 문자열로 만들어주면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(|s1|*|s2|)
 * 공간복잡도: O(|s1|*|s2|)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        String s = "";
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        s = findLCS(s1, s1.length(), s2.length(), dp);

        bw.write(max+"\n"+(max==0?"":s));


        br.close();
        bw.close();
    }

    private static String findLCS(String s, int l1, int l2, int[][] dp) {
        Stack<Character> st = new Stack<>();
        while(l1 > 0 && l2 > 0) {

            if(dp[l1][l2] == dp[l1-1][l2]){
                l1--;
            }else if(dp[l1][l2] == dp[l1][l2-1]){
                l2--;
            }else{
                st.push(s.charAt(l1-1));
                l1--;
                l2--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
