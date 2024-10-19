import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문제 이해를 하면 쉬운 문제다
 * 2. 먼저 money를 기준으로 오름차순 정렬을 한다
 * 3. 이어서 pq에는 현재 i의 가격을 기준으로 현재부터 이후값들까지 동일한 가격을 했을 때, 배송료를 뺀 합을 money에 넣어주고 내림차순 정렬한다
 * 4. 만약 같다면 배열로 가서 그 위치에 있는 가격을 오름차순을 기준으로 정렬한다
 * 5. 맨 앞값을 하나 빼와서 그 값이 0보다 작거나 같다면 0을 출력하고 아니라면 그 위치의 가격을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */
class Pair{

    int money;
    int deli;

    public Pair(int money, int deli) {
        this.money = money;
        this.deli = deli;
    }
}


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int deli = Integer.parseInt(st.nextToken());
            pairs[i] =  new Pair(money, deli);
        }
        Arrays.sort(pairs, (o1, o2) ->{
            return o1.money - o2.money;
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if(o2.money == o1.money){
                return pairs[o1.deli].money - pairs[o2.deli].money;
            }
            return o2.money - o1.money;
        });

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += (Math.max(pairs[i].money - pairs[j].deli, 0));
            }
            pq.add(new Pair(sum, i));
        }

        Pair tmp = pq.poll();
        if(tmp.money <= 0){
            bw.write("0");
        }else{
            bw.write(pairs[tmp.deli].money+"");
        }


        br.close();
        bw.close();
    }
}

