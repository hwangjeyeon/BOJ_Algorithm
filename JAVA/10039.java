import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 40점 미만에 대한 예외처리만 하고 나머지 합산한뒤 5로 나눈 몫을 출력하면 정답이 된다
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
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a < 40){
                a = 40;
            }
            sum += a;
        }

        bw.write(sum/5+"");
        
        br.close();
        bw.close();
    }

}
