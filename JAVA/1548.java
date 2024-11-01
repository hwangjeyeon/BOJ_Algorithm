import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 문제를 이해하고 그리디와 정렬을 섞어서 하는 브루트포스 문제다
 * 2. 단순히 3중포문이나 백트래킹으로 해결하는 것이 아닌 투포인터 개념을 섞어야 한다
 * 3. 삼각수열 만족하는 부분수열의 최대 길이를 구해야하는 문제다
 * 4. 이 문제에서 말하는 삼각수열을 만족하는 부분수열의 최대 길이는 예를들어 1 2 2 3 3 4 4 5 가 있으면 2~4까지이다. 따라서 6이 정답이 될 것이다
 * 5. 문제를 이해했다면 먼저 정렬을 하고, 이어서 범위를 지정해서 이중포문을 돌려 해결한다면 문제를 풀 수 있을 것이라는 것을 알 수 있다
 * 6. 먼저 예외 처리를 해주자 n이 2 이하라면 정답은 그냥 n이 된다.
 * 7. 2 초과라면 ans의 최소치는 2가 되며, 탐색을 통해 정답을 구해야한다
 * 8. 하나는 오름차순, 하나는 내림차순을 하는 이중포문을 한다. 여기서는 오름차순에서 i와 i+1 값을 선택하도록 했으므로 오름차순은 n-1 전까지만 탐색한다
 * 9. 이어서 i+1이 j랑 같다면 삼각 수열을 만족하지 못할 것이다. 따라서 이 경우에는 break해준다
 * 10. 마지막으로 삼각 수열 조건을 만족하는 arr[i] + arr[i+1] > arr[j]가 성립된다면 ans와 j-i+1 범위를 비교하여 더 큰 값으로 교체한다
 * 11. 완성한 ans를 출력하면 정답이 된다.
 * 12. 이 문제의 힌트는 범위였다. 범위를 눈치채지 못했다면 못 푸는 문제... 그리디 문제가 섞여있어서 선뜻 풀기 쉽지 않은 문제였다. 관련 문제를 더 풀어보자
 *
 *
 * 시간복잡도: O(n^2)
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
        Arrays.sort(arr);
        int ans = 2;
        if(n <= 2){
            bw.write(n+"");
        }else{
            for (int i = 0; i < n - 1; i++) {
                for (int j = n-1; j >= 0; j--) {
                    if(i+1 == j){
                        break;
                    }

                    if(arr[i] + arr[i+1] > arr[j]){
                        ans = Math.max(ans, j-i+1);
                        break;
                    }
                }
            }

            bw.write(ans+"");
        }



        br.close();
        bw.close();
    }

}

