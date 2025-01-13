import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이분탐색과 일부 구현을 통해 해결하는 문제다
 * 2. 먼저 n 입력값부터 long타입으로 지정해야하낟. 20^9이기 때문이다
 * 3. 이어서 n이 m이하면 그대로 n을 출력하면 정답이 된다
 * 4. 하지만 초과하는 경우 이제 본격적인 로직을 구현해야 한다
 * 5. 먼저 이분탐색의 대상은 시간이다. 해당 시간에 각 놀이기구별로 몇명이나 태울 수 있는지 확인한다
 * 6. l은 1으로 최소시간, r은 n*30으로 최대시간으로 정한다.
 * 7. 이분탐색으로 mid시간으로 태울 수 있는 놀이기구의 개수를 구한다. 이때 0초에 모든 놀이기구를 태울 수 있으므로 count는 m으로 초기화한다
 * 8. count가 n보다 작다면 left를 조절하고 반대의 경우 right를 조절한다. 그리고 이때는 해당 시간에 최소한 n명 이상을 태울 수 있다는 것이므로 nCount를 mid로 초기화한다
 * 9. 이제 완성한 nCount를 가지고 출력하면 될것처럼 보이는데... 이 문제는 마지막에 타는 사람이 몇번째 놀이기구에 타는지를 출력하는 문제다
 * 10. 따라서 이분탐색으로 정해진 시간 1분 전의 시간으로 각 놀이기구를 몇명 태울 수 있는지 구하고, 정답을 찾아가야한다
 * 11. 먼저 10번을 통해 구한 인원 수를 ans로 지정한다
 * 12. 이어서 m개의 놀이기구를 탐색하면서 n의 시간이 되었을 때, 탈 수 있는지를 확인한다. 모듈러 연산을 했을 때, 0이되면 탈 수 있다
 * 13. 만약 탈 수 있다면 ans의 값을 늘려준다. 이어서 만약 ans가 n에 도달했다면 현재 순서가 마지막 아이를 의미하므로 0번째 부터 시작하는 i+1을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(m)
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n <= m){
            bw.write(n+"");
        }else{
            long left = 1;
            long right = n*30;
            long nCount = left;
            while(left <= right){
                long mid = (left + right) / 2;
                long count = m;
                for (int i = 0; i < m; i++) {
                    count += mid / arr[i];
                }
                if(count < n){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                    nCount = mid;
                }
            }

            long nMCount = nCount-1;
            long count = m;
            for (int i = 0; i < m; i++) {
                count += nMCount / arr[i];
            }
            long ans = count;

            for (int i = 0; i < m; i++) {
                if(nCount % arr[i] == 0){
                    ans++;
                }
                if(ans == n){
                    bw.write(i+1+"");
                    break;
                }
            }
        }

        br.close();
        bw.close();
    }

}
