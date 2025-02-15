import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 주어진대로 구현하면 되는 문제다.
 * 2. 컨베이어 벨트 회전 -> 로봇 이동 -> 첫칸에 로봇 업로드 -> 내구도 0인칸 확인 및 k이상인지 검증 순서로 로직을 구현하면 된다
 * 3. 로봇의 위치는 중복되지 않으므로 방문배열로 관리한다
 * 4. 컨베이어 벨트가 회전할때와 로봇이 이동할 때 방문배열도 수정해야한다. 이때, 로봇이 있는 위치만 수정하자
 * 5. 각 시뮬레이션의 처음에 ans를 증가시키며, 종료후에는 ans를 출력하면 정답이 된다. 
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*k)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int n;
    static int k;
    static int[] arr;
    static int ans = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[2*n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        while(true){
            ans++;
            rotateRobot();
            moveRobot();
            uploadRobot();
            int count = 0;
            for (int i = 0; i < 2 * n; i++) {
                if(arr[i] == 0){
                    count++;
                }
            }
            if(count >= k){
                break;
            }
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void uploadRobot() {
        if(arr[0] > 0 && !visited[0]){
            visited[0] = true;
            arr[0]--;
        }
    }

    private static void moveRobot() {
        for (int i = n-2; i >= 0; i--) {
            if(visited[i] && arr[i+1] > 0 && !visited[i+1]){
                if(i+1 == n-1){
                    visited[i+1] = false;
                }else if (i+1 < n-1){
                    visited[i+1] = true;
                }
                arr[i+1]--;
                visited[i] = false;
            }
        }
    }

    private static void rotateRobot() {
        int tmp = arr[2*n-1];
        for (int i = 2*n-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = tmp;
        for (int i = n-2; i >= 0; i--) {
            if(!visited[i]){
                continue;
            }
            if(i + 1 < n-1){
                visited[i] = false;
                visited[i+1] = true;
            }
            if(i+1 == n-1){
                visited[i] = false;
                visited[i + 1] = false;
            }
        }
    }
}
