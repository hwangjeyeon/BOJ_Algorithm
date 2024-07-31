import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 비트마스킹 연습 문제
 * 2. 입력수 n을 2의 보수로 취하는 방법은 ~n + 1이다
 * 3. n과 2의 보수의 다른 비트 개수를 구하라 했으니 xor한 다음 Integer.bitCount를 사용하여 출력하면 정답이 된다.
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
        int m = ~n + 1;
        int xor = n^m;


        bw.write(Integer.bitCount(xor)+"");

        br.close();
        bw.close();
    }

}

