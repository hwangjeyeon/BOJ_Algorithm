import java.io.*;

/**
 * 풀이 과정:
 * 1. StringBuilder를 사용하면 쉽게 풀수있다
 *
 * 해결방법:
 
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        sb.setLength(5);
        sb.reverse();
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}

