import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Long타입으로 받아 비교후 정답을 출력하면 된다
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
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        if(n == m){
            bw.write("1");
        }else{
            bw.write("0");
         }
        
        
        br.close();
        bw.close();

    }

    
}