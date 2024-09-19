
import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진 명령대로 구현하여 배열을 만들어둔다
 * 2. 완성한 배열을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(n)
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
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(order == 1){
                arr[a-1] = b;
            }else if(order == 2){
                for (int j = a-1; j < b; j++) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
            }else if(order == 3){
                for (int j = a-1; j < b; j++) {
                    arr[j] = 0;
                }
            }else{
                for (int j = a-1; j < b; j++) {
                    arr[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] +" ");
        }

        br.close();
        bw.close();
    }
}

