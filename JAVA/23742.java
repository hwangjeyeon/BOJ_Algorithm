import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 양수와 음수끼리 군집을 지어주는 문제다
 * 2. 양수의 합과 음수의 합을 먼저 구해주고 각각을 리스트로 관리해주자
 * 3. 잘 생각해보면 양수끼리 최대한 많은 인원수의 팀을 이루었을 때가 기대하는 최댓값에 도달하기 쉽다
 * 4. 그리고 음수는 최대한 적은 인원의로 팀을 이루어야한다
 * 5. 따라서 양수는 모두 한팀으로 묶고, 음수는 각각 개인 한명의 팀으로 묶어주었다
 * 6. 하지만 한번더 생각해보면 양수 팀에 인원이 늘어난만큼 대비 음수로 차감되는 수가 줄어든다면 오히려 그 값이 더 최댓값이 될 수도 있다
 * 7. 그렇기 때문에 음수의 값을 하나씩 양수팀으로 넘겨보면서 최댓값을 갱신하도록 하였고, 수의 가치가 큰 값부터 넘기기 위해 음수관리 리스트에 내림차순 정렬을 진행하였다
 * 8. 완성한 최댓값을 출력하면 정답이 된다
 *
 * 해결방법:
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
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        long max = 0;
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a > 0){
                listA.add(a);
                sumA+=a;
            }else{
                listB.add(a);
                sumB+=a;
            }
        }
        max = sumA * listA.size() + sumB;
        
        listB.sort(Comparator.reverseOrder());
        
        int count = listA.size();
        for (int i = 0; i < listB.size(); i++) {
            count++;
            sumA += listB.get(i);
            sumB -= listB.get(i);
            max = Math.max(max, sumA * count + sumB);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }

}
