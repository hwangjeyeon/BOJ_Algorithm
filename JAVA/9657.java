import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. dp방식을 이용해서 생각을 했을 때, 0~6까지의 경우 중 상근이가 지는 경우는 0일때와 2일때이다. 
 * 2. 따라서 n%7 == 0, n%2 == 0 일때만 창영, 나머지는 상근이가 이기도록 출력하면 된다
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
        int n = Integer.parseInt(br.readLine());

        if(n%7 == 0 || n%7 == 2){
            bw.write("CY");
        }else{
            bw.write("SK");
        }

        br.close();
        bw.close();
    }



}

