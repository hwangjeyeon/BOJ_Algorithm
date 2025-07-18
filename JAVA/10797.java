import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n과 일치하는 값 찾아서 개수 세어주고 출력하면 정답이 된다
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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a == n){
                ans++;
            }
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }

}
