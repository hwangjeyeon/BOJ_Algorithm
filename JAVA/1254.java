import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 어떤 문자열이 주어졌을 때, 이 문자열을 팰린드롬으로 만들려면, 팰린드롬이 되는 지점까지 문자열을 단위로 쪼개어서 탐색해야한다
 * 2. 이 문제에서는 문자열이 주어졌을 때, 이 문자열을 팰린드롬으로 만들고 그 길이를 출력하도록 요구한다
 * 3. 팰린드롬으로 만들기 위해서는 결국, 주어진 문자열에서 팰린드롬이 아닌 지점을 찾고, 그 지점의 개수를 세어주면 된다
 * 4. 만약 찾는 도중에 팰린드롬을 발견한다면, 그 이후부터는 탐색을 하지 않아도 된다
 * 5. 문자열의 맨 앞부터 차례대로 뒤로 가면서 substring하여 문자열의 팰린드롬 여부를 체크해준다
 * 6. 팰린드롬 검사는 투 포인터를 두고 양 끝을 비교하면서 검사하는 방식이다. 
 * 7. 만약 두 문자가 같지 않다면 팰린드롬이 아니므로 탈출하고 count를 늘려준다
 * 8. 만약 모든 문자가 같다면 현재지점부터 끝까지는 팰린드롬이므로 추가 탐색 없이 탈출한다
 * 9. 이제 기존 문자열 길이에 count를 더하거나 혹은 count 초기값을 기준 문자열 길이로 선정해주면 된다
 * 10. 완성한 count를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(s.length()^2);
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int len = s.length();
        int count = len;

        for (int i = 0; i < len; i++) {
            String tmp = s.substring(i);
            int start = 0;
            int end = tmp.length() - 1;
            boolean isPalindrome = true;
            while(start <= end){
                if(tmp.charAt(start) != tmp.charAt(end)){
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;
            }
            if(!isPalindrome){
                count++;
            }else{
                break;
            }
        }


        bw.write(count + "");

        br.close();
        bw.close();
    }
}

