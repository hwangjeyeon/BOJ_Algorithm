import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Set을 활용하면 쉽게 풀 수 있다
 * 2. 자기자신을 뒤집었을 때 같거나 set에 뒤집은 값이 포함되면 정답으로 보면 된다. 단 홀수길이여야한다
 *
 * 해결방법:
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

        Set<String> set = new HashSet();
        String ans = "";
        int num = 0;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            StringBuilder sb = new StringBuilder(s);
            String rev = sb.reverse().toString();
            if(s.length() % 2 == 1 && (rev.equals(s) || (set.contains(rev)))){
                num = s.length();
                ans = String.valueOf(s.charAt(num/2));
                break;
            }
            set.add(s);
        }

        bw.write(num + " " + ans);

        br.close();
        bw.close();
    }
}
