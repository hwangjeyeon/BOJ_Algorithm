import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. b+(a/2)한 값과 n을 비교해서 더 작은 값을 출력하면 정답이 된다
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum = b + (a/2);
        if(n < sum){
            bw.write(n+"");
        }else{
            bw.write(sum+"");
        }

        br.close();
        bw.close();

    }
}
