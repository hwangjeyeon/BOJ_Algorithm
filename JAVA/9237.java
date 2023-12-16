import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정: 
 * - 제일 오래 걸리는 묘목을 먼저 심을 때 최소일수가 나오기 떄문에 리스트를 오름차순 정렬한다
 * - 가장 오래 걸리는 묘목 다음부터 차례대로 심는다고 했을 때, 가장 오래 걸리는 묘목 에서 각 묘목 심는데까지 걸린 날짜까지 걸린 시간을 각 묘목이 자라는데 걸리는 시간에서 빼준다
 * - 이때 가장 큰 값을 찾기 위해 다시 순회하고, 가장 오래 걸리는 묘목과 가장 큰 값을 더해준다
 * - 이 값에서 완전히 자란 날은 제외되고 포함되었기 때문에 일수를 하루 더 더하고, 그 다음날 이장님이 오기 때문에 다시 하루 더 더한다
 * - 그래서 +2한 일수만큼 해서 정답을 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> saplings = new ArrayList<>();
        for(int i=0; i<n; i++){
            saplings.add(Integer.parseInt(st.nextToken()));
        }

        saplings = saplings.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int maxDays = saplings.get(0);
        int ansDays = maxDays;
        for(int i=1; i<n; i++){
            maxDays--;
            saplings.set(i, saplings.get(i) - maxDays);
        }
        int tmp;
        if (saplings.size() >= 2) {
            tmp = saplings.get(1);
            for (int i = 2; i < n; i++) {
                if (tmp < saplings.get(i)) {
                    tmp = saplings.get(i);
                }
            }
            ansDays += tmp;
        }



        bw.write(ansDays+2 + "");


        br.close();
        bw.close();
    }

}
