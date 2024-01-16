import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 최대 입력값과 시간제한을 확인했을 때, 이분탐색과 매개변수탐색 개념을 이용하여 푸는 문제이다
 * - 랜선자르기와 유사한 문제이다
 * - 입력받은 예산 리스트 중에서 최대값을 구한다.
 * - 최소값은 1로하고, min <= right인 동안 탐색을 진행한다
 * - mid값을 구한 뒤, 각 리스트 값을 budget이라는 임시 long 변수에 더한다
 * - 이때 mid보다 크거나 같은 경우 mid를 더한다
 * - 이렇게 완성한 mid의 값이 m보다 큰경우, max = mid-1을 한다. 왜냐하면 현재 정한 상한선으로 정하면 최대 예산을 넘어서기 떄문이다
 * - 반대르 mid의 값이 m보다 작은경우, min = mid + 1을 하고 ans = mid를 넣어준다. 매개변수 탐색은 이 과정을 반복해서 최적의 답을 구해준다
 * - 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> province = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1;
        int max = 1;
        for(int i=0; i<n; i++){
            province.add(Integer.parseInt(st.nextToken()));
            max = Math.max(max, province.get(i));
        }
        int m = Integer.parseInt(br.readLine());
        long ans = 0;

        while(min <= max){
            int mid = (min + max) / 2;
            long budget = 0;
            for(int i=0; i<n; i++){
                if(province.get(i) >= mid){
                    budget += mid;
                }else{
                    budget += province.get(i);
                }
            }

            if(budget > m){
                max = mid-1;
            }else{
                min = min+1;
                ans = mid;
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }

}
