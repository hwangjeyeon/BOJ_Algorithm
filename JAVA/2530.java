import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시간관련 사칙연산으로 풀 수 있는 문제 
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        second += time;
        minute += second / 60;
        second %= 60;
        hour += minute / 60;
        minute %= 60;
        hour %= 24;

        bw.write(hour + " " + minute + " " + second);
        
        br.close();
        bw.close();
    }

}
