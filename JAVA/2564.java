import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 깡구현 문제인데, 분기를 많이 생각해야한다
 * 2. if랑 switch만 사용해서 풀면 꼭 생각치 못한 분기가 나온다.
 * 3. 그래서 새로운 아이디어로 문제를 해결하였다
 * 4. 0,0 지점을 기준으로 시계방향으로 돈다고 했을 때, 그만큼의 거리로 좌표를 변환하여 생각하기로 하였다
 * 5. 맨 윗줄은 x값 그대로, 우측줄은 width + x, 아랫줄은 width + height + (width - x), 좌측줄은 width*2 + height + (height -x)로 좌표를 거리로 바꿔준다
 * 6. 이제 두가지 경우만 생각하면 된다. 동근이와 건물 거리간의 차이와 전체 길이에서 동근이와 건물간의 차이를 뺀 경우만 생각하면 된다
 * 7. 두가지 경우중 더 작은 값은 더하고 완성한 ans를 출력하면 정답이 된다
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            switch (y){
                case 1:
                    arr[i] = x;
                    break;
                case 4:
                    arr[i] = width + x;
                    break;
                case 2:
                    arr[i] = width + height + (width - x);
                    break;
                case 3:
                    arr[i] = 2*width + height + (height - x);
                    break;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = Math.abs(arr[n] - arr[i]);
            ans += Math.min(sum, (width + height)*2 - sum);
        }

        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

}

