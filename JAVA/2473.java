import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 이전 두 용액 문제를 이용하여 해결하는 문제다. n이 5000으로 줄어들었다는 점을 잘 이용하자
 * 2. n^2으로 해결할 수 있다. 보통 처음에는 left와 right범위를 이분탐색하는 과정에서 단순탐색하든 이분탐색하든 중간값의 범위를 찾는데 이렇게 하면 범위가 좁아졌을 때, 원하는 위치의 중간값을 탐색하지 못한다
 * 3. 따라서 n-2까지 돌면서 left 값을 미리 하나 뽑아 두고, 이후 중간값과 right를 투포인터로 해결하면 된다. 
 * 4. 투포인터 해결과정은 두 용액과 동일하게 진행하면 된다
 * 5. 주의할점이 이전에는 long타입 범위에서 가능했지만 이번에는 long타입 범위 내에서 해결해야한다
 * 6. 따라서 합산과 관련된 값은 모두 long 타입으로 하자
 * 7. 한가지 더 주의해야할 점은, 배열도 int형이 아닌 long타입으로 해야한다는 것이다. 입력값 자체는 문제 없으나 합산하는 과정에서 오버플로우가 발생한다
 * 8. int형 타입을 유지하고 싶다면 합산 과정에 각각 1L을 곱해주면 된다
 * 9. 출력할 때는 각 지점에 대해서 리스트에 넣고 오름차순 해서 출력하면 정답이 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ansL = 0;
        int ansR = 0;
        int ansM = 0;
        long ans = 3000000000L;


        for (int i = 0; i < n - 2; i++) {
            int left = i+1;
            int right = n-1;

            while(left < right){
                long tmp = arr[left]*1L + arr[right]*1L + arr[i]*1L; // 이 과정에서 오버플로우 발생 가능하기 때문에, 아예 배열을 long타입으로 하거나 이렇게 1L을 각각 곱해주면 된다
                long dif = Math.abs(arr[left]*1L + arr[right]*1L + arr[i]*1L);

                if(ans > dif){
                    ans = dif;
                    ansL = left;
                    ansR = right;
                    ansM = i;
                }

                if(tmp < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        List<Integer> anss = new ArrayList<>();
        anss.add(ansL);
        anss.add(ansR);
        anss.add(ansM);
        Collections.sort(anss);


        bw.write(arr[anss.get(0)] + " " + arr[anss.get(1)] +  " " + arr[anss.get(2)] + "");

        br.close();
        bw.close();
    }
}
