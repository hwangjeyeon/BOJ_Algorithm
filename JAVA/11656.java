import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문자열 + 정렬 문제이다
 * - substring을 이용하여 접미사를 모두 가져와 배열에 저장하고 오름차순 정렬한뒤 출력하면 정답이 된다. 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] list = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            list[i] = s.substring(i);
        }

        Arrays.sort(list);
        for (int i = 0; i < s.length(); i++) {
            bw.write(list[i]+"\n");
        }

        br.close();
        bw.close();
    }

}

