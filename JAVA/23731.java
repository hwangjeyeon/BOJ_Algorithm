import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Set에 문장 다 넣고 돌리면서 검증하면 된다.
 * 2. 없는 경우 Yes고 있는 경우 No다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        set.add("Never gonna give you up");
        set.add("Never gonna let you down");
        set.add("Never gonna run around and desert you");
        set.add("Never gonna make you cry");
        set.add("Never gonna say goodbye");
        set.add("Never gonna tell a lie and hurt you");
        set.add("Never gonna stop");
        int n = Integer.parseInt(br.readLine());
        String ans = "No";
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(!set.contains(s)){
                ans = "Yes";
            }
        }
        bw.write(ans);

        br.close();
        bw.close();
    }
}
