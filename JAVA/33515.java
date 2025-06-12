import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 단순히 비교해서 더 큰값 출력하면 정답이 된다
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
        if(a > b){
            bw.write(b+"");
        }else{
            bw.write(a+"");
        }
        
        
        br.close();
        bw.close();
    }

}