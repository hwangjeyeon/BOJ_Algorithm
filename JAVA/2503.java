import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. 먼저 123부터 1000까지 수를 확인한다. 0이 들어간 수는 당연히 안 되고 세자리수중 중복이 되는 경우도 제외한다
 * 2. 앞선 조건애 해당하지 않으면 true로 설정한다
 * 3. 이어서 숫자를 입력받고 123부터 1000까지 순회하면서 각 수를 확인한다
 * 4. 세자리수를 비교하기위해 두번의 순회를 더하면서 자리의 위치와 그 숫자가 같으면 스트라이크, 자리의 숫자만 같으면 볼로 카운트 해준다
 * 5. 스트라이크와 볼 개수가 모두 같으면 true로 하고 아니면 fasle로 한다
 * 6. 이후 true의 개수를 세어서 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[1000];
        for (int i = 123; i < 1000; i++) {
            String s = String.valueOf(i);
            if(s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0'){
                continue;
            }

            if(s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)){
                continue;
            }

            num[i] = true;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 123; j < 1000; j++) {
                if(num[j]){
                    int tmp1 = 0;
                    int tmp2 = 0;

                    for (int k = 0; k < 3; k++) {
                        String s1 = String.valueOf(number);
                        for (int l = 0; l < 3; l++) {
                            String s2 = String.valueOf(j);

                            if(s1.charAt(k) == s2.charAt(l) && k == l){
                                tmp1++;
                            }else if(s1.charAt(k) == s2.charAt(l) && k != l){
                                tmp2++;
                            }
                        }
                    }
                    if(tmp1 == strike && tmp2 == ball){
                        num[j] = true;
                    }else{
                        num[j] = false;
                    }

                }
            }
        }

        int ans = 0;
        for (int i = 123; i < 1000; i++) {
            if(num[i]){
                ans++;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
