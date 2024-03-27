import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 배열에 수들을 저장하고 오름차순 정렬을 한다
 * 2. 순회는 1부터 오름차순 정렬을 했고 최소한 3개의 수라고 했으니까 가장 큰 세 수를 곱한 것 안에서 다 결정이 난다
 * 3. 따라서 순회하면서 배열의 값을 확인해서 나누어 떨어지는 경우 count를 증가시키고 3개 이상이면 i를 출력하고 break로 탈출한다.
 *
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(100^3)
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
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr[4] * arr[3] * arr[2]; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if(i % arr[j] == 0){
                    count++;
                }
            }
            if(count >= 3){
                bw.write(i+"");
                break;
            }
        }

        br.close();
        bw.close();
    }

}

