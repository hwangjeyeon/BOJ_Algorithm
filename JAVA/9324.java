import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 문제 오역.. 세번째 등장할 때마다 현재 문자가 한번씩 더 등장한다
 * 2. 따라서 Map을 이용해서 4로 모듈러 연산하고 3인 경우 FAKE여부를 체크하면 된다
 * 3. 이후 결과를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(|s|)
 * 공간복잡도: O(|s|)
 *
 */

public class Main {

    static final String OK = "OK";
    static final String FAKE = "FAKE";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] arr = br.readLine().toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            String ans = OK;
            boolean last = false;
            for (int j = 0; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                last = map.get(arr[j]) % 4 ==3;

                if(last && (j == arr.length-1 || arr[j] != arr[j+1])){
                    ans = FAKE;
                    break;
                }

            }

            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}
