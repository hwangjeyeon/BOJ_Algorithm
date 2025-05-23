import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. long타입으로 받아야할것들만 처리하면, 이후 map을 써서 쉽게 해결할 수 있는 문제다
 * 2. 각 재료들에 대한 가격 정보를 map에 담고, 이후 하나씩 꺼내서 count에 더해준뒤, 비교해서 정답을 출력하면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Long.parseLong(st.nextToken()));
        }
        long count = 0;
        for (int i = 0; i < m; i++) {
            count += map.get(br.readLine());
        }

        if(b >= count){
            bw.write("acceptable");
        }else{
            bw.write("unacceptable");
        }

        br.close();
        bw.close();
    }
}
