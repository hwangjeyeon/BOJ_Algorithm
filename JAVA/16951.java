import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 최대 n이 1000이하이기 때문에 완전탐색으로 풀 수 있는 문제다
 * 2. 한 지점을 기준으로 모든 지점에 대해서 완전탐색하며, 현재 배열의 값과 k의 차를 넣어준다. 왼쪽과 오른쪽을 돌면서 확인하며, 0이 될경우 isOk 플래그를통해 정답 갱신을 피한다
 * 3. 임시 배열을 만들어서 값을 기록하며 탐색이 완료된 뒤에는 다른 개수를 카운트해준뒤 정답 변수와 비교하여 더 작은 값으로 채워준다.
 * 4. 완성한 정답 변수를 출력하면 정답이 된다.
 *
 * - 문제 해결:
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            tmp[i] = arr[i];

            boolean isOk = false;
            for (int j = i-1; j >= 0; j--) {
                tmp[j] = tmp[j+1] - k ;
                if(tmp[j] <= 0){
                    isOk = true;
                    break;
                }
            }

            if(!isOk){
                for (int j = i+1; j < n; j++) {
                    tmp[j] = tmp[j-1] + k;
                }
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if(tmp[j] != arr[j]){
                        count++;
                    }
                }
                ans = Math.min(ans, count);
            }

        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

