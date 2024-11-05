import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 두번뽑는 경우 순회하여 탐색 -> k ~ 0 까지 셔플 -> 셔플로직 이렇게 3분류로 나눠서 해결하는 문제였다
 * 
 *
 * - 문제 해결:
 * 1. 딱 두번한다고 고정되어 있기 때문에 2중 포문을 통해 k를 두개 고르고 그에 따른 시뮬레이션을 돌리면 되는 문제다
 * 2. Math.pow(2, i) < n /  Math.pow(2, j) < n을 통해 간단하게 범위를 지정해서 탐색할 수 있다. 단 시작 값은 1이다
 * 3. 일단 초기 값을 가지고 있는 배열이 필요하다. 별도의 배열을 만들어서 입력받을 때, (i+1)을 넣어주자
 * 4. 해당 배열을 clone해서 임시 배열을 순회 돌릴때마다 생성하도록 한다
 * 5. solve 로직은 다음과 같다
 * 6. 문제에서 주어진대로 1부터 k+1만큼 순회를 돌면서 뒤에서 가져올 크기를 만든다. 크기는 Math.pow(2, k-i+1)이다
 * 7. swap을 위해서 리스트를 하나 선언한다. 이어서 전체 범위 - 뽑아올 크기만큼 순회를 돌면서 임시 리스트에 넣어준다. 이때 해당 배열은 0으로 처리한다
 * 8. 이어서 0부터 n까지 순회를 돌면서 0이 아니라면 임시 리스트에 값을 넣어주고, 그 다음 현재 위치에 리스트의 값을 넣어준다
 * 9. 위 swap 과정을 거치고 나서 뽑아온 크기를 범위로 재지정해준다
 * 10. 이후 다시 n만큼 순회를 돌면서 입력배열과 새로 만든 배열이 같은지 검사한다. 모두 같으면 isOk를 유지하며, isOk가 유지된 경우 정답 i와 j를 a와 b에 넣고 탈출한다
 * 11. 완성한 a와 b를 출력하면 정답이 된다.
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    static int[] arr;
    static int[] first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        first = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            first[i] = (i+1);
        }

        int a = 0;
        int b = 0;
        for (int i = 1; Math.pow(2, i) < n; i++) {
            for (int j = 1; Math.pow(2,j) < n; j++) {
                int[] test = first.clone();

                solve(i, test, n);
                solve(j, test, n);

                boolean isOk = true;

                for (int k = 0; k < n; k++) {
                    if(arr[k] != test[k]){
                        isOk = false;
                        break;
                    }
                }

                if(isOk){
                    a = i;
                    b = j;
                    break;
                }

            }
        }

        bw.write(a + " " + b);
        br.close();
        bw.close();
    }

    private static void solve(int k, int[] arr, int n){
        int range = n;
        int count = 0;

        for (int i = 1; i <= k + 1; i++) {
            count = (int)Math.pow(2, k-i+1);
            swap(range, count, arr, n);
            range = count;
        }
    }

    private static void swap(int range, int count, int[] arr, int n){
        List<Integer> tmp = new ArrayList<>();

        for (int i = range-count; i < range; i++) {
            tmp.add(arr[i]);
            arr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] != 0){
                tmp.add(arr[i]);
            }
            arr[i] = tmp.get(i);
        }

    }

}

