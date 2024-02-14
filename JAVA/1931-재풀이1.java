import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

class Time{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }

        Arrays.sort(times,
                (o1,o2)-> o1.end==o2.end
                        ? o1.start - o2.start : o1.end - o2.end);
        long count = 0;
        long pivot = times[0].end;
        for (int i = 1; i < n; i++) {
//            System.out.println("times.start = " + times[i].start);
//            System.out.println("times.end = " + times[i].end);
            if(times[i].start >= pivot){
                pivot = times[i].end;
                count++;
            }
        }



        bw.write(String.valueOf(count+1));
        br.close();
        bw.close();
    }

}

