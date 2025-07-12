import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 크기 비교 후, 카운팅한 다음 그 결과를 출력하면 정답이 된다
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

        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b){
                one++;
            }else if(a < b){
                two++;
            }
        }
        bw.write(one + " " + two);

        br.close();
        bw.close();
    }

}
