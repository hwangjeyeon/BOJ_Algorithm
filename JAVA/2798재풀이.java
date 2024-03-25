import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이: 
 * 1. 3중 포문 돌려서 tmp에 값을 넣고 m과의 차이가 더 작은 것을 ans에 넣어준다
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int tmp = 0;
                    tmp = arr[i] + arr[j] + arr[k];
                    if(tmp <= m){
                        if(m-ans > m-tmp){
                            ans = tmp;
                        }
                    }
                }
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

