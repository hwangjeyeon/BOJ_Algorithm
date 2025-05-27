import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. HashMap을 활용해서 문제가 틀렸을 경우 개수를 세어주고, 맞은 경우 count를 증가시키고 틀린 개수 * 20 + 맞은 시간을 더해주면 된다
 * 2. 완성한 count와 time을 빈칸을 하나 포함해서 출력하면 정답이 된다
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

        int count = 0;
        int time = 0;
        Map<String, Integer> map = new HashMap<>();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if(m == -1){
                break;
            }
            String name = st.nextToken();
            String result = st.nextToken();
            if(result.equals("wrong")){
                map.put(name, map.getOrDefault(name, 0) + 1);
            }else{
                time += map.getOrDefault(name, 0)*20 + m;
                count++;
            }

        }

        bw.write(count + " " + time);
        
        br.close();
        bw.close();
    }
}
