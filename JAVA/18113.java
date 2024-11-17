import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 각 원소를 비교하며 주어진 조건에 맞게 꼬다리를 제거해준다. 폐기하는 김밥은 0으로 처리한다
 * 2. 이후 m개의 개수를 구하기 위해 설정해야할 P를 이분탐색한다
 * 3. right는 가장 큰 숫자이며, mid값이 p를 의미한다. 
 * 4. n개를 비교하며 0인 경우는 건너뛰고, 그외에는 배열의 값을 mid로 나눈 몫을 합산한다. 나머지값은 p 크기가 아니기때문에 제외한다
 * 5. count가 m보다 작으면 정답에 해당되지 않으므로 right 범위만 축소하며, 반대는 mid와 비교하여 ans에 넣고 최적의 값을 찾기 위해 left 범위를 변경한다
 * 6. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(nlogP)
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
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] >= 2*k){
                arr[i] -= 2*k;
            }else if(arr[i] > k){
                arr[i] -= k;
            }else{
                arr[i] = 0;
            }
            right = Math.max(right, arr[i]);
        }

        long ans = -1;
        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == 0){
                    continue;
                }
                count += arr[i]/mid;
            }

            if(count < m){
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
