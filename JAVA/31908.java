import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Map을 2개 사용해서 해결하는 문제다
 * 2. 하나는 어떤 사람이 어떤 반지를 끼고 있는지 기록하고, 하나는 그 반지를 끼고 있는 사람의 개수를 확인하는 것이다
 * 3. 이를 활용해서 2중 순회로 예외 조건만 잘 처리해서 커플링 의삼자들을 파악한다
 * 4. 완성된 인원들의 수와 그 이름 쌍을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            count.put(b, count.getOrDefault(b, 0) + 1);
            map.put(a,b);
        }

        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (String a : map.keySet()) {
            if(count.get(map.get(a)) > 2){
                continue;
            }
            if(map.get(a).equals("-")){
                continue;
            }
            for (String b : map.keySet()) {
                if(map.get(a).equals(map.get(b))){
                    if(sb.toString().contains(a+" " + b) ||  a.equals(b)){
                        break;
                    }
                    sb.append(a).append(" ").append(b).append("\n");
                    ans++;
                    break;
                }
            }
        }

        bw.write(ans+ " \n" + sb);


        br.close();
        bw.close();
    }
}
