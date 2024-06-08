import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 각 층을 오름차순으로 정렬한다.
 * 2. 각 층에서 -1이면 그 수를 item 배열에 더해준다
 * 3. 0부터는 현재 전투력과 비교를 한다. 만약 작거나 같으면 전투력에 더한다음 다음으로 넘어간다
 * 4. 만약 크다면 item을 감소시키고 현재 전투력을 두배로 바꾸고 다시 비교한다.
 * 5. 4번을 item이 0보다 큰동안 반복하고, 작거나 같아진다면 다음으로 넘어간다.
 * 6. 만약 그대로 크다면 win을 false로 하고 탈출하고 0을 출력한다
 * 7. 최종까지 다 넘어가면 win이 true이므로 1을 출력한다.
 * 8. 이때 전투력은 long타입에 보관해둔다.
 * 
 *
 * 해결방법:
 * 1. 한가지 주의할 점은 마지막에 아이템을 모두 사용하고 다음 층으로 가야한다
 * 2. 한 층이 모두 아이템으로 둘러싸인 경우를 생각해보면 간단히 왜 그렇게 해야하는지 나온다.
 *
 * 시간복잡도: O(n*m*item)
 * 공간복잡도: O(m)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long power = Long.parseLong(st.nextToken());
        int[] arr = new int[m];
        boolean win = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            if(!win){
                continue;
            }
            Arrays.sort(arr);
            int item = 0;
            for (int j = 0; j < m; j++) {
                if(arr[j] == -1){
                    item++;
                    continue;
                }
                if(arr[j] <= power){
                    power += arr[j];
                    continue;
                }
                while(item > 0){
                    power *= 2;
                    item--;
                    if(arr[j] <= power){
                        break;
                    }
                }

                if(arr[j] > power){
                    win = false;
                    break;
                }
                power += arr[j];
            }
            for (int j = 0; j < item; j++) {
                power *= 2;
            }
        }

        if(win){
            bw.write("1");
        }else{
            bw.write("0");
        }
        
        br.close();
        bw.close();
    }



}

