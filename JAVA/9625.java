import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 규칙을 발견해서 어떻게 누적해나갈 수 있을지 찾으면 된다. dpA와 dpB로 나누어서 계산하였고, dpA는 dpB의 이전 값에의해서만 수가 늘어나고 dpB는 dpA와 dpB의 이전 값의 수를 더한 만큼 늘어난다
 * 2. 따라서 dpA[i] = dpB[i-1], dpB[i] = dpA[i-1] + dpB[i-1]이라는 점화식이 도출된다.
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(k)
 * 공간복잡도: O(k)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int[] dpA = new int[k+1];
        int[] dpB = new int[k+1];

        dpA[1] = 0;
        dpB[1] = 1;
        for (int i = 2; i <= k; i++) {
            dpA[i] = dpB[i-1];
            dpB[i] = dpA[i-1] + dpB[i-1];
        }

        bw.write(dpA[k] + " " + dpB[k]);

        br.close();
        bw.close();
    }



}

