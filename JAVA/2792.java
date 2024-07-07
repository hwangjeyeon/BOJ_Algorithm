import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 보석의 개수를 이분탐색하는 문제다. left를 1로 두고 right를 가장 많은 색의 보석 개수로 둔다.
 * 2. left<=right인 동안 탐색을한다. 그 중간값을 찾고, 중간값으로 각 원소를 나눴을 때의 몫은 sum에 더한다
 * 3. 만약 각 원소를 중간값으로 나눴을 때 나머지가 0이 아니라면 중간값보다 더 많은 보석을 가지고 있는 것이므로 sum++해준다
 * 4. 이제 sum을 비교한다. 만약 n보다 크다면 더 작게 나눠서 적은 사람에게 나눠줘야하므로 left를 재설정한다
 * 5. 만약 n보다 작거나 같다면 최소값을 찾아야하므로 right의 범위를 축소하고 ans에 해당 right를 넣어준다
 * 6. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(logm)
 * 공간복잡도: O(m)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int left = 1;
        int right = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += arr[i] / mid;
                if(arr[i] % mid != 0){
                    sum++;
                }
            }

            if(sum > n){
                left = mid +1;
            }else{
                right = mid - 1;
                ans = mid;
            }

        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

