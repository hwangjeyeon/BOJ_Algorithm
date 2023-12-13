import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 도시에서의 비용과 그 다음 도시에서의 비용을 비교했을 때, 그 다음 도시에서의 비용이 더 싸면 그 도시까지의 누적 거리를 현재 도시의 비용으로 계산해서 requiredAccount에 넣는다
 * - 더 싼 도시에서의 비용을 기준으로 해서 위 과정을 반복한다.
 * - 최종 requiredAccount를 출력한다
 * - 이때 누적거리인 accumulateDistance와 requiredAccount는 long형으로 선언해주어야 서브태스크를 모두 통과할 수 있다
 * - 입력값들은 int형 범위 내이나, 최악의 경우 10억 단위의 숫자가 최대 도시 개수 100,000만큼 들어서면 누적거리와 필요 금액은 int형 범위를 벗어날 수 있기 때문이다.
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
        StringTokenizer st;
        List<Integer> distances = new ArrayList<>();
        List<Integer> oilPayment = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            distances.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            oilPayment.add(Integer.parseInt(st.nextToken()));
        }

        long requiredAccount = 0L;
        int nowAccount = oilPayment.get(0);
        long accumulateDistance = distances.get(0);
        for(int i=1; i<n-1; i++){
            if(nowAccount > oilPayment.get(i)){
                requiredAccount += nowAccount * accumulateDistance;
                nowAccount = oilPayment.get(i);
                accumulateDistance = 0;
            }
            accumulateDistance += distances.get(i);
        }
        requiredAccount += nowAccount * accumulateDistance;
        bw.write(requiredAccount + "");


        br.close();
        bw.close();
    }

}
