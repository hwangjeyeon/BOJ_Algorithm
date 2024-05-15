import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문자열을 진짜 스왑하고 반전시키고 하는줄 알았는데, 그냥 두 문자열 비교로 풀리는 문제였다.
 * - init을 기준으로 last와 다를 때, init의 문자열이 W인지 B인지로 구분을 먼저한다
 * - 각각의 위치를 리스트에 넣어주고, 두 리스트 중 더 큰 값을 출력하면 정답이 된다.
 * - 왜냐하면 W와 B가 각각 하나 이상씩 있다면, 그 수만큼 스왑해주고 남은 수는 반전시키면 그리디하게 최적의 결과를 뽑을 수 있기 때문이다.
 * - 물론 문자가 두개라서 쉽게 가능한 문제였다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    static String[] init;
    static String[] last;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            init = br.readLine().split("");
            last = br.readLine().split("");
            List<Integer> wPos = new ArrayList<>();
            List<Integer> bPos = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if(!init[j].equals(last[j])){
                    if(init[j].equals("W")){
                        wPos.add(j);
                    }else{
                        bPos.add(j);
                    }
                }
            }

            bw.write(Math.max(wPos.size(), bPos.size()) + "\n");

        }


        br.close();
        bw.close();
    }



}

