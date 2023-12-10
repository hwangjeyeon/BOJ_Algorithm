import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - map을 이용하면 쉽게 풀리는 문제다. 먼저 입력받은 key로 map에 세팅해주고, 그 다음 검사하고자 하는 문자열과 비교해서 count값을 증가시킨 뒤 출력하면된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> maps = new HashMap<>();

        for(int i=0; i<n; i++){
            String alpha = br.readLine();
            maps.put(alpha, 1);
        }
        int count = 0;
        for(int i=0; i<m; i++){
            String beta = br.readLine();
            if(maps.containsKey(beta)){
                count++;
            }
        }

        bw.write(count + "");

        br.close();
        bw.close();
    }

}
