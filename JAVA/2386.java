import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 대문자와 소문자 구분없이 모두 같은 알파벳이라고 했으니까 기준이 되는 문자를 대문자와 소문자 각각 저장하는 char형을 하나 씩 선언한다
 * 2. 이어서 문자를 순회하면서 확인한 후, 같은게 있으면 count++해주고 한줄 끝날떄마다 출력해준다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(입력만큼)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while(!(input = br.readLine()).equals("#")){
            String[] inputs = input.split(" ");
            int count = 0;
            char[] c1 = inputs[0].toLowerCase().toCharArray();
            char[] c2 = inputs[0].toUpperCase().toCharArray();
            for (int i = 1; i < inputs.length; i++) {
                for (int j = 0; j < inputs[i].length(); j++) {
                    if(inputs[i].charAt(j)== c1[0] || inputs[i].charAt(j) == c2[0]){
                        count++;
                    }
                }
            }
            bw.write(inputs[0] + " " + count + "\n");
        }

        br.close();
        bw.close();
    }

}

