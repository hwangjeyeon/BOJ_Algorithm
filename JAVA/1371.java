import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 알파벳 배열을 만들어서 문자열에 포함된 알파벳 개수를 세어주고 관리한다
 * 2. 가장 큰 경우를 찾기 위해 완성된 배열을 순회하며 최대값을 찾는다
 * 3. 완성한 최댓값과 같은 위치를 리스트에 담는다
 * 4. 리스트의 값을 하나씩 꺼내와서 char형으로 형변환하여 문자열로 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alpha = new int[26];
        String input = "";
        while((input = br.readLine()) != null){
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == ' '){
                    continue;
                }
                alpha[input.charAt(i) - 'a']++;
            }
        }

        int max = -1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if(max < alpha[i]){
                max = alpha[i];
            }
        }

        for (int i = 0; i < 26; i++) {
            if(max == alpha[i]){
                ans.add(i);
            }
        }

        for (Integer an : ans) {
            bw.write((char)('a'+an) + "");
        }


        br.close();
        bw.close();
    }
}

