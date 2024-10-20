import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 값들을 배열에 저장한다. 왼쪽과 오른쪽을 각각 순회하며, 이전값보다 큰 값이 있으면 카운트를 증가시키고 갱신한다
 * 2. 왼쪽은 증가순회, 오른쪽은 감소 순회다. 
 * 3. 완성한 카운트들을 출력하면 정답이 된다. 
 *
 * - 문제 해결:
 *
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int right = arr[n-1];
        int left = arr[0];

        int count1 = 1;
        int count2 = 1;
        for (int i = 1; i < n; i++) {
            if(left < arr[i]) {
                count1++;
                left = arr[i];
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if(right < arr[i]){
                count2++;
                right = arr[i];
            }
        }

        bw.write(count1+ "\n" + count2);

        br.close();
        bw.close();
    }
}

