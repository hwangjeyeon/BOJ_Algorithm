import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진 수식을 출력하면 정답이 된다.
 *
 * - 문제 해결:
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
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bw.write((d/(s*2))*t+"");
        
        br.close();
        bw.close();
    }
}

