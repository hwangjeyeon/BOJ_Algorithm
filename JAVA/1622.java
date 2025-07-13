import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 일단 부분 문자열을 파악하기 위해 각 문자열에 어떤 알파벳의 개수를 얼마나 가지고 있는지 알 필요가 있다
 * 2. 각각의 개수를 세어주자
 * 3. 이후 c1이나 c2를 기준으로 삼고, 현재 알파벳의 개수가 더 작은 것의 개수를 선택한다
 * 4. 왜냐하면 더 작은 수만큼이 부분 문자열이 되는 조건이기 떄문이다
 * 5. 그 만큼 StringBuilder에다가 넣어준다
 * 6. 완료된 이후 StringBuilder에다가 "\n"을 넣어주고 출력하면 정답이 된다
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

        while(true){
            String s1 = br.readLine();
            if(s1 == null){
                break;
            }
            String s2 = br.readLine();
            int[] c1 = new int[26];
            int[] c2 = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                c1[s1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s2.length(); i++) {
                c2[s2.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c1.length; i++) {
                int min = Math.min(c1[i], c2[i]);
                for (int j = 0; j < min; j++) {
                    sb.append((char)('a' + i));
                }
            }
            sb.append("\n");
            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }

}
