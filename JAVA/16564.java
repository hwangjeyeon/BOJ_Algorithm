import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 이분탐색으로 해결하고 long 타입을 선택한다
 * 2. left는 오름차순 정렬된 값의 맨 처음을 선택하고 right는 Integer.MAX_VALUE로 선언해야지 정답을 출력할 수 있다
 * 3. 만약 현재 값이 mid값보다 작으면 sum에다가 mid - arr[i]값을 더해준다.
 * 4. sum이 k보다 작거나 같으면 ans에 mid를 넣고 left를 재설정한다
 * 5. 반대는 right를 재설정한다
 * 6. ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(nlogn)
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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long ans = 0;
        long left = arr[0];
        long right = Integer.MAX_VALUE;
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] < mid){
                    sum += (mid - arr[i]);
                }
            }

            if(sum <= k){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

