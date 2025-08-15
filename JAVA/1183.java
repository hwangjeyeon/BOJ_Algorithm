import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. a-b 시간을 구해서 배열에 넣어주고 오름차순 정렬한다
 * 2. 중간값만큼 약속시간을 이동해야 기다리는 시간의 합이 최소가 되는데 정렬을 해야지 가운데 값을 쉽게 할 수 있기 때문이다
 * 3. n이 홀수면 중간값은 하나이므로 1을 출력하고 짝수라면 중간값은 n/2 부터 n/2-1까지이기 때문에 둘을 뺀 절댓값 + 1이 정답이 된다
 *
 * 해결방법:
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(n%2 == 1){
            bw.write("1");
        }else{
            bw.write((Math.abs(arr[n/2] - arr[n/2-1])+1) +"");
        }
        
        br.close();
        bw.close();
    }

}
