import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 *
 * 해결방법:
 * 1. 두 입력값의 최대크기가 매우 크기 때문에 탐색이 아닌, 수학 규칙으로 해결하는 문제다.
 * 2. 거리를 기준으로 가능한 경우를 생각해보자. 이때 규칙은 맨 마지막에는 무조건 1이 와야 한다
 * 3. 이 규칙을 세워보면 제곱수마다 이전 제곱수에 누르는 횟수가 2만큼 증가하는 것을 알 수 있다
 * 4. 이 규칙을 활용해보면 소숫점을 버린 거리의 루트값과 거리가 같다면 소숫점을 버린 거리의 루트값에 2를 곱하고 -1을 한 값이 누른 횟수가 된다!
 * 5. 이어서 제곱수 사이의 값들을 살펴보면 정확하게 두가지로 분류된다. 절반 이하는 소숫점을 버린 거리의 루트값에 2를 곱한 값이고 반대는 그 값에 1을 더한 값이 된다
 * 6. 이것을 이용해서 만약 거리가 소숫점을 버린 루트값을 제곱한 값에 해당 루트를 더한값보다 작거나 간다면 소숫점을 버린 루트값에 2를 곱하고 아닌 경우 2를 곱한값에 1을 더하면된다
 * 7. 각 경우마다 출력하면 테스트케이스마다 출력될 것이고 이것은 정답이 된다!
 *
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y - x;
            int ans = (int) Math.sqrt(distance);
            if(Math.sqrt(distance) == ans){
                bw.write(2*ans-1+"\n");
            }else if(distance <= ans*ans + ans){
                bw.write(2*ans+"\n");
            }else{
                bw.write(2*ans+1+"\n");
            }

        }

        br.close();
        bw.close();
    }

}
