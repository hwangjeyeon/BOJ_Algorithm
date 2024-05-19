import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 내림차순으로 정렬한 뒤, 3개씩 묶어서 가장 작은 값을 뺴주면 된다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(i%3 == 2){
                continue;
            }
            ans += arr[i];
        }
        bw.write(ans+"");



        br.close();
        bw.close();
    }



}

