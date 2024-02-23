import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문자열을 처음부터 탐색해서 substring으로 구간을 가져와서 find가 있는지 확인한다
 * - 탐색 범위는 s의 length - find의 length까지로 한다
 * - s의 substring 범위는 i부터 i+find.length이다
 * - 위 조건이 맞으면 count++해주고 i에 find.length()-1을 더해줘서 중복 카운트를 배제한다
 * - 완성된 count를 출력하면 정답이 된다.
 *  
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String find = br.readLine();
        int count = 0;
        for (int i = 0; i <= s.length() - find.length(); i++) {
            if(s.substring(i, i+find.length()).equals(find)){
                count++;
                i += find.length()-1;
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }
}

