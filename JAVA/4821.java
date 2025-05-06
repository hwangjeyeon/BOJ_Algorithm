import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. split및 파싱과 계수배열을 적절히 활용하면 문제를 쉽게 해결할 수 있다
 * 2. 한자리일 때와 n을 벗어나는 경우, 그리고 l>h인 경우만 예외로 처리하고 정답으로 체크하면 된다
 * 3. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n * (|h-l|))
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            int[] count = new int[n+1];
            String[] arr = br.readLine().split(",");
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                String[] num = arr[i].split("-");
                if(num.length == 1){
                    int l = Integer.parseInt(num[0]);
                    if(l <= n && count[l] == 0){
                        count[l]++;
                        ans++;
                    }
                    continue;
                }
                int l = Integer.parseInt(num[0]);
                int h = Integer.parseInt(num[1]);
                if(l > h){
                    continue;
                }
                for (int j = l; j<=n && j <= h; j++) {
                    if(count[j] == 0){
                        count[j]++;
                        ans++;
                    }
                }
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}
