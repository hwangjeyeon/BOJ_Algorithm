import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. X와 Y중 큰 수와 작은 수를 각각 구해서 더한 후에, 작은 수를 10으로 나눠준 몫을 추가로 더해준다
 * 2. 그리고 입력값의 크기 때문에 long 타입으로 지정해주어야 한다.
 *
 *
 * - 문제 해결:
 *
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
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int big = Math.max(x, y);
        int small = Math.min(x,y);
        long ans = big + small + (small / 10);
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

