import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 문제별 점수는 배열에 관리한다
 * 2. 학생별 점수는 TreeMap으로 관리한다. 역순으로 해야지 같은 값을 갱신할 때, 가장 작은 값으로 출력할 수 있다
 * 3. 이후, TreeMap의 값을 모두 뽑아내서 최댓값을 갱신하면 된다
 * 4. 완성한 사람의 번호와 최댓값을 출력하면 정답이 된다.
 * 5. 이때, 주의할 점이 사람의 번호를 얻었을 때 미리 0으로 초기화해서 넣어야한다. 
 * 6. 그래야지 모든 사람이 모든 문제를 틀렸을 때 이상하게 갱신되는 것을 막을 수 있다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(m)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Long> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());;
            int num = Integer.parseInt(st.nextToken());
            map.put(num, 0L);
            for (int j = 0; j < n; j++) {
                String b = st.nextToken();
                if(b.equals("O")){
                    map.put(num, map.get(num) + arr[j]);
                }
            }
        }

        long max = 0;
        int num = 0;
        for (Integer i : map.keySet()) {
            if(max <= map.get(i)){
                max = map.get(i);
                num = i;
            }
        }

        bw.write(num + " " + max);
        
        br.close();
        bw.close();

    }
}
