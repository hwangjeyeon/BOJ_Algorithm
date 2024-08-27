import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 최초 등록된 시간과 횟수를 별도의 배열로 관리하고, 우선순위 큐 정렬을 배열로 해주면 된다
 * 2. 이후 탐색에서는 우선순위 큐에 입력 후보 숫자가 있는지 없는지 파악하고, 없다면 현재 인덱스로 초기화, 그리고 크기가 n이면 0으로 poll한 인덱스의 횟수를 0으로 초기화한다
 * 3. 이어서 num을 우선순위 큐에 넣어준다. 참고로 이 분기 전에 해당 num의 추천횟수를 증가시킨다
 * 4. 만약 후보가 우선순위 큐에 있다면 최신 값으로 갱신을 위해 (재정렬하기 위함) remove로 지우고 다시 add한다
 * 5. 이후 리스트에 담아서 오름차순 정렬한뒤 출력하면 정답이 된다.
 * 
 * - 문제 해결:
 * 
 *
 * 시간복잡도: O(k * 20)
 * 공간복잡도: O(101)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[101];
        int[] counts = new int[101];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(counts[o1] == counts[o2]){
                return time[o1] - time[o2];
            }
            return counts[o1] - counts[o2];
        });

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            counts[num]++;
            if(!pq.contains(num)){
                time[num] = i;
                if(pq.size() == n){
                    counts[pq.poll()] = 0;
                }
                pq.add(num);
            }else{
                pq.remove(num);
                pq.add(num);
            }
        }

        List<Integer> list = new ArrayList<>(pq);
        Collections.sort(list);
        for (Integer i : list) {
            bw.write(i + " ");
        }

        br.close();
        bw.close();
    }
}

