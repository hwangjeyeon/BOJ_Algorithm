import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * 해결방법:
 * - 너무 쉬운 문제라 생략.
 *
 * 시간복잡도:
 * 공간복잡도:
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        bw.write(A+B+C+"");

        br.close();
        bw.close();
    }

}
