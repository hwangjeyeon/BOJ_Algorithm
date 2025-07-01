import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. HashSet써서 중복인 경우 ans를 증가시키고, 최종 완성한 ans를 출력하면 정답이 된다
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(set.contains(a)){
                ans++;
                continue;
            }
            set.add(a);
        }
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

}
