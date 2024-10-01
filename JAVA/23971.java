import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 
 *
 * - 문제 해결:
 * 1. 1명이 앉을 자리를 빼고, n칸 띄운다음 뺀 1명의 자리를 더하면 정답이 된다.
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
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int height = (h-1) / (n+1) + 1;
        int width = (w - 1) / (m+1) +1;



        bw.write(height*width+"");

        br.close();
        bw.close();
    }
}

