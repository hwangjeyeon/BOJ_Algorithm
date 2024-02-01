import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 슬라이딩 윈도우와 누적합 알고리즘을 이용하여 해결하였습니다.
 * - 먼저 배열을 저장하는데 누적합 알고리즘을 이용하여 배열을 누적합 배열로 만들어준다
 * - sum에는 arr[x-1]로 주어진 구간 만큼의 합이 필요하니까 누적합 배열을 이용하여 해당 구간 인덱스 값을 저장한다
 * - sum과 비교하기 위해 한칸 옮겼을 때의 값을 sum1에 저장한다
 * - sum1에는 arr[x+i] - arr[i]로 맨 왼쪽에 있던 값은 빼주고 오른쪽에 추가되는 값은 더해준다
 * - 같으면 count값을 올려준다. 이때 count는 1로 초기화하는데 비교하는 자신이 count가 안되는 문제를 해결하기 위해서이다
 * - 만약 sum1이 sum보다 크면 값을 교체하고 count는 더 큰값을 발견했으니 1로 초기화한다. 1은 자기자신이다.
 * - 이렇게 완성한 값을 출력하는데 만약 sum이 0이면 SAD를 출력하고 아니면 sum과 count를 차례대로 출력한다.
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
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!=0){
                arr[i] += arr[i-1];
            }
        }

        int sum = arr[x-1];
        int count = 1;
        for (int i = 0; i < n-x; i++) {
            int sum1 = arr[x + i] - arr[i];
            if(sum1 == sum){
                count++;
            }
            if(sum1 > sum){
                sum = sum1;
                count = 1;
            }
        }

        if(sum == 0){
            bw.write("SAD");
        }else{
            bw.write(sum+"\n"+count);
        }


        br.close();
        bw.close();
    }
}
