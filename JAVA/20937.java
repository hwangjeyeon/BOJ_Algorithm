import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 내림차순이 아니라 오름차순으로 정렬 한뒤, 같은 것의 개수를 세는 것이 키포인트이다.
 * 2. 정렬 했을 때, 같은 수 내에서 중복되는 수만큼 떡국 탑의 개수가 생겨나므로, 해당 로직을 구현한다
 * 3. 이전값봐 비교해서 같으면 count++해주고 ans에 더 큰 값을 넣어준다
 * 4. 만약 그렇지 않으면 count = 1로 초기화해준다. 이렇게 할 수 있는 이유는 오름차순 정렬을 했기 떄문이다
 * 5. ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        Arrays.sort(arr);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]){
                count++;
                ans = Math.max(ans, count);
            }else{
                count = 1;
            }
        }


        bw.write(ans+"");
        br.close();
        bw.close();
    }



}

