import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이전 일곱난쟁이 문제랑 비슷한 방식이다
 * 2. 입력받을 때 각 키를 합해서 sum 변수에 저장한다
 * 3. 이중포문으로 sum에서 두 수를 뺐을 때, 100이면 해당 배열 값을 0으로 바꿔준다
 * 4. 이제 iteration을 돌아서 0이 아닌경우만 출력하도록 한다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if(100 == sum - arr[i] - arr[j]){
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
            if(arr[i] == 0){
                break;
            }
        }


        for(int a : arr){
            if(a != 0){
                bw.write(a+"\n");
            }
        }



        br.close();
        bw.close();
    }

}

