import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 먼저 n^2으로 모든 경우의 수를 구한 뒤, 탐색하는 방법은 시간제한때문에 해결할 수 없다
 * 2. 따라서 다른 방법을 선택해야한다. 이 문제의 해결 포인트는 주어진 경우의 수를 2차원 배열로 그리는 것이다
 * 3. 그리고 2차원 배열에서 규칙을 찾아내면된다. 특정 수를 지정했을 때, 그 수보다 작은 경우가 그 열에서 몇개 있는지 찾는다
 * 4. 그리고 그 합산을 모두 더하고 나서, 2차원 배열을 오름차순 정렬한 1차원 배열로 정렬했을 때의 위치를 합산으로 한다면 정확하게 특정수와 일치한다
 * 5. 이것을 활용하면 이분탐색으로 문제를 해결할 수 있다
 * 6. 0부터 k까지를 범위로 지정한 다음 이분탐색을 진행한다. 그리고 1번째 열부터 n번째 행까지 탐색하며, mid를 i로 나눈 몫과 n을 비교해서(몫이 n보다 커질 수 있는데, 2차원 배열 특성 상 n보다 값이 커질수는 없기 때문) 합산에 더한다
 * 7. 그리고 합산과 k를 비교한다. 만약 작다면 정답으로 채택할 수 없다. 특정 수가 너무 작아서, k의 위치보다 이전에 있기 때문이다. 따라서 left를 조절한다
 * 8. 만약 크거나 같다면 right를 조절하고 mid를 정답으로 한다. 클 때도 정답으로 채택할 수 있는데, 아무리 커도 k보다 작을 텐데, 가능한 개수가 k보다 많다는 것은 정답위치의 해당하는 값이 동일한 값으로 여러개 있다는 것이 된다
 * 9. 따라서 8번의 경우 ans를 mid로 초기화하며, 완성된 ans를 출력하면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(n * log n)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int ans = 0;
        int left = 0;
        int right = k;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 1; i < n+1; i++) {
                count += Math.min(mid/i, n);
            }

            if(count < k){
                left = mid + 1;
            }else{
                right = mid - 1;
                ans = mid;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
