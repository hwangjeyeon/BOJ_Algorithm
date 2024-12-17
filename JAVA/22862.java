import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. n의 제한때문에 완탐으로 해결할 수 없다. 따라서 솔루션으로 투포인터를 활용하여 해결하면 된다
 * 2. 투포인터를 첫번째 위치에 두고 시작한다
 * 3. 먼저 입력값들을 짝수인지 홀수인지 구분해서 배열에 기록한다
 * 4. 투포인터 탐색은 r이 n보다 작은동안 반복한다
 * 5. 먼저 홀수를 제거할 수 있으면 현재 수가 홀수인지 파악한다. r의 위치가 홀수라면 count를 증가시켜준다.
 * 6. 이후 홀수짝수 구분없이 r을 증가시키고, ans를 더 큰값으로 갱신한다
 * 7. 만약 홀수를 제거할 수 없는데 r의 위치가 짝수면 r을 증가시키기만 하고 ans를 최댓값으로 갱신한다
 * 8. 만약 홀수를 제거할 수 없는데 l의 위치가 홀수면 l을 증가시키고, count를 갑소한다.
 * 9. 갱신할 때는 r-l의 길이로 판별하며, 연속한 부분수열이므로 제거한 count만큼을 추가로 빼준다
 * 10. 완성한 ans를 출력하면 정답이 된다
 *
 * - 문제 해결:
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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a%2;
        }

        int l = 0;
        int r = 0;
        int ans = 0;
        int count = 0;
        while(r < n){
            if(count < k){
                if(arr[r]==1){
                    count++;
                }
                r++;
                ans = Math.max(ans, r-l-count);
            }else if(arr[r] == 0){
                r++;
                ans = Math.max(ans, r-l-count);
            }else if (arr[r] == 1){
                if(arr[l]==1){
                    count--;
                }
                l++;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
