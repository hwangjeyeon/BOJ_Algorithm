import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. HashSet과 endsWith을 활용하면 쉽게 해결할 수 있다
 * 2. endsWith이 "Cheese"인 경우 HashSet에 추가한다
 * 3. 만약 HashSet의 크기가 4이상이면 정답이 되고 아니면 sad를 출력하면 된다
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
        int n = Integer.parseInt(br.readLine());
        String ans = "yummy";
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            if(s.endsWith("Cheese")){
                set.add(s);
            }
        }

        bw.write(set.size() >= 4 ? ans : "sad");

        br.close();
        bw.close();
    }
}
