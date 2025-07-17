import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 각각 합산한 다음 더 큰값을 출력한다
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
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 4; i++) {
            sum1 += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sum2 += Integer.parseInt(st.nextToken());
        }

        if(sum1 >= sum2){
            bw.write(sum1+"");
        }else{
            bw.write(sum2+"");
        }

        br.close();
        bw.close();
    }

}
