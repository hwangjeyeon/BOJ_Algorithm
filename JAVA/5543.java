import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 처음 3개중 작은값, 다음 2개중 작은 값을 구한뒤 두 값의 합산 - 50을 출력하면 정답이 된다
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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, Integer.parseInt(br.readLine()));
        }

        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            min2 = Math.min(min2, Integer.parseInt(br.readLine()));
        }

        bw.write((min+min2-50)+"");
        

        br.close();
        bw.close();
    }

}
