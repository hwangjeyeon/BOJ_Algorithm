import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 값을 합산한뒤 분기 처리하면 되는 문제다
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
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;

        if(sum >= 100){
            bw.write("OK");
        }else{
            if(a < b && a < c){
                bw.write("Soongsil");
            }else if(b < a && b < c){
                bw.write("Korea");
            }else if(c < a && c < b){
                bw.write("Hanyang");
            }
        }

        
        br.close();
        bw.close();
    }

}
