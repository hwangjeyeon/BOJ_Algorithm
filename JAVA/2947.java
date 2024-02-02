import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 주석으로 처리한 부분은 순수하게 풀어서 정답으로 낸 부분이고, 두번째는 힌트를 참고해서 최적화한 풀이이다.
 * - 순회하면서 현재 인덱스의 값이 다음 인덱스의 값보다 큰 경우 스왑해주고 배열 크기만큼 순회해서 전부 출력하면 된다.
 * - 이때 orderCheck라는 flag 역할을 하는 boolean 변수를 하나 선언해서 바뀔 떄는 false 안 바뀔 때는 true를 유지하게한다
 * - 만약 true일 경우 while문을 탈출하면된다.
 * - 내가 처음 푼 풀이에서는 while문을 사용하지 않았고, 마지막 순회인 i==3일 때, 다시한번 처음부터 다 순회해서 만약 현재 인덱스의 값이 인덱스+1과 같지 않으면 false로 선언한다
 * - 이어서 false가 있는 경우 i=-1로 초기화해서 처음부터 다시 순회하도록 하고, orderCheck도 true로 다시 초기화해준다.
 * - 더 깔끔한 코드는 역시 힌트를 참고한 코드인 것 같다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //더나은 풀이
        while(true){
            boolean orderCheck = true;
            for (int i = 0; i < 4; i++) {
                if(arr[i] > arr[i+1]){
                    orderCheck = false;
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    for (int j = 0; j < 5; j++) {
                        bw.write(arr[j] + " ");
                    }
                    bw.write("\n");
                }
            }
            if(orderCheck){
                break;
            }
        }




        //처음 풀이
        /*
        boolean orderCheck = true;
        for (int i = 0; i < 4; i++) {
            if(arr[i] > arr[i+1]){
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
                for (int j = 0; j < 5; j++) {
                    bw.write(arr[j] + " ");
                }
                bw.write("\n");
            }
            if(i==3){
                for (int j = 0; j < 5; j++) {
                    if(arr[j] != j+1){
                        orderCheck = false;
                    }
                }
            }
            if(!orderCheck){
                i = -1;
                orderCheck = true;
            }
        }*/



        br.close();
        bw.close();
    }
}
