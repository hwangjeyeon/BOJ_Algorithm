import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * 1. 그냥 다 더하고 시간은 60의 몫, 24시간의 나머지로 출력하고 분은 60의 나머지로 출력한다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());

        int tmp = H*60 + M + T;
        int ans_h = tmp/60;
        ans_h = ans_h%24;
        int ans_m = tmp%60;

        bw.write(ans_h + " " + ans_m);

        br.close();
        bw.close();
    }

}
