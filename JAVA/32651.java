import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 100000보다 작으면서 2024 배수면 Yes, 아니면 No를 출력하면 정답이된다
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
        if(n < 100000 && n%2024 == 0){
            bw.write("Yes");
        }else{
            bw.write("No");
        }

        br.close();
        bw.close();
    }
}

