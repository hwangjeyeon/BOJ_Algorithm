import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 미리 배열로 달별 일수, 요일명을 선언해두고 각 달수만큼의 일을 추가한 뒤 y-1일수를 추가하고나서 7의 나머지를 days에 넣어준다
 * - days를 index로 하는 date의 값이 정답이다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] date = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int days = 0;
        for (int i = 0; i < x; i++) {
            days += month[i];
        }
        days += y-1;
        days %= 7;

        bw.write(date[days]);

        br.close();
        bw.close();
    }

}

