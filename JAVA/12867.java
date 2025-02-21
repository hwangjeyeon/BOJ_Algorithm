import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n을 보지 말고 m을 보는 문제다
 * 2. 좌표를 압축하는 문제다. Set과 Map을 이용하면 쉽게 해결할 수 있다
 * 3. 각 인덱스를 map에다가 넣어주자
 * 4. 그리고 0이 되면 map에서 제거한다
 * 5. 이후 set에 현재 map의 값이 포함되어 있으면 정답 불가로 바꾸고 탈출한다
 * 6. 만약 포함되어 있지 않다면 set에 새롭게 넣어준다
 * 7. 이후 한번 더 확인해야한다. 만약 map이 비어있다면 모든 인덱스가 0이므로 정답 불가로 바꿔준다
 * 8. 이후 정답값에 따라 적절하게 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        char[] c = br.readLine().toCharArray();
        Set<Map<Integer, Integer>> set = new HashSet<>();
        Map<Integer, Integer> pos = new HashMap<>();
        set.add(new HashMap<>(pos));
        boolean isAns = true;
        for (int i = 0; i < m; i++) {
            int d = arr[i];
            pos.put(d, pos.getOrDefault(d, 0) + (c[i] == '+' ? 1 : -1));
            if(pos.get(d) == 0){
                pos.remove(d);
            }

            if(set.contains(pos)){
                isAns = false;
                break;
            }
            set.add(new HashMap<>(pos));
        }

        if(pos.isEmpty()){
            isAns = false;
        }

        bw.write(isAns ? "1" : "0");


        br.close();
        bw.close();
    }
}
