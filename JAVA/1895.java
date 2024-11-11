import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. n과 m의 크기가 작고 필터 크기고 3*3으로 고정되어 있기 때문에 브루트포스로 풀면 되는 문제다
 * 2. 3*3을 고려한 범위 내에서 탐색하며, 필터 범위내의 모든 수를 임시 리스트에 넣는다.
 * 3. 이후 리스트를 오름차순 정렬한 다음, 5번째 인덱스의 값을 가져와서 t와 비교한 뒤 크거나 같다면 ans를 증가시킨다
 * 4. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O((n-2)*(m-2)*3*3)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m - 2; j++) {
                List<Integer> lists = new ArrayList<>();
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        lists.add(arr[k][l]);
                    }
                }
                Collections.sort(lists);
                int mid = lists.get(4);
                if(mid >= t){
                    ans++;
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

