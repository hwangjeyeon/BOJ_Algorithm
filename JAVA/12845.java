

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 가장 큰 값을 찾는다.
 * 2. 배열을 순회해서 그 값과 현재 배열의 위치의 값을 합하여 gold에 더해준다
 * 3. 순회후, 자기자신을 더한 경우를 예외처리하기 위해 max*2의 값을 빼주고 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int gold = 0;
        for (int i = 0; i < n; i++) {
            gold += max + arr[i];
        }

        gold -= (2*max);


        bw.write(gold+"");


        br.close();
        bw.close();
    }
}

