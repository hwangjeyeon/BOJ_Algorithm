import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 먼저 버튼 배열을 만들어서 간소화 하였다.
 * - 이어서 망가진 버튼은 -1로 처리하였다.
 * - 일단 현재 위치가 100이므로 100일 경우는 바로 0을 출력하자
 * - 이제 다음부터는 문제를 풀어나가야하는데... N의 최대수를 보았을 때, 나올 수 있는 버튼의 수는 0부터 999999까지이다.
 * - 시간제한은 2초이므로 브루트포스로 충분히 해결할 수 있는 문제이다.
 * - 따라서 0부터 999999까지 완전탐색해서 답을 구하면 된다.
 * - 이때 만약 해당 수의 자릿수들의 숫자가 망가진 버튼의 숫자이면 비교를 하지 않고 건너뛰게 처리한다
 * - 만약 만들 수 있다면 일단 해당 수의 길이가 버튼을 누른 횟수이고, 이어서 그 숫자가 n까지의 거리가 얼마인지는 + 또는 - 버튼을 누르는 횟수이다
 * - 이제 최소 몇번을 눌러야 하므로 계속해서 비교해줄 순회문 밖에 선언해둔 result 값과 비교해서 더 작은 값을 넣어준다
 * - result는 n-100이 최대이므로 그 수로 초기화해준다
 * - 이렇게 나온 result를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int now = 100;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] button = {0,1,2,3,4,5,6,7,8,9};
        int[] broken = new int[m];
        if(m != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[i] = Integer.parseInt(st.nextToken());
            }
        }


        // 버튼 배열에서 broken 버튼을 -1로 변경 -> 앞으로 -1이면 사용 못함을 의미
        for (int i = 0; i < m; i++) {
            button[broken[i]] = -1;
        }

        if(n == 100){
            bw.write("0");
        }else{
            int target = Math.abs(n - now);
            for(int i=0; i<=999999; i++){
                String tmp = String.valueOf(i);

                boolean isOk = true;
                for (int j = 0; j < tmp.length(); j++) {
                    if (button[tmp.charAt(j) - 48] == -1) {
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    int count = Math.abs(n-i) + tmp.length();
                    target = Math.min(count, target);
                }
            }
            bw.write(target+"");
        }


        br.close();
        bw.close();
    }

}

