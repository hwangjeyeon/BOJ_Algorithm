import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. double 변수로 받은 결과를 BigDecimal을 이용하여 정확한 고정소수점 연산을 진행한다
 * 2. 문제에서 주어진대로 n자리 수까지 소수점을 표기하고 RoundingMode.HALF_UP을 통해 반올림을 진행한다
 * 3. 완성한 결과를 그대로 출력하기 위해 toPlainString을 사용하여 출력한다.
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

        int n = Integer.parseInt(br.readLine());
        double ans = Math.pow(0.5, n);
        BigDecimal bigDecimal = new BigDecimal(ans);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.HALF_UP);

        bw.write(bigDecimal.toPlainString());
        br.close();
        bw.close();
    }
}

