import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 가장 작은 차이를 구하기 위해서 먼저 오름차순 정렬을 한다
 * 2. 완탐으로 해결할 수 없으면서, 두 수를 고른다고 했기 때문에 투포인터로 해결하였다
 * 3. 투포인터를 처음에는 양 끝점에 두려고 했으나, 명확한 증감근거를 찾지 못했다
 * 4. 따라서 투포인터를 모두 첫지점에 두고, 비교해서 만약 m 이상이면, r을 늘리고 아닐 경우 l을 늘린다
 * 5. m이상인 경우만 ans와 비교해서 최솟값으로 갱신하며, 순회는 두 포인터 모두 n보다 작을때까지 진행한다
 * 6. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
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
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        while(r < n && l < n){
            int diff = Math.abs(arr[l] - arr[r]);
            if(diff >= m){
                ans = Math.min(ans, diff);
                r++;
            }else{
                l++;
            }
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
