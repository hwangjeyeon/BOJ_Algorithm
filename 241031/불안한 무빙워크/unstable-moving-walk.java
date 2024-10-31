import java.util.*;
import java.io.*;

/**
    1. 무빙워크는 배열로 관리하자. 상단과 하단을 따로 만들어서 관리한다
    4. 주어진 조건을 반복한다. 이때, 매 반복 처음에는 종료 조건을 확인한다
    5. 먼저 안정성이 0이 되는 경우가 있다면 개수를 세어준다. 그리고 그 개수가 반복 k개 이상일 때는 종료한다
    6. 그다음은 무빙워크를 회전한다
    7. 이어서 무빙워크에 올라간 사람을 이동시킨다. 자신의 앞에 사람이 있거나 안정성이 0이면 이동하지 않는다
    8. 7번은 역순으로 순회하며 조건을 진행한다. 이때 맨 뒤에 있는 사람은 없애준다
    9. 사람이 올라탔음을 나타내는 것은 방문 배열로 관리한다
    10. 사람이 올라탔을 때는 그 개수를 감소시킨다
    11. 이어서 1번칸을 확인한다. 사람이 없거나 안정성이 0이 아니라면 사람을 추가한다.
    12. 마지막에도 안정성이 0인 칸이 k개 이상인지 확인하고 맞다면 종료시킨다.
    13. 매 탐색마다 ans를 증가시킨다. 이후 종료후에는 ans를 출력한다.
*/


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[2*n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 무빙워크는 배열로 관리하자. 상단과 하단을 따로 만들어서 관리하자
        
        int[] moving = new int[n];  // 상단
        int[] lowMoving = new int[n]; // 하단
        for(int i=0; i<n; i++){
            moving[i] = arr[i];
            lowMoving[i] = arr[i+n];
        }
        boolean[] visited = new boolean[n]; // 상단 사람 체크
        int ans = 0;
        int count = 0;

        // 주어진 조건을 반복한다
        while(true){
            ans++;

            

            // 상단 회전
            int last = lowMoving[0];
            boolean lastMan = visited[0];
            visited[0] = false;
            for(int i=0; i<n; i++){
                int tmp = moving[i];
                moving[i] = last;
                last = tmp;
                if(i>0){
                    boolean tmps = visited[i];
                    visited[i] = lastMan;
                    lastMan = tmps;
                }
            }

            // 하단 회전
            for(int i=n-1; i>=0; i--){
                int tmp = lowMoving[i];
                lowMoving[i] = last;
                last = tmp;
            }
            
            

            // 상단 역순 탐색, n번째에 있는 사람은 삭제, 그 외에는 옆칸 조건을 만족하면 이동
            if(visited[n-1]){
                visited[n-1] = false;
            }

            

            for(int i=n-2; i>=0; i--){
                if(visited[i] && !visited[i+1] && moving[i+1] > 0){
                    visited[i+1] = true;
                    visited[i] = false;
                    moving[i+1]--;
                    if(moving[i+1] <= 0){
                        count++;
                    }
                }
            }

            // for(int i=0; i<n; i++){
            //     System.out.print(moving[i]+" ");
            // }
            // System.out.println();

            // for(int i=0; i<n; i++){
            //     System.out.print(lowMoving[i] + " ");
            // }
            // System.out.println();
            
            if(visited[n-1]){
                visited[n-1] = false;
            }

            if(!visited[0] && moving[0] > 0){
                visited[0] = true;
                moving[0]--;
                if(moving[0] <= 0){
                    count++;
                }
            }

            // for(int i=0; i<n; i++){
            //     System.out.println(visited[i]);
            // }
            

            if(count >= k){
                break;
            }

            
            
        }

        

        System.out.print(ans);
    }
}