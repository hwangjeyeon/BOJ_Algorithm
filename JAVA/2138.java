import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 먼저 첫번째 전구를 켜냐 끄냐로 분리하고 상태를 관리하며 풀어야 한다
 * 2. 이어서 두번째 스위치부터 킬지 끌지를 결정해야하는데, 두번째 스위치의 선택은 첫번째 선택지의 최종 결과가 된다. 따라서 그리디하게 풀기 위해 중복으로 다시 선택하지 않도록 이전값이 최종값과 같으면 누르지 않고 다르면 누르도록 한다 
 * 3. 앞선 두가지 경우로 나눈다고 했는데, 각 경우에 따라서 count 값도 다르게 해서 계산해준다
 * 4. 마지막에 최종 값이 다르면 각각을 -1로 처리해준다
 * 5. 출력 할때 한쪽값이 -1이면 -1이 아닌 count를 출력하고 둘다 -1이면 -1을 출력하고 아닌 경우 둘중 더 작은 값을 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n+n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        int[] before1 = new int[n];
        int[] before2 = new int[n];
        int[] after = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(input[i]);
            before1[i] = tmp;
            before2[i] = tmp;
        }
        input = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            after[i] = Integer.parseInt(input[i]);
        }
        int count1 = 1;
        int count2 = 0;
        before1[0] = 1-before1[0];
        before1[1] = 1-before1[1];

        for (int i = 0; i < n-1; i++) {
            if(before1[i] != after[i]) {
                count1++;
                before1[i] = 1 - before1[i];
                before1[i + 1] = 1 - before1[i + 1];
                if (i != n - 2) {
                    before1[i + 2] = 1 - before1[i + 2];
                }
            }
        }
        if(before1[n-1] != after[n-1]){
            count1 = -1;
        }
        for (int i = 0; i < n-1; i++) {
            if(before2[i] != after[i]) {
                count2++;
                before2[i] = 1 - before2[i];
                before2[i + 1] = 1 - before2[i + 1];
                if (i != n - 2) {
                    before2[i + 2] = 1 - before2[i + 2];
                }
            }
        }
        if(before2[n-1] != after[n-1]){
            count2 = -1;
        }

        if(count1 == -1){
            bw.write(count2+"");
        }else if(count2 == -1){
            bw.write(count1+"");
        }else{
            bw.write(Math.min(count1, count2)+"");
        }


        br.close();
        bw.close();
    }



}

