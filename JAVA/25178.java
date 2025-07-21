import java.io.*;

/**
 * 풀이 과정:
 * 1. 3가지 조건을 모두 만족시키면 YES, 아니면 NO다
 * 2. 첫번째 조건은 양 끝이 서로 같은지 확인하고 아니면 NO를 출력한다
 * 3. 두번째 조건은 단어의 개수를 세어준다 S1은 그 단어의 개수를 증가시키고 S2는 그 단어의 개수를 감소시킨다
 * 4. 만약 하나라도 0이 아니라면 조건에 맞지 않는다. NO를 출력한다
 * 5. 세번째 조건은 모음을 모두 제거했을 때 같은지 확인하는 것이다 replaceAll을 이용해서 aeiou를 모두 지워주고 같은지 비교한다
 * 6. 다르면 NO를 출력한다
 * 7. 이 모든 조건을 통과하면 YES를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        if(s1.charAt(0) != s2.charAt(0) || s1.charAt(n-1) != s2.charAt(n-1)){
            bw.write("NO");
        }else if(!checkRule(s1, s2, n)){
            bw.write("NO");
        }else if(!s1.replaceAll("[aeiou]","").equals(s2.replaceAll("[aeiou]",""))){
            bw.write("NO");
        }else{
            bw.write("YES");
        }

        br.close();
        bw.close();
    }

    private static boolean checkRule(String s1, String s2, int n) {
        char[] word = new char[26];
        for (int i = 0; i < n; i++) {
            word[s1.charAt(i) - 'a']++;
            word[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(word[i] != 0){
                return false;
            }
        }
        return true;
    }

}
