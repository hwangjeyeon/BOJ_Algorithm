

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 크기가 매우 크게 나올 것이기 떄문에 long 타입으로 정답 변수를 관리한다
 *
 * - 문제 해결:
 * 1. stone의 개수와 현재 arr[i]의 값을 곱해서 ans에 더해준다
 * 2. 만약 k보다 작으면 arr[i]*stone해서 더해주고, stone개수를 늘려주고 같거나 큰 경우 그냥 arr[i]*stone을 해서 더해준다
 * 3. 완성한 ans를 출력하면 정답이 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long ans = 0;
        int stone = 1;
        for (int i = 1; i < n; i++) {
            if(stone < k){
                ans += (long) arr[i] * stone;
                stone++;
            }else{
                ans += (long) arr[i] * stone;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

