

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 홀수인 경우와 짝수인 경우를 나누고, 홀수인 경우는 맨 마지막만 따로 처리하고 짝수는 그대로 진행하면 된다
 * 2. 매우 크기 때문에 long타입으로 해서 비교한다
 * 3. 홀수 의 경우 마지막을 ans에 넣고 절반씩 (n-1)/2만큼 탐색하는데, 처음과 마지막-1을 더한 값부터 비교해서 제일 큰 값을 답으로 한다
 * 4. 짝수는 별도 과정 없이 n/2만큼 탐색해서 양끝값을 더한 값중 가장 큰 값을 최소치로 한다
 * 5. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n/2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;
        if(n % 2 == 1){
            ans = arr[n-1];
            for (int i = 0; i < (n-1) / 2; i++) {
                ans = Math.max(ans, arr[i] + arr[n-2-i]);
            }

        }else{
            for (int i = 0; i < n/2; i++) {
                ans = Math.max(ans, arr[i] + arr[n-1-i]);
            }
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }
}

