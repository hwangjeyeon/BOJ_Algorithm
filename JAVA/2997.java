import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 작은수부터 큰수까지의 값의 차를 저장한 뒤 두 값을 비교해서 값을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int n = arr[1] - arr[0];
        int n2 = arr[2] - arr[1];

        if(n == n2){
            bw.write(arr[2] + n + "");
        }else if(n < n2){
            bw.write(arr[1] + n + "");
        }else{
            bw.write(arr[0] + n2 + "");
        }

        br.close();
        bw.close();
    }
}
