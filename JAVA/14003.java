import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS + 이분탐색 문제인데, 스택을 이용해서 LIS 값을 구한뒤 출력해야한다
 * 2. 이 문제는 이전방식과 다르게 LIS 배열을 하나 더 만들어야한다
 * 3. 그리고 LIS에 원래 DP에 보관하던 값을 넣고, DP에는 증가하는 길이를 넣어준느 방식이다
 * 4. LIS의 0번째 값은 범위의 최솟값 - 1을 넣어준다. len은 0부터 시작한다. 참고로 lis 배열은 n+1의 크기를 갖는다
 * 5. 만약 lis[len] < arr[i]라면 dp[i] = ++len이고, lis[len] = arr[i]를 한다
 * 6. 아닐 경우 이분탐색을 시작한다. left는 0, right는 len으로 해준다
 * 7. 이전과 결과는 동일하며, 완성된 lis[left] = arr[i]를 넣고 dp[i]는 left를 넣어서 몇번째 증가하는 부분수열의 길이인지 나타낸다
 * 8. 이후, len을 출력하고 n-1부터 0까지 감소 탐색하면 dp[i] == len일때 stack에 arr[i]를 넣어준다. 그리고 len을 줄인다
 * 9. 스택이 빌때가지 안에 있는 값들을 출력하면 정답이 된다.
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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int[] lis = new int[n+1];
        lis[0] = -1_000_000_001;
        int len = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(lis[len] < arr[i]){
                dp[i] = ++len;
                lis[len] = arr[i];
            }else{
                int left = 0;
                int right = len;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(lis[mid] < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }

                lis[left] = arr[i];
                dp[i] = left;
            }
        }
        bw.write(len+"\n");
        for (int i = n-1; i >= 0; i--) {
            if(dp[i] == len){
                stack.push(arr[i]);
                len--;
            }
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }

        br.close();
        bw.close();
    }

}
