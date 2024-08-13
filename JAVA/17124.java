import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이중포문이 가장 간단한 풀이지만 그렇게 하면 시간초과가 발생하기 때문에 다른 방법을 모색하였다
 * 2. 선택한 방법은 이분탐색이다. n을 순회하면서 m의 인덱스를 이분탐색해서 찾으면 시간복잡도 안에 문제를 해결할 수 있다
 * 3. 이분탐색을 위해 먼저 m을 오름차순 정렬해두었다
 *
 *
 * - 문제 해결:
 * 1. m의 범위를 이분탐색의 범위로 잡는다. left는 0, right m-1로 잡는다
 * 2. 이분탐색도중 n의 원소값과 정확히 같은 값이 있는 경우 그대로 종료해줘야하므로 체크를 위한 변수를 하나 선언한다
 * 3. left+1이 right보다 작은 동안 반복한다. 이것을 하는 이유는 1부터 정해진 범위까지 모든 수를 체크하는 것이 아닌 인덱스를 범위로 하기 때문이다
 * 4. 중간값을 구하고 arr2에서 그 인덱스의 값이 같다면 ans에 현재 arr1의 값을 더하고 체크한뒤 종료한다
 * 5. 만약 크다면 인덱스이므로 left에 현재 mid를 넣고 작다면 right에 현재 mid를 넣는다
 * 6. 이후 만약 발견하지 못했다면 현재 숫자에서 left위치의 값을 뺀값과 righ 위치의 값을 뺀 값의 절댓값을 비교해 같거나 left 위치의 값이 작다면 left를 더해주고 반대는 right를 더해준다
 * 7. ans는 long 타입으로 지정해야하며 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(T*n*logm)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            int[] arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            long ans = 0;

            Arrays.sort(arr2);
            for (int j = 0; j < n; j++) {
                int left = 0;
                int right = m-1;
                boolean isFind = false;
                while(left+1 < right){
                    int mid = (left + right) / 2;
                    if(arr1[j] == arr2[mid]){
                        isFind = true;
                        ans += arr1[j];
                        break;
                    }else if(arr1[j] > arr2[mid]){
                        left = mid;
                    }else if(arr1[j] < arr2[mid]){
                        right = mid;
                    }
                }

                if(!isFind){
                    if(Math.abs(arr1[j] - arr2[left]) <= Math.abs(arr1[j] - arr2[right])){
                        ans += arr2[left];
                    }else if(Math.abs(arr1[j] - arr2[left]) > Math.abs(arr1[j] - arr2[right])){
                        ans += arr2[right];
                    }
                }
            }




            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}

