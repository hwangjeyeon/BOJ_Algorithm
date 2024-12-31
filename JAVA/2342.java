import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 현재 발의 위치는 left와 right 투포인터로 관리
 * 2. 0~4번 지점에 대해 합산을 이동 횟수만큼 더하자
 * 3. 남은 것은 구현이다. 어떻게 구현할 것인가?
 * 4. A=B면 무조건 1, A=0이면 무조건 2,
 * 5. 1 /2,4는 3 // 3은 4
 * 6. 2 /1,3은 3 // 4는 4
 * 7. 3 /2,4는 3 // 1은 4
 * 8. 4 /1,3은 3 // 2는 4
 *
 * 해결방법:
 * 1. 위 방법의 2번은 그리디 방법이다. 이 문제는 DP, 그중 TOP-DOWN으로 해결해야한다
 * 2. 3차원 DP를 이용한다. 순서, left위치, right위치를 담을 것이다
 * 3. 만약 idx가 list크기와 같다면 0을 리턴한다
 * 4. 만약 현재 순서의 왼발 오른발 위치에 해당하는 dp의 값이 0이 아니라면 이미 방문한 것이므로 그 값을 그대로 리턴한다
 * 5. 이어서 top-down으로 해결하기 위해 재귀문을 작성한다.
 * 6. 그전에 먼저 list에서 현재 순서에 해당하는 값을 꺼낸다
 * 7. dp의 현재 순서와 위치에 해당하는 배열에 재귀식의 두 값중 더 작은 값을 넣어준다
 * 8. 리스트에서 꺼낸 다음 위치를 한쪽은 left에 넣고 한쪽을 right에 넣는다.
 * 9. 또한 각각에 앞서 구현한 ddr 메소드를 이용해서 이동에 필요한 값을 리턴받아 각각 더한다
 * 10. 이렇게 재귀식을 이용해 완성한 현재 순서의 최종 dp값을 리턴한다
 * 11. 이 값을 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(수열의 길이)
 * 공간복잡도: O(수열의 길이)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> lists = new ArrayList<>();
        while(true){
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                break;
            }
            lists.add(a);
        }
        int[][][] dp = new int[lists.size()][5][5];


        int ans = solve(0, 0, 0, lists, dp);


        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int solve(int left, int right, int idx, List<Integer> lists, int[][][] dp) {
        if (idx == lists.size()){
            return 0;
        }

        if(dp[idx][left][right] != 0){
            return dp[idx][left][right];
        }
        int nxt = lists.get(idx);

        dp[idx][left][right] = Math.min(solve(nxt, right, idx+1, lists, dp)
                + ddr(left, nxt), solve(left, nxt, idx+1, lists, dp) + ddr(right, nxt));
        return dp[idx][left][right];
    }

    private static int ddr(int dir, int nxt) {
        if(dir == nxt){
            return 1;
        }
        if(dir == 0){
            return 2;
        }
        if(dir == 1){
            if(nxt == 3){
                return 4;
            }else{
                return 3;
            }
        }else if(dir == 2){
            if(nxt == 4){
                return 4;
            }else{
                return 3;
            }
        }else if(dir == 3){
            if(nxt == 1){
                return 4;
            }else{
                return 3;
            }
        }else if(dir == 4){
            if(nxt == 2){
                return 4;
            }else{
                return 3;
            }
        }

        return 0;
    }

}
