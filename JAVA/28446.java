import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. map을 쓰는데, 1인경우와 2인 경우 나눠서 사용하면 된다
 * 2. 1인경우 key, value형태로 넣는데, 무게를 key로 사물함을 value로 넣는다. 찾을때 역으로 찾고, 한 무게는 한 사물함에 만 있기 때문이다
 * 3. 2인 경우 해당 무게가 key로 있는 map의 value를 출력하면 정답이 된다 
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 1){
                int x = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                map.put(w, x);
            }else{
                int w = Integer.parseInt(st.nextToken());
                bw.write(map.get(w)+"\n");
            }
        }

        br.close();
        bw.close();
    }
}
