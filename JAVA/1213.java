import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 각 문자에 해당하는 배열을 만들자. 그리고 각각의 개수를 세어서 배열의 값으로 표현하자
 * 2. 배열을 순회해서 1인 경우가 있는지 확인하자 1인 경우가 있으면 불가능 한 경우이므로 주어진 문자열을 출력하자
 * 3. 2번이 아니면 배열의 앞에서부터 그 배열의 개수의 절반만큼 가져와서 정답 문자열에 더해주자
 * 4. 3번은 배열의 끝까지 순회한다
 * 5. 이어서 순회하면서 배열의 문자 남은 개수의 나머지가 1인 경우 하나씩 문자열에 넣어주자
 * 6. 마지막으로 뒤에서부터 순회하는데 배열의 남은 숫자만큼 해당 문자를 정답 문자열에 더해준다
 * 7. 완성한 문자열을 출력한다.
 * => 2번을 다시 생각해야 한다
 * 2번 수정: 펠린드롬이 아닐려면 각 문자의 개수가 홀수개인 것이 2문자 이상이 되면 안된다.
 *
 * 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'A']++;
        }
        boolean isOk = true;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(arr[i] % 2 == 1){
                count++;
            }
        }

        if(count >= 2){
            isOk = false;
        }
        StringBuilder ans = new StringBuilder();
        if(!isOk){
            bw.write("I'm Sorry Hansoo");
        }else{
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < arr[i]/2; j++) {
                    ans.append((char)(i + 'A'));
                }
            }

            for (int i = 0; i < 26; i++) {
                if(arr[i]%2 == 1){
                    ans.append((char)(i+'A'));
                    arr[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                for (int j = 0; j < arr[i]/2; j++) {
                    ans.append((char)(i + 'A'));
                }
            }

            bw.write(ans.toString());
        }


        br.close();
        bw.close();
    }


}
