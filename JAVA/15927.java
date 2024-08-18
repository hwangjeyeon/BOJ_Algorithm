import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문자열을 활용한 아이디어 문제였다. 알고리즘 분류에 괜히 애드혹이 들어간게 아닌 것 같다..
 * 2. 양 끝점을 두고 front가 back보다 작은동안 다음을 반복한다. 
 * 3. 만약 두 지점의 문자가 다르면 break하고, 아닌 경우 front는 증가, back은 감소한다
 * 4. 만약 front가 back보다 작으면 팰린드롬이 아니므로 그냥 문자열의 길이를 출력한다
 * 5. 이후 한가지 더 확인을 해야하는데, 처음 문자를 하나 두고, 문자열의 길이만큼 순회하면서 만약 같지 않은 것을 발견하면 탈출한다. 
 * 6. 만약 모두 같다면 부분 문자열을 만들 수 없으므로 -1을 출력하고, 아니라면 가장 긴 부분 문자열은 맨앞이나 뒤를 제외한 문자열이므로 문자열의 길이 - 1을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(|S|)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        int front = 0;
        int back = s.length() - 1;
        while(front <= back){
            if(s.charAt(front) != s.charAt(back)){
                break;
            }
            front++;
            back--;
        }
        if(front < back){
            bw.write(s.length() + "");
        }else{
            char first = s.charAt(0);
            boolean isFind = false;
            for (int i = 0; i < s.length(); i++) {
                if(first != s.charAt(i)){
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                bw.write("-1");
            }else{
                bw.write(s.length()-1 + "");
            }
        }


        br.close();
        bw.close();
    }

}

