import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LCS인가 생각했는데, 두문자열 공통 부분 비교하는건 아니고 그냥 두 문자열 두고 조건에 맞춰서 주어진 부분 문자열에 해당하는 조합 구하는 문제다
 * 2. 문제는 경우의 수가 int형 최대까지 나올 수도 있기 때문에, dp로 풀어야한다
 * 3. dfs를 만들어서 탑다운 형식으로 dp를 두번 돌렸다. 천사 먼저 시작하는 경우와 악마 시작하는 경우 나눈다음 결과를 합산해서 출력하면 정답이 된다
 * 4. dp는 3차원 배열을 사용했다 부분 문자열 길이와 천사/악마 문자열 길이 (둘이 길이가 똑같음) 천사와 악마 유형 두가지를 각 인덱스의 범위로 지정했다
 * 5. 방문배열을 똑같이 만들어서 탑다운을 대비했다
 * 6. dfs의 파라미터는 3가지다. 하나는 부분 문자열의 포지션을 담당할 파라미터와 각 천사/악마 문자열 위치를 담당할 파라미터, 천사인지 악마인지 나타낼 유형 그리고 천사/악마 문자열 길이 파라미터다
 * 7. 방문한 경우 그냥 해당 위치의 dp값을 리턴하며 이후 방문체크한다
 * 8. 타입에 따라 나눠서 탐색한다. 현재 천사/악마 문자열 위치부터 길이까지 탐색하며 현재 위치에 합산한다. dfs는 depth+1, pos+1, 현재와 다른 유형, len을 인수로 넘긴다
 * 9. 그전에 실행시킬 조건을 하나 설정해야한다. 현재 depth의 sub 문자랑 현재 i 위치의 (pos로 시작함) 천사 혹은 악마 문자랑 같으면 재귀식을 실행해서 더해준다
 * 10. 이후 완성한 dp를 리턴한다
 * 12. 앞서 말한 것처럼 두가지 경우를 리턴받아 합산한 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(|SUB|*|angel|)
 * 공간복잡도: O(|SUB|*|angel|)
 *
 */



public class Main {

    static int[][][] dp;
    static boolean[][][] visited;
    static String sub;
    static String angel;
    static String evil;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sub = br.readLine();
        angel = br.readLine();
        evil = br.readLine();

        int ans = 0;
        dp = new int[sub.length()+1][angel.length()+1][2];
        visited = new boolean[sub.length()+1][angel.length()+1][2];
        int angelFirst = dfs(0,0,0, angel.length());
        int evilFirst = dfs(0,0,1, evil.length());
        ans = angelFirst + evilFirst;

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int dfs(int depth, int pos, int type, int len) {
        if(depth == sub.length()){
            return 1;
        }
        if(visited[depth][pos][type]){
            return dp[depth][pos][type];
        }

        visited[depth][pos][type] = true;

        if(type == 0){
            for (int i = pos; i < len; i++) {
                if(sub.charAt(depth) == angel.charAt(i)){
                    dp[depth][pos][type] += dfs(depth+1, i+1, 1, len);
                }
            }
        }else{
            for (int i = pos; i < len; i++) {
                if(sub.charAt(depth) == evil.charAt(i)){
                    dp[depth][pos][type] += dfs(depth+1, i+1, 0, len);
                }
            }
        }
        return dp[depth][pos][type];
    }

}
