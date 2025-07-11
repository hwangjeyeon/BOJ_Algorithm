import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 사칙연산 문제로 double을 이용해서 풀면된다
 *
 * 해결방법:
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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        double c = (double) a - (double)a * (0.01 * (double)b);
        if(c >= 100){
            bw.write("0");
        }else{
            bw.write("1");
        }

        br.close();
        bw.close();
    }

}