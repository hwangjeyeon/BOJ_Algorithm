import java.io.*;


/**
 * 풀이 과정:
 * - 4*n이라는 규칙을 찾으면 된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {

//    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        bw.write(n*4 + "");


        br.close();
        bw.close();
    }

}
