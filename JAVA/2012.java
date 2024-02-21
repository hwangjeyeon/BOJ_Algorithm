import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 입력 받고 배열을 오름차순 한 뒤에 주어진 수식을 ans에 합해주면 된다
 * - 이때 ans는 오버플로우가 발생할 수 있으므로 long형으로 해야한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(arr[i] - (i+1));
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

