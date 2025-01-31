import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시뮬레이션 하면 5개 단위로 승패승승패가 나오는 것을 알 수 있다
 * 2. 따라서 모듈러 연산으로 입력결과를 받고 1,3,4인 경우 SK를 출력하고 반대는 CY를 출력하면 정답이 된다.
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
        long n = Long.parseLong(br.readLine()) % 5;
        if (n == 1 || n == 3 || n == 4) {
            bw.write("SK");
        }else{
            bw.write("CY");
        }

        br.close();
        bw.close();
    }
}
