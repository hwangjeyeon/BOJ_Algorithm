

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에는 오름차순 정렬 후에 왼쪽부터 큰값에 작은값 절반을 더하는 형식으로 생각했으나 원하는 값은 나오지 않았다
 * 2. 이어서 더 그리디하게 생각해보았는데 오름차순 정렬 후 가장 큰 값에다가 가장 작은 값을 더하면 되지 않을까 생각을 하였다
 * 3. 가장 오른쪽 값에 왼쪽 값부터 순회해서 차례대로 더하면 원하는 결과를 얻을 수 있다
 * 4. float가 10^-7, double 10^-15 부터로 절대/상대 오차가 발생하는 것으로 알고 있는데 문제에서는 10^-5까지 허용한다고 했으니까 어느것을 선택해도 상관없다.
 * 5. 풀이의 편의를 위해 double을 선택했다.
 *
 * - 문제 해결:
 *
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);
        double ans = 0;
        for (int i = 0; i < n-1; i++) {
            arr[n-1] = arr[n-1] + arr[i]/ 2;
        }
        bw.write(arr[n-1]+"");

        br.close();
        bw.close();
    }
}

