import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시간,분,초를 초로 변환해준다
 * 2. 이후, 크기에 따라 정답에 값을 다르게 한뒤, 포맷에 맞춰 출력하면 정답이 된다.
 * 3. 앞으로 시간문제는 하나의 단위로 통합한다음 처리하는 방식으로 해결하자
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int now = 0;
        int fight = 0;


        int[] start = new int[3];
        String[] s = br.readLine().split(":");
        start[0] = Integer.parseInt(s[0]);
        start[1] = Integer.parseInt(s[1]);
        start[2] = Integer.parseInt(s[2]);
        now = (start[0] * 3600) + (start[1] * 60) + start[2];

        int[] end = new int[3];
        s = br.readLine().split(":");
        end[0] = Integer.parseInt(s[0]);
        end[1] = Integer.parseInt(s[1]);
        end[2] = Integer.parseInt(s[2]);
        fight = (end[0] * 3600) + (end[1] * 60) + end[2];

        int ans = 0;
        if(now < fight){
            ans = fight - now;
        }else{
            ans = (24 * 3600) - (now - fight);
        }

        bw.write(String.format("%02d:%02d:%02d", ans/3600, (ans/60)%60, ans%60));

        br.close();
        bw.close();
    }


}
