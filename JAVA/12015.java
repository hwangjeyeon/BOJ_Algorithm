import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS로 해결하는 문제다. 일단 기본적으로 DP를 활용해서 해결한다
 * 2. 이전 문제는 입력값 최대가 작아서 이중포문으로 가능했지만 이번에는 입력값이 크기 떄문에 불가능하다
 * 3. 따라서 이중포문이 아닌 이분탐색으로 시간복잡도를 줄여야 한다
 * 4. 이중포문할 때의 LIS를 떠올리면, 현재 지점을 기준으로 이전 지점에서 현재 지점보다 작은 것의 개수를 세어주고, 현재 값에 +1을 했었다
 * 5. 이번에도 비슷하게 해결하는데 살짝 다르게 전개된다
 * 6. DP에 크기가 순으로 오름차순 정렬하듯이 배치하기 떄문이다
 * 7. 따라서 현재 지점의 DP 이전 지점을 확인하고 만약 현재 지점이 더 크다면 DP의 그 지점에 현재 값을 배치한다. 그리고 전체 길이를 확대한다
 * 8. 만약 크지 않다면 그 이전에 배치해야하는데 단순 포문으로는 불가능하다. 이때 이분탐색을 활용한다
 * 9. 만약 중간 위치의 값이 현재 값보다 작으면 left를 조절하고, 반대일 경우 right를 조절한다. 
 * 10. 이분탐색 결과 완성된 left를 인덱스로 하는 dp의 값에 현재 배열의 값을 넣어준다. 
 * 11. 이렇게 하면 오름차순 정렬된 DP가 완성되면서 증가하는 부분 수열의 가장 긴 길이도 얻을 수 있다
 * 12. 이제 완성한 len을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */
public class Main {


    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        dp[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > dp[len-1]){
                len++;
                dp[len-1] = arr[i];
            }else{
                int left = 0;
                int right = len-1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(dp[mid] < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                dp[left] = arr[i];
            }

        }

        bw.write(len+"");

        br.close();
        bw.close();
    }

}
