import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. TreeSet써서 데이터를 보관한다음 이중포문으로 조합해서 출력하면 정답이 된다
 * 
 *
 * 해결방법:
 *
 * 시간복잡도: O(4^4)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new TreeSet<>();
        set.add(st.nextToken());
        set.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());


        for (String s1 : set) {
            for (String s2 : set) {
                bw.write(s1 + " " + s2 + "\n");
            }
        }


        br.close();
        bw.close();
    }
}
