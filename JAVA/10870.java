import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 재귀함수로 피보나치 수를 구현하여 출력하는 문제다.
 * - 종료조건: 0보다 작거나 같은 경우 0을 리턴하고 1인 경우 1을 리턴한다
 * - 파라미터: 현재 주어진 수
 * - 재귀함수: fibonacci(n-1) + fibonacci(n-2);
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

        bw.write(fibonacci(n)+"");

        br.close();
        bw.close();
    }

    static long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

}
