import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 각 문자열이 지정된 범위 내인지 확인 후 결과에 맞는 내용을 출력하면 정답이 된다
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
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.length() >= 6 && s.length() <= 9){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }

        br.close();
        bw.close();
    }

}