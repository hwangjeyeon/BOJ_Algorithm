import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 사칙연산 후, 음수에 대해서만 0처리해서 출력하면 정답이 된다
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
        int k = Integer.parseInt(st.nextToken());
        
        int sum = n * m - k;
        bw.write((sum <= 0 ? 0 : sum)+"");
            
        br.close();
        bw.close();
    }

}

