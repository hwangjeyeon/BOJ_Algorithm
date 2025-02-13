import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 처음에는 그리디한 방법으로 풀었다가 틀린 문제다
 * 2. 이 문제는 LIS랑 비슷한 느낌으로 풀면된다.
 * 3. 더 정확히 말하면 문제에 힌트가 있다. 삭제연산을 잘 보면, 문자를 하나 지우고 점수를 1점 얻는다라고 나와있는데, 이것을 잘 활용하면, 이중포문으로 부분 문자열을 비교하며 dp를 채워가면 된다
 * 4. dp는 문자열 + 1만큼의 크기로 선언하고, 이중포문으로 정답을 찾는다
 * 5. j는 i보다 작거나 같으며, substring으로 j,i 지점을 가져온다.
 * 6. 이전에 입력으로 받는 부분 문자열과 점수는 처음에는 Pair 방식을 사용했는데, 여기서 추가 포문을 피하기 위해서 HashMap을 사용해서 보관한다. String이 Key고 Integer가 value다
 * 7. 만약 현재 부분 문자열이 Map의 Key로 있다면 dp[i]에는 dp[i]와 dp[j] + map.get(a)를 비교해서 더 큰 값으로 변경한다
 * 8. 만약 포함되어 있지 않다면 dp[i]와 dp[i-1] + 로 이전 결과에 현재 문자 하나를 삭제해서 1점을 얻는 연산을 추가한다
 * 9. 완성한 dp[s.length()]의 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(|S|^2)
 * 공간복잡도: O(|S|)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
        }


        int[] dp = new int[s.length()+1];
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j <= i; j++) {
                String a = s.substring(j, i);
                if(map.containsKey(a)){
                    dp[i] = Math.max(dp[i], dp[j] + map.get(a));
                }else{
                    dp[i] = Math.max(dp[i], dp[i-1] + 1);
                }
            }
        }


        bw.write(dp[s.length()]+"");

        br.close();
        bw.close();
    }

}
