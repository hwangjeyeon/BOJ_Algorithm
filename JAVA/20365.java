

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음부터 끝까지 각 색깔의 수를 세어준다.
 * 2. 1번 떄문에 count=1로 설정하고 다른 색깔의 개수를 세어준다. 이때 만약 옆에 붙어 있는 경우도 있을 수 있으므로, 만약 옆이 같은 색이면 count를 세지 않는다.
 * 3. 위 방법은 틀렸다
 *
 * 1. 최적의 경우는 묶여있는 색깔의 수가 가장 많은 것을 먼저 쭉 칠하고 그 다음에 적은 숫자를 더하면 된다.
 * 2. 출력전에 더 많은 색은 쭉 전부 그 색으로 칠하므로 적은 색깔의 개수 + 1을 해서 정답을 출력해준다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int blue = 0;
        int red = 0;
        char last;
        if(s.charAt(0) == 'B'){
            blue++;
            last = 'B';
        }else{
            red++;
            last = 'R';
        }

        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == 'R' && last == 'B'){
                red++;
                last = 'R';
            }else if(s.charAt(i) == 'B' && last == 'R'){
                blue++;
                last = 'B';
            }
        }

        int count = Math.min(red, blue);


        bw.write(count+1+"");

        br.close();
        bw.close();
    }
}

