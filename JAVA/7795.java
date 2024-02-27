import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 각 배열을 받고 내림차순 정렬을 해준다
 * - A가 B보다 큰 경우만 신경쓰면 되므로 매우 쉽게 접근하면 된다.
 * - A를 순회하면서 B는 pos라는 별도의 변수로 인덱스 탐색을 하게 한다
 * - 이어서 A와 B모두 내림차순 정렬 되어있기 때문에 만약 어떤 B가 A보다 작다면 그 B를 기준으로 그 뒤의 모든 수들은 다 A보다 작은 것이다.
 * - 따라서 그 크기만큼 ans에 더해주면 정답이 된다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Integer[] arr1 = new Integer[a];
            Integer[] arr2 = new Integer[b];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1, Collections.reverseOrder());
            Arrays.sort(arr2, Collections.reverseOrder());
            int ans = 0;
            int pos = 0;
            for (int j = 0; j < a; j++) {
                if(arr1[j] > arr2[pos]){
                    ans += b - pos;
                }else{
                    while(pos < arr2.length-1 && arr1[j] <= arr2[pos]){
                        pos++;
                    }
                    if(arr1[j] > arr2[pos]){
                        ans += b- pos;
                    }
                }
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }

}

