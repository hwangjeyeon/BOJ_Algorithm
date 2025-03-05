import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS와 LDS를 각각의 DP에 구해서 합한 중 최댓값을 구하는 문제다
 * 2. 이때, 단순히 합친 것이기 때문에, 원소가 1개씩 중복되어 있다. 따라서 최종결과에 1을 빼줘야 한다
 * 3. LIS는 오름차순, LDS는 내림차순 느낌으로 생각하면된다. LIS의 탐색시작이 원소의 앞이라면 LDS는 맨 뒤라고 생각하면 된다.
 * 3. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
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
        int[] dpI = new int[n];
        int[] dpD = new int[n];
        for (int i = 0; i < n; i++) {
            dpI[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dpI[i] = Math.max(dpI[i], dpI[j]+1);
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            dpD[i] = 1;

            for (int j = n-1; j > i; j--) {
                if(arr[i] > arr[j]){
                    dpD[i] = Math.max(dpD[i], dpD[j]+1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dpI[i] + dpD[i]);
        }
        bw.write((max-1)+"");
        
        br.close();
        bw.close();
    }

}
