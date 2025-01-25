import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이분탐색을 이용한 LIS 문제다
 * 2. 순서가 있는 1차원 배열이 존재하며, 각 선택지에서 증가하는 가격으로만 구매할 때 그 날짜가 k여야함을 보고 LIS라고 예상했다
 * 3. 이번에는 리스트를 이용했다. 처음 값을 리스트에 넣는다
 * 4. 이어서 리스트의 마지막 값이 현재 배열의 값보다 작으면 리스트에 해당 값을 넣는다
 * 5. 그렇지 않으면 이분탐색으로 현재 배열의 값에 가장 근접한 값을 찾는다. 그리고 left위치에 현재 배열의 값을 넣어준다
 * 6. 첫번째 예제에서 5번을 실행해보면 100과 50을 비교할 때, 100의 자리에 50이 들어가고 90과 75를 비교할 때, 90자리에 75가 들어갈 것이다
 * 7. 이렇게 완성한 결과가 k이상일 경우 정답이 되므로 1을 출력하며 아닐 경우 0을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(T x n x logn)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            for (int i = 1; i < n; i++) {
                if(list.get(list.size() - 1) < arr[i]){
                    list.add(arr[i]);
                }else{
                    int left = 0;
                    int right = list.size();
                    while(left <= right){
                        int mid = (left + right) / 2;
                        if(list.get(mid) < arr[i]){
                            left = mid + 1;
                        }else{
                            right = mid - 1;
                        }
                    }
                    list.set(left, arr[i]);
                }
            }
            bw.write("Case #" + tc + "\n");
            if(list.size() >= k){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }

        }

        br.close();
        bw.close();
    }
}
