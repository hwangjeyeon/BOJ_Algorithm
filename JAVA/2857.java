import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. FBI가 포함되었으면 그 숫자를 출력하고, 카운팅해서 하나도 없으면 주어진 문자열을 출력하면 정답이 된다
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
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            if(s.contains("FBI")){
                bw.write((i+1) +" ");
                ans++;
            }
        }
        if(ans == 0){
            bw.write("HE GOT AWAY!");
        }
        
        br.close();
        bw.close();
    }
}
