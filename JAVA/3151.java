import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 세용액 문제에서 사용했던 방식을 이용해서 문제를 해결할 수 있다
 * 2. 맨 왼쪽부터 탐색하면서 하나를 고정시켜두고 그다음부터 양 끝에 투포인터를 두고 합이 0이되는 지점을 찾아가면 된다
 * 3. 0보다 크면 양수가 크기 떄문이므로, right를 줄이고 그 이외에는 left를 증가시킨다
 * 4. 만약 0이라면 몇가지 경우를 더 생각해야 한다.
 * 5. 만약 left와 right 지점의 값이 같다면 두 포인터의 인덱스 길이 차이를 구하고, 팀원의 배치를 할 수 있는 모든 조합을 구하기 위해, a*(a-1)/2로 구한다. 그리고 현재 포인터에서의 탐색을 탈출한다
 * 6. 만약 같지 않다면 left지점과 right지점의 다음 / 이전 값을 비교하여 같은지 확인한다
 * 7. 만약 같아 연속된다면 left와 right를 같지 않을 때까지 반복하며, 그 개수를 세어준다. 초기값은 1이다
 * 8. 이후, 같은 개수만큼 팀이 나올 수 있으므로 곱해서 ans에 합한다
 * 9. ans는 long타입으로 지정해야지 오버플로우가 발생하지 않고, 완성한 결과를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n*logn)
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

        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 ){
                break;
            }
            int left = i+1;
            int right = n - 1;
            while (left < right){
               int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    int l = 1;
                    int r = 1;
                    if(arr[left] == arr[right]){
                        int a = right - left + 1;
                        ans += (long) a * (a - 1) / 2;
                        break;
                    }

                    while(arr[left] == arr[left+1]){
                        l++;
                        left++;
                    }

                    while(arr[right] == arr[right-1]){
                        r++;
                        right--;
                    }
                    ans += (long) l * r;

                }

                if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        bw.write(ans +"");

        br.close();
        bw.close();
    }

}
