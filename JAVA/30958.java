import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - map을 활용하여서, values로 개수를 세고 Collections.max를 통해 values들의 값들 중 가장 큰 값을 구해서 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String alpha = "";
        while(st.hasMoreTokens()){
            alpha += st.nextToken();
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < alpha.length(); i++) {
            char current = alpha.charAt(i);

            if (current == ',' || current == '.') {
                continue;
            }
            frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);
        }



        int max = Collections.max(frequencyMap.values());
        bw.write(max+"");



        br.close();
        bw.close();
    }

}
