import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 합이 홀수거나 b가 더 크면 -1을 출력한다
 * 2. 아닌경우 두수의 합의 절반몫과 거기서 b를 뺀값을 출력하면 정답이된다
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

        if((a+b) % 2 !=0 || a < b){
            bw.write("-1");
        }else{
            bw.write(((a+b)/2) + " " + ((a+b)/2 - b));
        }

        br.close();
        bw.close();
    }

}
