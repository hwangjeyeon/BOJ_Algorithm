import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 먼저 A에 있는 문자열들은 Set에 관리한다
 * 2. DP를 활용하는 문제다 또한 입력값이 적기 때문에 subString 사용하여, 뒤에서부터 부분 문자열들을 모두 확인한다
 * 3. 먼저 s.substring(i)가 포함되어있으면 해당 시작 위치인 dp[i]에 1을 넣어준다
 * 4. 또한 이중포문으로 부분 문자열들을 확인하는 과정에서 만약 dp[j]가 1이고 set.contains(s.substring(i,j))라면 dp[j]에 1을 넣어준다
 * 5. 이렇게 해서 모든 순회를 돌았을 때, 맨 처음값이 1이면 문자열을 만들 수 있고 아니면 만들 수 없다
 * 6. dp의 맨 처음 값을 출력하면 정답이 된다
 *
 * 시간복잡도: O(s.length() ^ 2)
 * 공간복잡도: O(s.length())
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int[] dp = new int[s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if(dp[j] == 1 && set.contains(s.substring(i, j))){
                    dp[i] = 1;
                }
            }
            if(set.contains(s.substring(i))){
                dp[i] = 1;
            }
        }

        bw.write(dp[0]+"");

        br.close();
        bw.close();
    }

}

