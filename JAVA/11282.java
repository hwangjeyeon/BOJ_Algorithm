import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 44031만큼 더한다음 char형으로 변환해서 출력하면 정답이 된다
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
        int n = Integer.parseInt(br.readLine()) + 44031;
        char c = (char) n;
        bw.write(c+"");
        
        br.close();
        bw.close();
    }

}
