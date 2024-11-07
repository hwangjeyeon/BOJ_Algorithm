import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 처음에는 그리디로 풀었으나 사실 완전탐색 하는 문제이다. 음수*음수이면 그리디로 풀 수 없기 때문이다
 * 2. k개만큼 순회를 돌면서 추가로 공유 리스트 크기 * 내 리스트 크기 만큼 순회를 돌고, 두 곱이 max보다 크다면 갱신하고 위치도 갱신해준다
 * 3. 순회 이후 최종 결정된 위치로 내 리스트의 원소를 지운다
 * 4. 이후 다시 이중포문을 돌면서 정답을 더 큰 값으로 갱신한뒤 출력하면 정답이 된다.
 *
 * 시간복잡도: O(k*n^2)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> share = new ArrayList<>();
        List<Integer> mine = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            share.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            mine.add(Integer.parseInt(st.nextToken()));
        }

        int max = 0;
        int idx = -1;
        for (int i = 0; i < k; i++) {
            max = Integer.MIN_VALUE;
            idx = -1;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < mine.size(); l++) {
                    if(max < share.get(j) * mine.get(l)) {
                        max = share.get(j) * mine.get(l);
                        idx = l;
                    }
                }
            }
            mine.remove(idx);
        }
        ans = share.get(0) * mine.get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < mine.size(); j++) {
                ans = Math.max(ans, share.get(i) * mine.get(j));
            }
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

