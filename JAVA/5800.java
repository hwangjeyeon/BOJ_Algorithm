import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 최댓값, 최솟값은 처음 입력값으로 판별하고, 각 값들은 배열에 담아 입력 종료 후 내림차순 정렬한다
 * 2. 이후 n-1만큼 순회하며 i와 i+1간의 차이의 최댓값을 구한다
 * 3. 출력 형식에 맞춰 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int idx = 1;
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int max = 0;
            int min = Integer.MAX_VALUE;
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                max = Math.max(max, a);
                min = Math.min(min, a);
                arr[i] = a;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int diff = 0;
            for (int i = 0; i < n-1; i++) {
                diff = Math.max(diff, arr[i] - arr[i+1]);
            }
            bw.write("Class " + idx++ +"\n");
            bw.write("Max " + max + ", Min " + min + ", Largest gap " + diff + "\n");
        }

        br.close();
        bw.close();

    }
}
