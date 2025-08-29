import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Map을 이용해 가장 많이 나온 번호와 그 숫자를 구하고 num/2보다 큰지 여부에 따라 출력하면 정답이 된다
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
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Map<Long, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int max = 0;
            long idx = 0L;
            for (int j = 0; j < num; j++) {
                long a = Long.parseLong(st.nextToken());
                if(map.containsKey(a)){
                    map.replace(a, map.get(a) + 1);
                }else{
                    map.put(a, 1);
                }

                if(map.get(a) > max){
                    max = map.get(a);
                    idx = a;
                }
            }
            if(max > num/ 2){
                bw.write(idx+ "\n");
            }else{
                bw.write("SYJKGW\n");
            }

        }

        br.close();
        bw.close();
    }

}
