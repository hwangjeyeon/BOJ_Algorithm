import java.io.*;
import java.time.LocalTime;
import java.util.*;

/**
 * 풀이 과정:
 * 1.기초 구현 문제
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean isFind = false;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if(n==i*j){
                    isFind = true;
                }
            }
        }
        if(isFind){
            bw.write("1");
        }else{
            bw.write("0");
        }


        br.close();
        bw.close();

    }
}
