import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 주어진 문제를 확인했을때, 입력받은 값을 제곱인수로 하는 2의 n제곱이 정답이다.
 * - 따라서 2^n을 출력하면 정답이 된다
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
        int n  = Integer.parseInt(br.readLine());

        bw.write((int)Math.pow(2,n) + "");


        br.close();
        bw.close();
    }

}
