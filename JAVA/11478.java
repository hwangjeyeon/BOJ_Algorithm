import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - set을 사용하면 쉬운 문제다.
 * - 그냥 이중 for문과 substring을 통해서 set에 추가해준다.
 * - 이때 중복되는 문자는 알아서 걸러지기 때문에 서로다른 부분 문자열만이 저장된다
 * - 최종 정답으로 set의 size를 출력하면 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Set<String> sets = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<=s.length()-1; j++){
                sets.add(s.substring(i,j+1));
            }
        }

        bw.write(sets.size() + "");
        br.close();
        bw.close();
    }

}
