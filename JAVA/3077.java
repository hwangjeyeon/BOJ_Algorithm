import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 처음 순서가 있는 값은 map으로 받는다. key는 들어오는 입력값으로 하고 순회의 단계인 i를 값으로 받는다
 * 2. 이어서 오는 값은 list로 받는다
 * 3. 그다음 완전탐색으로 현재 i의 순서가 j의 순서보다 작은 경우 순서가 맞는 것이므로 ans값을 증가시킨다
 * 4. 최종 출력으로 형식에 맞춰서 출력하면 정답이 된다.
 *
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            map.put(name, i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(map.get(list.get(i)) < map.get(list.get(j))){
                    ans++;
                }
            }
        }
        bw.write(ans + "/" + (n*(n-1)/2));

        br.close();
        bw.close();
    }


}
