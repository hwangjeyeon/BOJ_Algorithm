import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. S의 범위때문에 이분탐색하는 문제인데... 기준을 잡기가 쉽지 않다.
 * 2. 이 문제에서 기준을 잡을 대상은 각 사람의 L과 R의 범위이다
 * 3. 그 범위를 찾기 위해서는 추가적인 작업이 필요하다. 먼저 최대치에 대해서 중간값을 잡고, N만큼 순회를 돌면서 범위 수정에 대한 확인을 한다
 * 4. 추가적인 l과 r을 두고 순회를 하면서 l에는 그 지점의 최소량을 더해주고, r에는 mid와 최대량을 비교하여 더 작은 값을 더해준다
 * 5. 만약 도중에 mid가 그 사람의 최소량보다 작으면 무조건 늘려줘야 하므로 이후 작업 진행 없이 늘려주는 것을 판단한다
 * 6. 이어서 l과 r을 가지고 t와 비교하여 그 범위안에 t가 있으면 정답임을 확인하고, 정답과 mid를 비교하여 더 작은 값으로 갱신한다. 이어서 최적을 찾기 위해 right를 조절한다
 * 7. 만약 l이 t보다 크다면 right의 범위를 조절하고, 그 외에는 left의 범위를 조절한다
 * 8. 이렇게 탐색한 후에 만약 ans가 그대로 최대치라면 -1로 바꿔준다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*log(l~r))
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 1_000_001;
        while(left <= right){
            int mid = (left + right) / 2;
            int isChk = 0;
            int l = 0;
            int r = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i][0] > mid){
                    isChk = 1;
                    left = mid +1;
                    break;
                }
                l += arr[i][0];
                r += Math.min(mid, arr[i][1]);
            }
            if(isChk == 1){
                continue;
            }

            if(l <= t && t <= r){
                right = mid -1;
                ans = Math.min(ans, mid);
            }else if(l > t){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }

        bw.write(ans+"");



        br.close();
        bw.close();
    }

}
