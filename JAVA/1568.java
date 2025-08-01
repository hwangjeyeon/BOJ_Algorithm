import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. k가 1씩 증가하고 n이 k보다 작아지기 전까지는 n은 k만큼 감산한다
 * 2. 감산을 하는 동안 ans를 누적하며 n이 k보다 작다면 다시 k를 1로 초기화하고 다시 n에서 k를 감산한ㄷ
 * 3. n이 0이 될 때까지 반복하며 n이 0이 되면 반복문을 탈출하고 ans를 출력하면 정답이 된다
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
        int k = 1;
        int ans = 0;
        while(n > 0){
            if(n < k){
               k = 1;
            }
            n -= k++;
            ans++;
        }
        bw.write(ans+"");

        
        br.close();
        bw.close();
    }
}
