import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 누적합을 이용하는 문제이다. 이전값들을 누적해서 현재의 배열에 저장한다
 * 2. max에 arr[k-1]값을 넣어두고 k부터 순회를 시작한다
 * 3. max에 max와 arr[i] - arr[i-k]중에서 더 큰 값을 넣어준다
 * 
 * - 처음에는 이중포문을 했는데, n과 k가 같을 때, 아예 순회를 못하는 문제가 있어서 제출 후 틀렸고 다시 풀게 되었다.
 * - 문제에서 아예 누적합이라고 알려줬는데 알아차리지 못했다.. 관련 문제를 더 풀어보면서 익히도록 해야겠다.
 * 
 * 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!= 0){
                arr[i] += arr[i-1];
            }
        }

        int max = arr[k-1];
        for (int i = k; i < n; i++) {
            max = Math.max(arr[i] - arr[i-k], max);
        }


        bw.write(max+"");
        br.close();
        bw.close();
    }

}
