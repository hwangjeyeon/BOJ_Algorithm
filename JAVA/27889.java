import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 단순 분기 출력문제
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

        String s = br.readLine();
        if(s.equals("NLCS")){
            bw.write("North London Collegiate School");
        }else if(s.equals("BHA")){
            bw.write("Branksome Hall Asia");
        }else if(s.equals("KIS")){
            bw.write("Korea International School");
        }else if(s.equals("SJA")){
            bw.write("St. Johnsbury Academy");
        }

        br.close();
        bw.close();
    }

}