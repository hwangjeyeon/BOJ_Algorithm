import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * - f(n) = a1*n0 + a0
 * - g(n) = c*n0
 * - f(n) <= g(n) 조건을 만족시키는 경우 1 아니면 0을 출력한다
 * - 이때 한가지 조건을 더 추가해줘야 하는데 a0가 음수인 경우 다른 결과가 나올 수 있기 떄문이다
 * - 추가해야할 한가지 조건은 a1 <= c조건이다.
 * - 이렇게 할 경우 정상적으로 모두 만족시키며 출력하게 된다
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        long fn = (long) a1 *n0 + a0;
        long gn = (long) c * n0;

        if(fn <= gn && a1 <= c){
            bw.write( 1 + "");
        }else{
            bw.write(0 + "");
        }

        br.close();
        bw.close();
    }


}
