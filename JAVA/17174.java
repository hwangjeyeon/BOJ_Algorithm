import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n개 + 묶음의 개수를 더하는 문제다
 * 2. 한가지만 생각하면 된다 예를 들어 100 / 8 == 12인데, 이것이 여전히 m인 8보다 크다면 다시 묶음의 개수를 세어준다
 * 3. 이를 이용해서 n을 갱신한다면 ans를 만들 수 있고 완성한 ans를 출력하면 정답이 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = n;
        while(n >= m){
            n /= m;
            ans += n;
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
