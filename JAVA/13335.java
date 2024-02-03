import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 다리 하나만을 큐로 하고 풀었을 때 틀렸었다.
 * - 하지만 이어서 힌트를 참고해서 트럭도 큐로 저장해두고, 길이와 다리의 하중 비교를 분리해서 비교했더니 풀렸다.
 * - 다리의 무게를 담고 있는 큐가 빌때까지 순회한다.
 * - 순회당 시간 1로 잡고 순회를 종료시키기 위해 현재 전체 다리의 무게를 큐에서 poll해온다
 * - 이어서 트럭 무게를 담고 있는 큐가 비지 않았다면 현재 트럭 큐의 맨 앞에 있는 값에다가 전체 무게를 더한 값이 상한선 무게보다 작거나 같은지 확인한다
 * - 만약 작거나 같다면 전체 무게에 그 트럭의 무게를 더해주고 다리에 트럭의 무게를 추가한다. 이 때 다리에 트럭의 무게를 추가할 때는 트럭의 큐에서 poll한다
 * - 만약 그렇지 않다면 순회를 진행하기 위해 0을 다리의 큐에 더해준다. 이렇게 하면 해당 무게가 빠지기 전까지 즉 poll하기 전까지 시간을 진행시킬 수 있다.
 * - 이렇게 완성한 시간을 출력하면 정답이 된다
 *
 * 참고 힌트: https://www.acmicpc.net/problem/13335
 * - 더 노력이 필요하다... 더 머리를 싸맸으면 풀 수 있었을 것 같은데, 시간의 압박때문에 결국 힌트를 참고하게되었다.
 * - 그래도 한가지 알게 된점은 너무 간단하게 큐 하나를 쓰지 말고 두개를 쓰는 방법도 있다는 것을 알게되었다
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
        // 트럭의 수
        int n = Integer.parseInt(st.nextToken());
        // 다리의 길이
        int w = Integer.parseInt(st.nextToken());
        // 다리의 최대하중
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        int bridgeWeight = 0;
        int nowTime = 0;
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while(!bridge.isEmpty()){
            nowTime++;
            bridgeWeight -= bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek() + bridgeWeight <= k){
                    bridgeWeight += truck.peek();
                    bridge.add(truck.poll());
                }else{
                    bridge.add(0);
                }
            }
        }

        bw.write(String.valueOf(nowTime));

        br.close();
        bw.close();
    }
}
