import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 완탐 돌리면 되는 문제다. 1부터 n까지 순회하면서 먼저 문자열로 파싱한다
 * 2. 이후 문자열 길이만큼 순회하면서, num과 같은 숫자가 있는경우 ans를 증가시킨다
 * 3. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if(Character.getNumericValue(s.charAt(j)) == num){
                    ans++;
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

