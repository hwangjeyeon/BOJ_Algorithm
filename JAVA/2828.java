import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. start와 end를 두고 m만큼 범위를 지정해서 풀었다.
 * 2. now가 start와 end 범위 안에 있으면 continue한다
 * 3. start보다 now가 작으면 그 차이만큼 ans에 더하고 start와 end를 빼준다
 * 4. end보다 now가 크면 그 차이만큼 ans에 더하고 start와 end에 더해준다.
 * 5. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(count)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());
        int start = 1;
        int end = m;
        int ans = 0;
        for (int i = 0; i < count; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now >= start && now <= end){
                continue;
            }

            if(now < start) {
                int diff = start - now;
                ans += diff;
                start -= diff;
                end -= diff;

            }else {
                int diff = now - end;
                ans += diff;
                start += diff;
                end += diff;
            }

        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

