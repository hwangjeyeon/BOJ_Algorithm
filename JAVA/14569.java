import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 비트마스킹으로 해당 문제를 해결할 수 있다
 * 2. 최대 50자리까지 표현하므로 long타입으로 선언해야한다
 * 3. 각 배열에 입력으로 들어온 a만큼 왼쪽으로 1을 이동한다
 * 4. 이어서 들어오는 값들을 똑같이 정리해서 비교를 준비한다
 * 5. 이제 앞선 배열과 비교하면서 현재 완성한 시간표의 비트값과 비교한다
 * 6. 이때 배열의 값과 시간표의 NOT한 값을 AND연산했을 때, 그 결과가 0이면 겹치는 시간표가 없으므로 count해준다
 * 7. 완성한 count를 출력하면 정답이 된다,
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i] |= 1L << a;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long tmp = 0;
            for (int j = 0; j < p; j++) {
                int a = Integer.parseInt(st.nextToken());
                tmp |= 1L << a;
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if((~tmp & arr[j]) == 0){
                    count++;
                }
            }

            bw.write(count+"\n");
        }

        br.close();
        bw.close();
    }

}

