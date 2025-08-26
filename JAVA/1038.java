import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 백트래킹으로 푸는데 약간 변형해야한다.
 * 2. 먼저 n이 10보다 작으면 n을 출력하고 1022보다 크면 -1을 출력한다
 * 3. 그 이외의 경우 i가 0부터 9로 각각 시작하는 경우를 계산해서 백트래킹을 진행해서 list에 넣어준다
 * 4. 순회 종료후에는 정렬 후 n번째를 출력한다
 * 5. 백트래킹에서는 10이하인 동안 백트래킹을 진행하고 현재 숫자를 list에 넣어준다
 * 6. num%10만큼 순회하며 백트래킹으로 (num*10) + i 를 nu으로 갱신하고 idx+1을 진행한다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(n <= 10){
            bw.write(n+"");
        }else if(n > 1022){
            bw.write("-1");
        }else{
            for (int i = 0; i < 10; i++) {
                backtracking(i, 1);
            }
            Collections.sort(list);
            bw.write(list.get(n)+"");
        }

        br.close();
        bw.close();
    }

    private static void backtracking(long num, int idx) {
        if(idx > 10){
            return;
        }
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            backtracking((num*10) + i, idx+1);
        }
    }

}
