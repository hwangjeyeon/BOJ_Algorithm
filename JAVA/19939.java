import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. N/K가 1이하면, -1을 출력한다
 * 2. N/K가 2이상이면 N/K+N%K
 *
 *
 * - 문제 해결:
 * 1. 최소의 경우가 나오는 경우는 일단 등차수열꼴로 되어있는 경우이다
 * 2. 즉 팀 1부터 k까지 1~k까지의 수로 되어 있는 경우가 최소의 경우이며, 만약 현재 공의 개수가 그 합보다 작으면 -1을 출력한다
 * 3. 만약 넘거나 같을 경우 ans를 k-1로 설정해준다. k와 1과의 차이이다
 * 4. 이어서 n%k가 0인지 확인하고 만약 아니면 큰수부터 차례대로 공을 하나씩 더 추가하는데 1번째는 추가하지 않는 것이므로 ans++을 해주고 출력한다
 * 
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += (i+1);
        }

        if(n < sum){
            bw.write("-1");
        }else{
            int ans = k-1;
            n -= sum;
            if(n%k != 0){
                ans++;
            }
            bw.write(ans+"");
        }


        br.close();
        bw.close();
    }

}

