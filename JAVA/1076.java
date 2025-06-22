import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 미리 배열값으로 순서대로 넣어두고, 순선대로 색깔을 배치하면 특정 규칙대로 증가한다는 점을 이용해서 계산후 출력하면 정답이 된다
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
        String[] color = {"black", "brown", "red", "orange", "yellow", "green",
                "blue", "violet", "grey", "white"};


        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        long ans = (Arrays.asList(color).indexOf(a) * 10) + Arrays.asList(color).indexOf(b);
        ans *= Math.pow(10, Arrays.asList(color).indexOf(c));

        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

}
