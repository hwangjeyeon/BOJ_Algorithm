import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 처음에는 그리디 문제인줄 알았는데, 문제를 잘 살펴보니 가장 적합한 막걸리의 용량을 구하기 위해서는 이분탐색으로 해결해야하는 문제여 ㅆ다
 * 2. 따라서 이분탐색으로 문제를 푸는데, left는 1로 하고 right는 입력된 막걸리 용량 중 가장 큰값으로 한다
 * 3. 이때 left는 1로 해야하는데, 아니면 divide zero 예외가 발생한다
 * 4. 이어서 모든 타입을 long으로 한다 왜냐하면 mid가 int형 범위를 벗어날 수 있기 때문이다 막걸리의 용량이 2^31-1이 최대가 될 수 있기 때문에 left + mid에서 int형 범위를 벗어난다
 * 5. 이분탐색은 mid로 원소값을 나눴을 때의 몫을 세어준다. 
 * 6. 만약 이것이 k보다 작다면 정답을 만족시키지 못하므로 범위를 줄여서 탐색을 해야한다. 따라서 right의 범위를 조정한다
 * 7. 이어서 k보다 크거나 같다면 정답을 만족시키지만 최적의 범위를 더 찾을 수 있으므로 left의 범위를 조정하고 ans에 더 큰값을 갱신한다
 * 8. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n * log 막걸리 용량)
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
        long left = 1;
        long right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        long ans = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }

            if(count < k){
                right = mid - 1;
            }else{
                left = mid + 1;
                ans = Math.max(ans, mid);
            }

        }
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

}

