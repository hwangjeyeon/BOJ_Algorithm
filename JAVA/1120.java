import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 *
 * 문제 해결:
 * 1. 긴 문자열을 작은 문자열의 길이 차이 + 1만큼 순회하면서 각 순회마다 다른 개수를 세어서 가장 작은 값을 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String x = st.nextToken();
        String y = st.nextToken();
        int ans = x.length();
        for (int i = 0; i < y.length() - x.length() + 1; i++) {
            int tmp = 0;
            for (int j = 0; j < x.length(); j++) {
                if(x.charAt(j) != y.charAt(j+i)){
                    tmp++;
                }
            }

            ans = Math.min(ans, tmp);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
