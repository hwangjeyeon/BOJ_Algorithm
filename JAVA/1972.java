import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. Set을 이용하여, 각 D-쌍마다 정해진 Set의 크기만큼 저장되는지 확인한다
 * 2. 만약 위 조건을 만족시키지 못하면 D-유일이 아닌 것이고 만족시키면 D-유일인 것이다
 * 3. set에는 s[j] + s[j+i+1]을 더해준다.
 * 4. set의 사이즈는 s.length - i - 1과 같아야하며 아닐 경우 D-유일을 지키지 못한 것이다.
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while(!(input = br.readLine()).equals("*")){
            String[] s = input.split("");

            boolean isOk = false;
            for (int i = 0; i < s.length-1; i++) {
                Set<String> set = new HashSet<>();
                for (int j = 0; j < s.length - i - 1; j++) {
                    set.add(s[j]+s[j+i+1]);
                }
                if(set.size() != s.length - i-1){
                    for (String string : s) {
                        bw.write(string);
                    }
                    bw.write(" is NOT surprising.\n");
                    isOk = true;
                    break;
                }
            }
            if(!isOk){
                for (String string : s) {
                    bw.write(string);
                }
                bw.write(" is surprising.\n");
            }
        }


        br.close();
        bw.close();
    }


}
