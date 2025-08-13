import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 분기 처리해서 결과를 출력하면 정답이 된다
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
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if(month < 2 || (month == 2 && day < 18)){
            bw.write("Before");
        }else if(month == 2 && day == 18){
            bw.write("Special");
        }else{
            bw.write("After");
        }

        br.close();
        bw.close();
    }

}
