import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 투포인터를 이용해서 양끝에 포인터를 두고 줄여가는 방식으로 풀었다
 * 2. 먼저 각 수의 합을 지역변수 sum에 저장한다
 * 3. 이후 sum의 절댓값과 ans를 비교해서 ans가 더 크면 ans에 sum의 절댓값을 넣어준다
 * 4. 그리고 a와 b에 front와 end를 넣어준다
 * 5. 이어서 sum을 체크하는데 0보다 크면 오른쪽에 있는 값이 더 크니까 조금 줄여서 0에 가까워지도록 해야하므로 end--한다
 * 6. 반대로 0보다 작으면 왼쪽에 있는 값이 더 작으니까 조금 늘려서 0에 가까워지도록 해야하므로 start++해야한다.
 *
 *
 * 문제 해결:
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = 0;
        int end = arr.length-1;


        int a = 0;
        int b = 0;
        int ans = Integer.MAX_VALUE;
        while(front < end){
            int sum = arr[front] + arr[end];
            if(ans > Math.abs(sum)){
                ans = Math.abs(sum);
                a = front; b = end;
            }
            if(sum >= 0){
                end--;
            }else{
                front++;
            }
        }

        bw.write(arr[a]+" " + arr[b]);

        br.close();
        bw.close();
    }

}
