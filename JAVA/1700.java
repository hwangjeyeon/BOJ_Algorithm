

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 플러그의 상태는 set을 활용해서 관리해준다
 * 2. 만약 현재 set에 arr[i]가 있다면 continue한다. 이때 set.isEmpty()라고 해도 스택과 다르게 예외가 발생하지 않는다!
 * 3. 만약 set.size()가 n보다 작으면 set.add(arr[i]);를 해준다
 * 
 * 틀린 해결 방법: 
 * 1. 현재 지점+1부터 n만큼만 탐색해보는 방법 -> 그 뒤에 더 좋은 조건이 있을 수 있기 때문에 불가능!
 * 2. 그럼 입력 값이 작으니까 k까지 탐색을 한다면? -> 빈도수를 기준으로 했을 때보다 더 좋은 조건이 존재함. 높은 빈도수가 뒤에 몰려있을 경우 비효율적임
 * 
 * 
 * - 문제 해결:
 * 1. 가장 그리디하게 푸는 방법은 먼저 현재지점 + 1에 현재 플러그 번호가 있는지 체크하고 없는 것을 우선적으로 제거한다
 * 2. 만약 모두 있다면 가장 늦게 사용하는 것을 우선적으로 제거한다
 * 3. max와 pos를 사용하였고, list를 사용해서 i+1부터 k까지의 수를 담았다
 * 4. list의 contains를 사용해서 만약 해당하는 수가 있다면 indexOf(s) + 1을 통해 가장 처음 발견되는 인덱스 위치 + 1을 해준다
 * 5. 만약 발견되지 않는다면 k-i-1을 통해 나올 수 있는 가장 큰 수로 보내서 최우선적으로 제거되도록 한다
 * 6. tmp가 max보다 크다면 max에 tmp를 넣고 pos에  s를 넣는다
 * 7. 위 과정 종료 후에 set에서 해당하는 pos를 remove한다
 * 8. 그리고 현재 arr[i]를 set에 add한다
 * 9. ans값을 이어서 증가시키고, 위 과정이 모두 끝나면 완성된 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n*k*(k-n))
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
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if(set.contains(arr[i])) {
                continue;
            }
            if(set.size()<n){
                set.add(arr[i]);
                continue;
            }

            int max = -1;
            int pos = -1;
            for (Integer s : set) {
                int tmp = 0;
                List<Integer> list = new ArrayList<>();
                for (int j = i+1; j < k; j++) {
                    list.add(arr[j]);
                }
                if(list.contains(s)){
                    tmp = list.indexOf(s)+1;
                }else{
                    tmp = k-i-1;
                }

                if(tmp > max){
                    max = tmp;
                    pos = s;
                }
            }
            set.remove(pos);
            set.add(arr[i]);
            ans++;

        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }
}

