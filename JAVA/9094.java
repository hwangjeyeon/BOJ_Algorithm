import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진 대로 테스트케이스만큼 순회를 돌면서 n만큼 순회를 돌아준다
 * 2. b a보다 커야하므로 n+1부터 시작한다
 * 3. 계산결과를 double 형에 받아주고, 실수부분이 있는지는 1로 모듈러 연산을 진행해서 0보다 작거나 같은경우 count++해준다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(T*n*m)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    double tmp = (Math.pow(j,2) + Math.pow(k,2) + m)/(j*k);
                    if(tmp%1.0 <= 0){
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }

        br.close();
        bw.close();
    }

}

