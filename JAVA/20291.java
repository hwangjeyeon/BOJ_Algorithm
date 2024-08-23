import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 사전 순 정렬과, 확장자를 기준으로 개수를 찾는 문제라서 TreeMap을 사용한 뒤 entrySet()으로 뽑아 key와 value를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("\\.");
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }

        for (Map.Entry<String, Integer> a : map.entrySet()) {
            bw.write(a.getKey() + " " + a.getValue() +"\n");
        }

        br.close();
        bw.close();
    }
}

