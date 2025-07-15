import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 5번말해야하므로 n*5만큼 이진수로 바꿔서 StringBuilder에 넣어준다
 * 2. 이후, setLength()로 정확히 잘라주고, k-1부터 sb.length()까지 sb에서 꺼내서 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*5)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() <= n*5){
            sb.append(Integer.toBinaryString(num));
            num++;
        }

        sb.setLength(n * 5);
        
        for (int i = k-1; i < sb.length(); i+=n) {
            bw.write(sb.charAt(i) + " ");
        }



        br.close();
        bw.close();
    }

}
