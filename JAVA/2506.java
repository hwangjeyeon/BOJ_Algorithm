import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. count를 사용해서 연속된 수를 체크하는 방식으로 구현하면 된다
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
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 1){
                ans += ++count;
            }else{
                count = 0;
            }
        }

        bw.write(ans+"");
        

        br.close();
        bw.close();
    }

}
