import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 문제를 제대로 이해 못해서 조금 많은 시도 끝에 정답을 찾았다
 * 2. 문제는 한번 인출하고 나서 그 돈을 가지고 하루 사용 금액과 비교하는 시스템이다
 * 3. 따라서 mid는 그 인출한 값이고, count는 1로 초기화한다
 * 4. 날짜별 금액과 비교하면서 sum에다가 더해준다. 만약 sum이 mid보다 크다면 sum은 arr[i]로 초기화하고 count++해준다. 재인출하는 것이고 arr[i]만큼 재인출한 금액에서 빼주는 것이다
 * 5. count와 m을 비교해서 count가 더 크면 left를 재설정하고 반대는 right를 재설정한다. count횟수가 많으면 한번에 인출하는 금액의 크기를 늘려야하고 아니면 줄여야하기 때문이다
 * 6. 이렇게 했을 때, 두 left와 right가 엇갈리게 되었을 때 left과 최소 금액이 된다.
 * 7. left를 정답으로 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left = 0;
        int right = 10000 * 100000;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
        }


        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if(sum > mid){
                    sum = arr[i];
                    count++;
                }
            }

            if(count > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        bw.write(left+"");

        br.close();
        bw.close();
    }

}

