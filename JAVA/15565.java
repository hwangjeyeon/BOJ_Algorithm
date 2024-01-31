import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 슬라이딩 윈도우 알고리즘으로 풀었습니다.
 * - 라이언의 위치만 알면 정답을 구할 수 있다.
 * - 라이언의 위치를 모두 담을 리스트를 만든 뒤, 입력받을 때 리스트에 저장한다
 * - 만약 리스트의 크기가 k보다 작은 경우 -1을 출력한다
 * - 이제 순회하는데 리스트 크기 빼기 k와 같을 때까지 0부터 순회한다
 * - 최소 크기를 구해야하므로 이전 크기와 현재 인덱스 + 2를 인덱스로 하는 리스트의 값 빼기 현재 인덱스를 리스트의 인덱스로 하는 리스트의 값을 빼고 거기에 1을 더한 값을 비교하여 더 작은 값을 ans에 저장한다
 * - 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] doll = new int[n];
        List<Integer> ryanPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
            if(doll[i] == 1){
                ryanPos.add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        if (ryanPos.size() < k){
            ans = -1;
        }else{
            for (int i = 0; i <= ryanPos.size() - k; i++) {
                ans = Math.min(ans, ryanPos.get(i+k-1) - ryanPos.get(i)+1);
            }
        }



        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}
