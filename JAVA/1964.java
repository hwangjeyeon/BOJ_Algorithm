import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 오각형을 그릴 수록 7개에서 3개씩 추가되면서 늘어난다는 점을 생각하고 계산해서 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long d = 7;
        long sum = 5;

        for (int i = 1; i < n; i++) {
            sum += d;
            d += 3;
        }
        bw.write((sum % 45678)+"");
        
        br.close();
        bw.close();
    }
}
