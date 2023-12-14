import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 이전 유클리드 호제법으로 푼 문제와 동일하다
 * - 최소공배수는 두 수의 곱 나누기 최대공약수이고
 * - 최대공약수는 두 수 중에서 더 작은 수가 0이 아닐때 동안 반복하여, 나머지와 작은 수를 비교해서 최대 공약수를 구한다
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
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long tmpA = a;
        long tmpB = b;



        while(b != 0){
            long r = a%b;
            a = b;
            b = r;
        }
        bw.write(tmpA*tmpB/a + "");



        br.close();
        bw.close();
    }

}
