import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 입력값들은 배열에 넣고, 확인해야할 수를 뽑아내기 위해 set을 사용한다
 * 2. 입력값이 작아서 완전탐색으로 해결할 수 있다
 * 3. set에 있는 모든 값들을 비교한다. 배열을 순회하면서 체크하는데 만약 순회중인 배열과 a가 같다면 continue해준다
 * 4. 만약 현재 배열과 미리 뽑아둔 now와 같지 않으면 count를 다시 1로 초기화한다
 * 5. 만약 같으면 count++해주고 ans에 더 큰값으 ㄹ넣어준다
 * 6. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }

        int ans = 1;
        for(int a : set){
            int count = 1;
            int now = arr[0];
            for (int i = 1; i < n; i++) {
                if(arr[i] == a){
                    continue;
                }
                if(arr[i] != now){
                    count =1;
                }else{
                    count++;
                    ans = Math.max(ans, count);
                }
                now = arr[i];
            }
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }

}

