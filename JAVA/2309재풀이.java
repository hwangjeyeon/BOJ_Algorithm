import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] arr = new Integer[9];
        int now = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            now += arr[i];
        }

        Arrays.sort(arr);
        boolean isFind = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(now -arr[i] - arr[j] == 100){
                    arr[i] = 0;
                    arr[j] = 0;
                    isFind = true;
                    break;
                }
            }
            if(isFind){
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                bw.write(arr[i] + "\n");
            }
        }

        br.close();
        bw.close();
    }

}

