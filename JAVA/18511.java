import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * 재귀
 * 1. 함수 형태 bigNumber(list, 현재 숫자, n,k)
 * 2. base Condition if(현재숫자 > n)
 * 3. 재귀식 bigNumber(num*10 + list.get(i)); -> k만큼 순회
 *
 * 1. 리스트는 내림차순 정렬을 해준다
 * 2. 조합으로도 풀 수 있다고 하는데 일단 지금은 재귀를 학습하는 것이 먼저이기에 재귀문으로 해결하였다
 * 3. 0부터 k까지 반복문을 통해 재귀함수를 실행한다. 변화하는 값은 num부분으로 자릿수를 밀어야 하므로 num*10을 해주고 list.get(i)을 진행해준다
 * 4. 이렇게 재귀함수를 n보다 커지기 전까지는 계속해서 k만큼의 순회가 추가되게 된다. 따라서 모든 수를 탐색하면서 원하는 수를 찾을 수 있게 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(klogn)
 * 공간복잡도: O(klogn)
 *
 */


public class Main {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Collections.reverseOrder());

        bigNumber(list, 0,n, k);
        bw.write(ans+"");
        br.close();
        bw.close();
    }

    private static void bigNumber(List<Integer> list, Integer num, int n, int k) {
        if(num > n){
            return;
        }
        if(ans < num){
            ans = num;
        }

        for (int i = 0; i < k; i++) {
            bigNumber(list,num*10 + list.get(i),n, k);
        }

    }


}

