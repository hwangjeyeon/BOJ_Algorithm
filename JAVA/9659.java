import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단하게 해결 가능하다. 상근이가 1개 또는 3개 가져갈 수 있으면 홀수일때는 상근이가 무조건 이기고 짝수일 때는 창영이가 무조건 이긴다
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
        long n = Long.parseLong(br.readLine());
        bw.write(n%2 == 1 ? "SK" : "CY");
        
        br.close();
        bw.close();
    }

}
