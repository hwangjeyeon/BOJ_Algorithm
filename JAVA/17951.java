import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이분탐색으로 해결하면 되는 쉬운 문제다
 * 2. 이분탐색의 범위는 n의 전체 범위다. 이때 최대로 가능한 2_000_000을 right로 하고, left는 0으로 한다
 * 3. 그룹별 합산과 그룹의 개수를 셀 것이다 n만큼 순회하며 합산을 하고, 만약 합산이 mid 이상이면 ans를 0으로 초기화하고 count를 증가시킨다
 * 4. 이후 k가 count보다 작거나 같으면 left의 범위를 조절하고 반대면 right의 범위를 조절한다 
 * 5. 완성한 right를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*logn)
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
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 2_000_000;
        while(left <= right){
            int mid = (left + right) / 2;
            int ans = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                ans += arr[i];
                if(mid <= ans){
                    ans = 0;
                    count++;
                }
            }

            if(k <= count){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        bw.write(right+"");

        br.close();
        bw.close();
    }

}
