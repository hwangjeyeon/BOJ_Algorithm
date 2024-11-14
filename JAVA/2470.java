import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이중포문도 힘들고 범위도 넓기 때문에 이분탐색을 하는 문제다
 * 2. 이 문제는 인덱스 범위를 기준으로 이분탐색을 해야한다. 따라서 오름차순 정렬을 해주며 left와 right를 양 끝점으로 잡아준다
 * 3. 이 문제는 특이하게 두 용액을 더하는 문제이기 때문에, 이분탐색 동안에 mid값이 아닌 sum값을 구해주면 된다
 * 4. left와 right인덱스 값의 합산을 구한다음 그 다음 로직을 진행한다
 * 5. 두 용액의 합산이 0에 가까운 경우를 찾는 것이므로 절댓값을 떠올리면 된다. 절댓값이 작을 수록 정답에 가까운 것이므로 절댓값차이가 ans보다 작으면 ans를 갱신하고 정답 출력을 위한 a와 b도 갱신한다
 * 6. 이어서 최적의 결과를 찾기 위해 sum값을 비교한다. 만약 0보다 크거나 같다면 양수값이 영향력이 더 큰 것이므로 right를 줄이고 반대의경우 left를 늘려준다
 * 7. 완성한 결과의 인덱스 값을 출력하면 정답이 된다 
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = n-1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(ans > Math.abs(sum)){
                ans = Math.abs(sum);
                a = left;
                b = right;
            }

            if(sum >= 0){
                right--;
            }else{
                left++;
            }

        }

        bw.write(arr[a] + " " + arr[b]);
        

        br.close();
        bw.close();
    }

}
