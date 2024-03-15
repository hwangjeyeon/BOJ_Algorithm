import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 입력 받은 문자열의 길이를 변수 n에 저장해둔다
 * 2. n==1일때는 아라카라를 출력한다
 * 3. 이어서 2번이 아닐때 해당 문자열의 n/2를 앞 뒤로 가져온 뒤 비교한다
 * 4. 만약 3번의 결과가 같으면 아라카라고 아니면 주어진 문자열을 출력한다.
 * => 더 생각해야 함
 *
 * 재귀
 * 1. 함수식 : palindrome(입력값, 크기)
 * 2. base Condition 크기가 1일때
 * 3. 재귀식 접두사와 접미사를 나누어주고 입력값을 보내준다
 * -> palindrome(접두사, n/2)
 * -> palindrome(접미사, n/2)
 *
 * 1. 접두사는 상관 없는데, 접미사는 뒤에서 부터 잘라 오기때문에 홀수와 짝수를 구분해서 잘라서 넣어줘야 한다
 * 2. 이어서 두 문자가 같지 않으면 false를 리턴한다
 * 3. 마지막으로 prefix와 suffix 각각을 palindrome한 결과가 모두 true면 return true를 한다.
 * 4. 2,3번 모두 해당되지 않으면 false를 리턴한다.
 *
 * 문제 해결:
 *
 * - 두 StringBuilder의 내용물이 같은지를 비교하고 싶으면 contentEquals를 사용하자. -> prefix.toString().contentEquals(suffix);
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(logn)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int n = input.length();
        boolean ans = palindrome(input, n);

        if(ans){
            bw.write("AKARAKA");
        }else{
            bw.write("IPSELENTI");
        }


        br.close();
        bw.close();
    }

    private static boolean palindrome(String input, int n) {
        if(n == 1){
            return true;
        }

        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            prefix.append(input.charAt(i));
        }
        if(input.length()%2 == 1){
            for (int i = input.length() -1; i > n / 2; i--) {
                suffix.append(input.charAt(i));
            }
        }else{
            for (int i = input.length()-1; i >= n / 2; i--) {
                suffix.append(input.charAt(i));
            }
        }

        if(!prefix.toString().contentEquals(suffix)){
            return false;
        }
        if(palindrome(prefix.toString(), n/2)&& palindrome(suffix.toString(), n/2)){
            return true;
        }
        return false;
    }


}
