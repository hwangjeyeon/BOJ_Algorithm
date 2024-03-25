import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값-1 부터 1까지 순회하는데, 현재 i를 문자열로 받고 각 문자열 자릿수를 숫자로 바꾼뒤 임시 변수에 저장한다
 * 2. i + 임시변수 저장값이 n과 같다면 ans에 값을 넣는다. 순회종료까지 반복하는데, 만약 없다면 0으로 출력이 될거고 아니면 가장 작은 값이 출력될 것이다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n*n.length())
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = n-1; i >= 1; i--) {
            String input = String.valueOf(i);
            int tmp = 0;
            for (int j = 0; j < input.length(); j++) {
                tmp += Integer.parseInt(String.valueOf(input.charAt(j)));
            }
            if(tmp + Integer.parseInt(input) == n){
                ans = Integer.parseInt(input);
            }
        }
        bw.write(ans + "");
        br.close();
        bw.close();
    }

}

