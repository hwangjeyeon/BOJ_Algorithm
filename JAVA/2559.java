import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 슬라이딩 윈도우 알고리즘을 이용하여 풀었습니다
 * - 각 배열에는 0일때를 제외하고 이전 값을 누적하여 합해놓는다
 * - start는 0 end는 k로 범위를 지정해놓는다
 * - sum에는 arr[k-1]로 초기값을 지정한다
 * - 이제 end가 n보다 작은 동안 순회하는데 arr[end] - arr[start]과 sum중 더 큰 값을 sum에 저장한다
 * - 이어서 end와 start를 각각 1씩 증가시킨다
 * - 이렇게 완성한 sum을 출력하면 정답이 된다.
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
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!=0){
                arr[i] += arr[i-1];
            }
        }

        int start = 0;
        int end = k;
        int sum = arr[k-1];
        while(end < n){
            int tmp = arr[end] - arr[start];
            sum = Math.max(tmp, sum);
            end++;
            start++;
        }

        bw.write(sum+"");
        br.close();
        bw.close();
    }

}

