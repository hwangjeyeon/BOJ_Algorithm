import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 전체를 합한 다음에 하나씩 뺀값에 그 값을 곱해서 합해주고, 전체 합한값에서 현재 빼는 값을 빼주는 방식으로 순회하면 정답이 된다.
 * 2. sum과 ans는 모두 long타입으로 해야한다
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
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (sum - arr[i]) * arr[i];
            sum -= arr[i];
        }

        bw.write(ans+"");



        br.close();
        bw.close();
    }

}

