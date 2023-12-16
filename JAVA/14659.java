import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 리스트와 Map을 사용해서 풀었다
 * - 리스트를 순회하여 현재의 값이 오른쪽 값보다 크면 count변수의 값을 증가시키고 map에 업데이트한다
 * - 만약 작다면(같은 경우는 없음) count변수의 값을 map에 업데이트하고 count를 0으로 초기화한 뒤에, 비교하는 대상을 큰 값으로 바꿔주고 반복한다
 * - 최종적으로 Collections.max()를 통해 Map에서 가장 큰 값을 출력한다.
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

        List<Integer> peaks = new ArrayList<>();
        Map<Integer, Integer> killCount = new HashMap<>();
        for(int i=0; i<n; i++){
            peaks.add(Integer.parseInt(st.nextToken()));
            killCount.put(peaks.get(i), 0);
        }

        int count = 0;
        int who = peaks.get(0);
        for(int i=1; i<n; i++){
            if(peaks.get(i) < who){
                count++;
                killCount.put(who,count);
            }else{
                killCount.put(who,count);
                count = 0;
                who = peaks.get(i);
            }
        }


        bw.write(Collections.max(killCount.values())+"");


        br.close();
        bw.close();
    }

}
