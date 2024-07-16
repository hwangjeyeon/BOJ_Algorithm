import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 미리 알파뱃 문자 배열을 하나 만들어두고, 개수를 세어줄 배열을 하나 만들어서 문자열에서 그 위치에 해당하는 개수를 세어준다
 * 2. 가장 큰 값을 구하기 위해 max로 count를 순회하여 찾고, 이후 그 max랑 같은 같은 위치를 다시 count에서 찾는다. 
 * 3. 이때 개수를 세어주어서 만약 개수가 1이라면 그대로 정답 위치에 alpha[ans]를 출력하고 아니라면 ?를 출력한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int[] count = new int[26];
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == ' '){
                    continue;
                }

                count[s.charAt(j) - 'a']++;
            }
            int max = 0;
            for (int i1 : count) {
                if(i1 > max){
                    max = i1;
                }
            }
            int counts = 0;
            int ans = 0;
            for (int j = 0; j < 26; j++) {
                if(max == count[j]){
                    counts++;
                    ans = j;
                }
            }

            if(counts == 1){
                bw.write(alpha[ans]+"\n");
            }else{
                bw.write('?'+"\n");
            }

        }
        br.close();
        bw.close();
    }

}

