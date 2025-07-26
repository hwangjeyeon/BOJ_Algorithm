import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 우선순위 큐를 사용해서 해결하면 됩니다
 * 2. 먼저 끝내야할 일을 처리하기 위해 끝나는 시간을 기준으로 우선순위 큐를 오름차순 정렬합니다
 * 3. 총 업무 시간을 누적해서 더하고, 현재 업무를 끝내야하는 시간에서 총 업무시간을 뺀 값중 최솟값을 찾습니다
 * 4. 현재 업무를 끝내야하는 시간에서 총 업무시간을 빼면 업무를 시작해야하는 시간을 알 수 있고 그중에서 최솟값을 찾아주면 됩니다
 * 5. 만약 총 업무 시간이 현재 업무를 끝내야하는 시간보다 크다면 제시간에 끝낼 수 없으므로 -1을 출력하고 아니면 최솟값을 출력할 때 정답이 됩니다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Pair{
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq  = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Pair(start, end));
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean isOk = true;
        while(!pq.isEmpty()){
            Pair now = pq.poll();
            sum += now.start;
            min = Math.min(min, now.end - sum);
            if(sum > now.end){
                isOk = false;
                break;
            }
        }

        if(!isOk){
            bw.write("-1");
        }else{
            bw.write(min+"");
        }


        br.close();
        bw.close();
    }
}
