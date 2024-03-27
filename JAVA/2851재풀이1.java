import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에 100을 넘으면 안되는 선에서 100에 가깝게 만드는줄 알았는데 그것이 아니다 그냥 넘든 말든 100에 가깝게만 하면된다
 * 2. 누적합으로 0이 아닌 경우에는 이전 값을 현재 배열에 더해준다
 * 3. 이제 비교하면서 100에서 sum값을 뺀값이 100에서 현재 배열의 값을 뺀 경우보다 크거나 같으면 sum에 현재 배열을 넣는다
 * 4. 이렇게 하면 더 큰값을 선택하게 되므로 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(i!=0){
                arr[i] += arr[i-1];
            }

            if(Math.abs(100 - sum) >= Math.abs(100 - arr[i])){
                sum = arr[i];
            }
        }


        bw.write(sum+"");
        br.close();
        bw.close();
    }

}

