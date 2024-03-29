import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 다 비교하면 시간이 많이 걸리는거 아닌가? 라는 생각을 했는데, 주어지는 카드가 5장이라고 주어져서 완전탐색으로 충분히 풀수 있겠다고 판단하였다
 * 2. 첫번째 리스트에서는 한 사람이 뽑아서 3장울 더했을 때 나오는 수를 10으로 모듈러 연산해서 그 결과를 넣어준다
 * 3. 그다음 그 리스트에서 가장 큰 값을 리스트 2에다가 넣어준다
 * 4. 해당 순회 종료후에 이제 리스트2에서 가장 큰 값을 찾아준다. 이때 가장 큰 값을 찾으면서 pos에 다가 그 위치를 저장한다
 * 5. 완성한 pos를 출력하면 정답이 된다.
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(n*5^3)
 * 공간복잡도: O(n*5)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j+1; k < 5; k++) {
                    for (int l = k+1; l < 5; l++) {
                        int tmp = arr[i][j] + arr[i][k] + arr[i][l];
                        tmp %= 10;
                        list.add(tmp);
                    }
                }
            }
            int max = -1;
            for (int j = 0; j < list.size(); j++) {
                max = Math.max(max, list.get(j));
            }
            list.clear();
            list2.add(max);
        }
        int max = -1;
        int ans = -1;
        for (int i = 0; i < list2.size(); i++) {
            if(max <= list2.get(i)){
                max = list2.get(i);
                ans = i+1;
            }
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}
