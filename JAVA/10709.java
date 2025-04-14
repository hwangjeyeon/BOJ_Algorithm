import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 쉬운 구현 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(h*w)
 * 공간복잡도: O(h*w)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] arr = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                arr[i][j] = a[j];
            }
        }
        for (int i = 0; i < h; i++) {
            int last = 0;
            for (int j = 0; j < w; j++) {
                if(arr[i][j] == 'c'){
                    bw.write("0 ");
                    last=1;
                }else{
                    if(j == 0){
                        bw.write("-1 ");
                    }else{
                        if(last == 0){
                            bw.write("-1 ");
                            continue;
                        }
                        bw.write(last++ + " ");
                    }
                }
            }
            bw.write("\n");
        }

        
        br.close();
        bw.close();

    }
}
