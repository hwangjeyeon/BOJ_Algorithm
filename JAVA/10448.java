import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 1부터 맨 위에 있는 Tn = n(n+1)/2 수식의 값을 배열에 저장해둔다
 * 2. 이때 최대 나올 수 있는 자연수는 1000이므로 1부터 44까지만 확인하면 된다 따라서 배열의 크기는 45이다
 * 3. 이어서 3중 포문으로 세 수를 더했을 때, n이랑 같으면 1을 출력하도록하고 아니면 0을 출력하도록 한다.
 *
 * 시간복잡도: O(1) -> 44^3...
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[45];
        for (int i = 1; i < 45; i++) {
            arr[i] = i * (i+1) / 2;
        }
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            boolean isOk = false;
            for (int j = 1; j < 45; j++) {
                for (int k = j; k < 45; k++) {
                    for (int l = k; l < 45; l++) {
                        if(arr[j] + arr[k] + arr[l] == input){
                            isOk = true;
                            break;
                        }
                    }
                }
            }

            if(isOk){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }

        br.close();
        bw.close();
    }

}

