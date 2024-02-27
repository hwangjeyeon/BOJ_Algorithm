import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - GCD 유클리드 호제법 공식 사용
 * - 최대 공약수: while(b > 0): tmp = a%b; a = b; b = tmp;
 * - 최대 공배수: (a+b) / 최대공약수
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int tmpA = a;
        int tmpB = b;
        while(b>0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        int ans = (tmpA * tmpB) / a;

        bw.write(a+"\n" + ans);


        br.close();
        bw.close();
    }

}

