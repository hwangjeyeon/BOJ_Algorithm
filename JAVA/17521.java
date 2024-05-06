import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 사는시점과 파는 시점을 결정해야한다
 * 2. 사는 시점은 이전 값이 현재 값보다 크고, 다음 값이 현재 값보다 클 때이다.
 * 3. 파는 시점은 이전 값이 현재 보다 작고 다음 값이 현재보다 작을 때이다.
 * 
 * 해결방법:
 * 1. 사는시점을 다시 생각하자. 현재 코인의 개수가 0일 때 구매해야한다. 또한 현재 값이 다음 값보다 작으면 코인을 구매하자!
 * 2. 파는 시점은 현재 가격이 다음 가격보다 큰 경우에 팔면 된다
 * 3. 마지막은 따로 처리한다. 순회 종료 이후에 모든 코인의 개수만큼 종료 시점에 다 팔아서 w에 더해주고 출력하면 정답이 된다.
 * 
 * - 더 그리디하게 생각하자. 이전 값까지 생각하고, 사는 시점의 경우를 그리디하게 생각하지 못해서 힌트를 참고한 문제다.
 * - 추가적으로 힌트에서 나온 것처럼 long형으로 w와 coin을 지정해야한다.  
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
        long w = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long coin = 0;
        for (int i = 0; i < n - 1; i++) {
            if(coin == 0 && arr[i] < arr[i+1]){
                coin = w / arr[i];
                w -= coin * arr[i];
            }

            if(arr[i] > arr[i+1]){
                w += coin * arr[i];
                coin = 0;
            }

        }

        w += coin * arr[n-1];

        bw.write(w+"");

        br.close();
        bw.close();
    }
}

