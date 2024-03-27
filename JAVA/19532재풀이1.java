import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진 두 식을 만족하는 x와 y를 이중포문을 -999부터 999까지 돌면서 찾는다
 *
 *
 * - 문제 해결:
 *
 *
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
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if((a*i) + (b*j) == c && (d*i) + (e*j) == f){
                    bw.write(i + " " + j);
                }
            }
        }

        br.close();
        bw.close();
    }

}

