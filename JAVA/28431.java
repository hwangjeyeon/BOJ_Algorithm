import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 풀이 과정:
 * 1. map을 활용해서 2의 모듈러 연산이 1인 경우 해당 값을 출력하고 탈출하면 정답이 된다
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(br.readLine());
            map.put(a, map.getOrDefault(a,0)+1);
        }

        for (Integer i : map.keySet()) {
            if(map.get(i) %2 == 1){
                bw.write(i + "");
                break;
            }
        }

        br.close();
        bw.close();
    }
}
