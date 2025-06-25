import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 초로 단위를 통일한 뒤, 60의 몫과 모듈러연산한 결과를 출력하면 정답이 된다
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
        int time = 0;
        for (int i = 0; i < 4; i++) {
            time += Integer.parseInt(br.readLine());
        }

        bw.write(time/60 + "\n" + time%60);
        
        br.close();
        bw.close();
    }

}
