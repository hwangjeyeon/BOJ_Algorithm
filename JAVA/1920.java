import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 배열의 범위는 int 형으로 해줘도 오버플로우가 발생하지 않는다. 2^-31 ~ 2^31 -1 까지 괜찮다
 * 2. 이중 포문을 사용하기에는 시간초과 위험이 있어서 이분 탐색으로 처리하였다.
 * 3. 시작은 0, 끝은 n-1로 하고 중간값을 좌표로하는 arr의값과 input 값을 비교하여 탐색한다
 * 4. 있으면 1을 출력하고 없으면 0을 출력하도록 하면 정답이 된다.
 *
 * - 문제 해결:
 * 1. 처음에는 좌표에 있는 값으로 하고 했는데 틀렸다고 했다.
 * 2. 그래서 이전풀이를 참고해보니 인덱스로 비교하고 있었다.
 * 3. 왜 이런 차이가 발생하는지는 이후 이분탐색 학습 때 체득할 계획이다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n-1;
            boolean isOk = false;
            while(left <= right){
                int mid = (left + right) / 2;
                if(input == arr[mid]){
                    bw.write("1"+"\n");
                    isOk = true;
                    break;
                }else if(input > arr[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(!isOk){
                bw.write("0"+"\n");
            }
        }

        br.close();
        bw.close();
    }

}

