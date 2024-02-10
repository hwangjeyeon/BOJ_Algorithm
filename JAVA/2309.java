import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 탐색 범위가 작아서 이중 포문으로 완전탐색했다. 
 * - 100인 경우 그 인덱스에 해당하는 값을 0으로 바꿔주고 break해서 탈출한다
 * - 이어서도 미리 설치해둔 boolean 변수로 break해서 탈출한다
 * - 이후 0인 값은 제외하고 배열의 모든 수를 출력하면 정답이 된다.
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
        int[] arr = new int[9];
        int height = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            height += arr[i];
        }
        Arrays.sort(arr);
        boolean isOk = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i == j){
                    continue;
                }
                if(height - arr[i] - arr[j] == 100){
                    arr[i] = 0;
                    arr[j] = 0;
                    isOk = true;
                    break;
                }
            }
            if(isOk){
                break;
            }
        }

        for (int i : arr) {
            if(i == 0){
                continue;
            }
            bw.write(i+"\n");
        }


        br.close();
        bw.close();
    }


}

