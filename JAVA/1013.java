import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 정규 표현식 문제다.
 * 2. 그냥 주어진 정규 표현식이랑 주어진 문자열이랑 일치하는지 체크하고 true면 YES 아니면 NO를 출력하면 정답이 된다
 * 3. 두가지 방법이 있다 Pattern.matches(정규표현식, 문자열)을 사용하거나 문자열.matches(정규표현식)을 사용하면 쉽게 해결된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            if(s.matches("(100+1+|01)+")) {
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }


        br.close();
        bw.close();
    }

}

