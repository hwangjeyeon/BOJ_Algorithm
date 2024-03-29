import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 이전에 풀었던 벚꽃 정보섬 문제랑 비슷한 유형이다
 * 2. 주어진 입력범위가 작어서 3중 포문으로 해결하였다.
 * 3. 각 순회마다 StringBuilder를 선언해주고 append한다
 * 4. tmp에다가 reverse된 a,b,c를 넣고 ans와 비교한다.
 * 5. 비어있으면 그냥 넣고 비어있지 않으면 compareTo를 사용해서 ans가 작은 경우에만 넣어준다
 * 6. 다시 a와 b를 reverse하고 순회를 반복한뒤 완성된 ans를 출력하면 정답이 된다.
 *
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(input.length^3)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        String ans = "";
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < input.length-2; i++) {
            a.append(input[i]);
            StringBuilder b = new StringBuilder();

            for (int j = i+1; j < input.length-1; j++) {
                StringBuilder tmp = new StringBuilder();
                b.append(input[j]);
                StringBuilder c = new StringBuilder();
                for (int k = j+1; k < input.length; k++) {
                    c.append(input[k]);
                }
                a.reverse();
                b.reverse();
                c.reverse();
                tmp.append(a).append(b).append(c);
                if(ans.isEmpty()){
                    ans = tmp.toString();
                }else{
                    if(ans.compareTo(tmp.toString()) > 0) {
                        ans = tmp.toString();
                    }
                }
                a.reverse();
                b.reverse();
            }
        }

        bw.write(ans.toString());



        br.close();
        bw.close();
    }

}
