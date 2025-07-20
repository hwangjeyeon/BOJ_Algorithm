import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Map을 이용해 등번호별 지난 시즌의 기록을 기록해준다
 * 2. List를 이용해 정답에 해당하는 인원을 넣어줄 것이다
 * 3. max를 하나 두고 d라는 변수에 지난 번과의 등수 차이를 구한 뒤, max보다 크면 max를 갱신하고 기존 리스트를 clear한다
 * 4. 이후, max랑 d가 같으면 ans에 넣어준다
 * 5. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
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
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            last.put(Integer.parseInt(st.nextToken()), i+1);
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int d = last.get(num) - i;
            if(max < d){
                max = d;
                ans.clear();
            }
            if(max == d){
                ans.add(num);
            }
        }

        for (Integer an : ans) {
            bw.write(an + " ");
        }

        br.close();
        bw.close();
    }

}
