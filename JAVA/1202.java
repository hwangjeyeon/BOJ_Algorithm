

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 각 보석의 정보를 관리할 클래스를 하나 만들고, 해당 클래스 배열을 만들어준다
 * 2. 가방도 일단은 배열에다가 가방별 무게를 관리한다.
 * 3. 각 가방에는 하나씩만 담을 수 있으므로, 해당 가방의 크기에서 담을 수 있는 보석들을 확인해야한다
 * 4. 만약 한개라면 그 보석만 담으면 되지만 여러개라면 그 중 가장 비싼 보석을 담는 것이 방법 일 수도 있다
 * 5. 하지만 이렇게 하면, 비싼 보석이 엄청 크기가 작아 다른 가방에도 담을 수 있는데 현재 가방에 담아서 그다음 보석을 다른 가방에 넣지 못할 수도 있다
 * 6. 반대의 경우도 똑같다. 가방을 단순히 내림차순, 오름차순으로 정렬해서는 풀리지 않는 문제다. 따라서 다른 방법을 모색해야한다.
 * 7. 그리디하게 뽑기 위해 최적의 경우를 한번 생각해보자. 
 * 8. 최적의 방법은 현재 가방의 무게를 오름차순 정렬을 해주고, 해당 가방에 들어갈 수 있는 보석의 무게를 추리는 것이다
 * 9. 그리고 그 보석들 중에서 가장 비싼 보석을 훔친다
 * 10. 가방을 오름차순 정렬해놓았기 때문에 가장 작은 가방부터 탐색한다
 * 11. 따라서 현재 가방에 들어갈 수 있는 보석이라면 이후 들어갈 가방에도 들어갈 것이고, 각 가방에 넣을 때마다 가장 비싼 보석을 그리디하게 훔치면 된다
 * 12. 이를 위해 우선순위 큐를 두개 놓고 풀었다. 첫번째 우선순위 큐는 보석들을 담고 있는데, 무게를 기준으로 오름차순하고 같으면 가격을 기준으로 내림차순한다
 * 13. 이어서 두번쨰 우선순위 큐는 현재 가방에 들어갈 수 있는 보석들을 관리한다. 해당 우선순위 큐에서는 가격만을 기준으로 내림차순 정렬을 해준다
 * 14. 이제 이중 포문으로 진행하는데 먼저 k개의 가방을 순회한다 
 * 15. 이제 start 변수를 활용해서 n만큼 순회하는데, 가방의 무게보다 작은 보석이면 qp에 넣고 만약 작지 않은 보석일 경우 그 지점을 그 다음에 다시 시작하도록 start에 기록해둔다
 * 16. 이렇게 하면 k*n이 아니라 k+n으로 시간복잡도 문제를 해결할 수 있다
 * 17. 내부 순회 탐색 도중 만약 pq가 빈다면 break하고 탈출하면 된다
 * 18. 이어서 qp가 비어있는지를 탐색한다. 만약 비어있다면 넣을 보석이 없으므로 continue한다
 * 19. 이어서 ans에 qp의 가격을 더해준다
 * 20. ans는 long타입으로 지정해주었다 입력값을 확인했을 때, 충분히 int형의 범위를 벗어난다
 * 21. 완성한 ans를 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n+k)
 * 공간복잡도: O(n)
 *
 */

class Jewelry{
    int weight;
    int price;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jewelry[] je = new Jewelry[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            je[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        long ans = 0;

        //전체 보석을 담고 있을 pq
        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1,o2) -> {
           if(o1.weight == o2.weight){
               return o2.price - o1.price;
           }
           return o1.weight - o2.weight;
        });

        // 가능한 보석을 담고 있을 qp
        PriorityQueue<Jewelry> qp = new PriorityQueue<>((o1,o2) -> {
            return o2.price - o1.price;
        });

        for (int i = 0; i < n; i++) {
            pq.add(je[i]);
        }

        int start = 0;
        for (int i = 0; i < k; i++) {
            for (int j = start; j < n; j++) {
                if(pq.isEmpty()){
                    break;
                }
                if(pq.peek().weight <= bag[i]){
                    qp.add(pq.poll());
                }else{
                    start = j;
                    break;
                }

            }

            if(qp.isEmpty()){
                continue;
            }
            ans += qp.poll().price;
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }
}

