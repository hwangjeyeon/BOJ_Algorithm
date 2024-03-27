import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 각 구간의 마지막 위치를 a,b,c,d로 두고 입력값이 작아 4중 포문을 통해 문제를 해결한다
 * 2. 각 구간의 시작은 이전 값의 다음으로 시작하므로, 모든 부분을 중복없이 순회할 수 있다.
 * 3. 각 순회 시작전에 다음 순회의 범위를 담을 변수를 1로 초기화해준다
 * 4. 각 순회마다 해당 수를 곱해서 담아준다. 
 * 5. 마지막 순회 마치가 난 후에는 기존 sum과 더 큰 값이 무엇인지 비교하여 담는다. 이때 각 완성된 a+b+c+d를 더한 값과 비교한다
 * 
 *
 *
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int a = 1;
        for (int i = 0; i <n-3; i++) {
            a *= arr[i];
            int b = 1;
            for (int j = i+1; j <n-2; j++) {
                b *= arr[j];
                int c = 1;
                for (int k = j+1; k < n-1; k++) {
                    c *= arr[k];
                    int d = 1;
                    for (int l = k+1; l < n; l++) {
                        d *= arr[l];
                    }
                    sum = Math.max(sum, a+b+c+d);
                }
            }
        }

        bw.write(sum+"");

        br.close();
        bw.close();
    }

}

