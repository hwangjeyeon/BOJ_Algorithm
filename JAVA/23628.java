import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 날짜 문제는 보통 가장 작은 단위로 통일하면 된다
 * 2. 여기서는 가장 작은 단위인 날자로 통일하였다
 * 3. 월차는 36이 넘어가면 36으로 고정하고 그 외에는 그냥 계산한만큼 적용한다
 * 4. 총 날짜는 그냥 차이를 출력하면 된다
 * 5. 연차는 조금 계산해야하는데 15는 연차만큼 곱해줘야하고, A는 가변이기 때문에 반복문을 통해 누적해야한다
 * 6. A를 구하는 식은 현재 연차 - (현재연차/2 -1)을 1년차부터 자신이 일한 연차까지 더하면 된다. 이것은 이후에 추가적으로 연차를 곱하면 안된다
 * 7. 완성한 결과를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
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
        int startYear = Integer.parseInt(st.nextToken());
        int startMonth = Integer.parseInt(st.nextToken());
        int startDay = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int endYear = Integer.parseInt(st.nextToken());
        int endMonth = Integer.parseInt(st.nextToken());
        int endDay = Integer.parseInt(st.nextToken());

        int diff = (endYear*12*30 + endMonth*30 + endDay) - (startYear*12*30 + startMonth*30 + startDay);
        int a = 0;
        for (int i = 1; i <= diff / 360; i++) {
            a += i - (i/2 + 1);
        }

        int ansYear = a + (15) * (diff/360);
        int ansMonth = Math.min(diff / 30, 36);

        bw.write(ansYear + " " + ansMonth + "\n");
        bw.write(diff + "days");

        br.close();
        bw.close();
    }
}

