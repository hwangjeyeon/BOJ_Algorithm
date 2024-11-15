import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 범위가 너무 크고, 탐색 한번만 해야하기 떄문에 이분탐색으로 문제를 해결하였다
 * 2. 주의할점은 이 문제는 long타입을 사용해야한다. 입력값 제외하고는 모두 long타입으로 하자
 * 3. 양끝은 left는 최소가 되는 1이고, right는 입력값의 최댓값으로 해준다. 중간값으로 자를 때 파의 길이보다 크면 안되기 떄문이다
 * 4. 중간값으로 잘랐을 때, 가능한 파의 개수를 세어준다음 범위를 좁혀가며 찾는다
 * 5. 만약 c보다 작다면 너무 크게 자른 것이므로 right 범위를 좁히고 크거나 같다면 정답은 맞지만 최적의 답을 찾기 위해 left를 늘린다음 fa와 mid를 비교해서 최댓값으로 갱신한다
 * 6. 이후 모든 입력값들의 합을 구한다음 fa와 c를 곱한 값의 차를 합산 변수에다가 넣는다
 * 7. 완성한 변수를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(s * logL)
 * 공간복잡도: O(s)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[s];
        long left = 1;
        long right = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        long fa = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < s; i++) {
                count += arr[i] / mid;
            }

            if(count < c){
                right = mid - 1;
            }else{
                left = mid + 1;
                fa = Math.max(fa, mid);
            }

        }
        long ans = 0;
        for (int i = 0; i < s; i++) {
            ans += arr[i];
        }
        ans -= fa*c;

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
