

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 고객 명단을 처음에는 배열로 관리하고, 계산대에서 나가는 고객을 관리하는 우선순위 큐를 하나 두고 관리해야겠다고 생각했다
 * 2. 하지만 해당 문제는 고객이 들어오는 것도 신경 써야 하고, 나가는 것도 신경 써야하고 또한 경과 시간 관리도 해주어야 한다
 * 3. 따라서 우선순위 큐를 하나 더 사용해서 관리해야 한다.
 * 4. 문제 이해에 조금 시간이 걸렸는데 정렬은 하면 안된다. 차례대로 줄 서있기 떄문에 순서대로 넣어줘야 한다
 *
 *
 * - 문제 해결:
 * 1. 4번의 이유때문에 현재 줄서 있는 대기고객을 큐로 관리하였다
 * 2. 이떄 고객의 정보는 Member 클래스로 관리하였다
 * 3. 이제 우선순위 큐를 사용해서 계산대를 관리해야하는데 Member 클래스 만으로는 계산대 번호를 매기기 어렵다
 * 4. 따라서 Counter 클래스를 하나 더 만들었고 Member 클래스의 필드에 number 필드를 추가하였다
 * 5. 계산대를 관리하는 우선순위 큐는 가장 빨리 나오는 산 물건이 가장 적은 것이 먼저 나오도록 오름차순 정렬을 하는데, 만약 같으면 number를 기준으로 내림차순에서 더 큰 number가 나오도록 한다
 * 6. 일단 k개 만큼 멤버 큐에서 뽑아서 pq에 넣는다. 이때 n보다 k가 작을 수도 있기 때문에 해당 예외를 처리해준다
 * 7. 정답을 처리하기 까다로워서 그냥 따로 리스트로 빼서 관리하였다
 * 8. nowTime 변수를 0으로 초기화하고, 빠져나가서 비어있는 카운터를 관리해줄 qp 우선순위 큐를 하나 더 선언한다
 * 9. 이제 순회를 진행하는데 카운터를 관리하는 우선순위 큐가 비어있지 않은 동안 순회한다
 * 10. 일단 멤버 큐에 남아 있는 멤버가 있는동안 pq에서 값을 하나 뽑고 nowTime과 비교해서 더 큰 값을 넣어준다
 * 11. 정답 리스트에는 pq.id를 넣고 qp에는 pq.number를 넣어준다
 * 12. nowTime이랑 같은 값이 더 남아있을 수 있으므로 더 찾아서 빼준다
 * 13. 이어서 qp가 빌떄까지 비어있는 계산대에 새로운 멤버를 채워넣는다. 만약 채워넣는 도중 대기 멤버가 더이상 없으면 종료한다
 * 14. 새로운 맴버를 넣을 때는 멤버가 구매한 개수 + nowTime으로 넣도록 하여, 시간을 갱신하도록 한다
 * 15. 멤버 큐가 비어있어도 순회는 계속된다. 아직 계산대 큐에 멤버가 남아있을 수 있기 때문이다
 * 16. 해당 경우도 정답 리스트에 넣어주고 빌때까지 반복한다
 * 17. 이제 정답 리스트을 순회해서 각 값과 i+1을 곱해서 ans에 더해준다
 * 18. 이때 ans는 long타입이고 정답을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nk)
 * 공간복잡도: O(n)
 *
 */


class Member{
    int id;
    int buy;

    public Member(int id, int buy) {
        this.id = id;
        this.buy = buy;
    }
}

class Counter{
    int id;
    int buy;
    int number;

    public Counter(int id, int buy, int number) {
        this.id = id;
        this.buy = buy;
        this.number = number;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Member> members = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        PriorityQueue<Counter> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.buy == o2.buy){
                return o2.number - o1.number;
            }
            return o1.buy - o2.buy;
        });

        for (int i = 0; i < k; i++) {
            if(members.isEmpty()){
                break;
            }
            Member tmp = members.poll();
            pq.add(new Counter(tmp.id, tmp.buy, i+1));
        }

        long ans = 0;
        int nowTime = 0;
        List<Integer> answers = new ArrayList<>();
        PriorityQueue<Integer> qp = new PriorityQueue<>();

        while(!pq.isEmpty()){
            if(!members.isEmpty()){
                Counter exit = pq.poll();
                nowTime = Math.max(nowTime, exit.buy);
                qp.add(exit.number);
                answers.add(exit.id);
                while(!pq.isEmpty()){
                    if(pq.peek().buy == nowTime){
                        Counter tmp = pq.poll();
                        qp.add(tmp.number);
                        answers.add(tmp.id);
                        continue;
                    }

                    break;
                }

                while(!qp.isEmpty()){
                    if(members.isEmpty()){
                        break;
                    }
                    Member member = members.poll();
                    int next = qp.poll();
                    pq.add(new Counter(member.id, member.buy + nowTime, next));
                }
                continue;
            }
            if(pq.isEmpty()){
                break;
            }
            Counter tmp = pq.poll();
            answers.add(tmp.id);
        }

        for (int i = 0; i < n; i++) {
            ans += (long)answers.get(i) * (i+1);
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }
}

