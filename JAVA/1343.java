import java.io.*;
import java.util.*;


/**
 * 풀이 과정: 
 * 1. 마지막을 예외처리해줘야 하는데 그냥 s문자열 마지막에 .을 추가해줬다
 * 2. X일 경우 count값을 증가시켜준다
 * 3. X가 아닐 경우 이제 count를 비교해서 ans에 append해줘야 한다
 * 4. 사전 순으로 선택되도록 그리디하게 풀어야 하기 때문에 count/4한 만큼 AAAA를 append해준다. 이후 count %=4로 값을 업데이트한다
 * 5. 다음은 count/2한만큼 BB를 append해준다 이후 count %= 2로 값을 업데이트한다
 * 6. 만약 count가 0이 아니면 덮을 수 없으므로 isOk를 false로 하고 break로 반복문을 탈출한다
 * 7. .도 추가해줘야한다. 마지막은 예외 처리를 위해 임의로 붙인 것이므로 마지막을 제외하고나서는 위 과정 후에 .을 append해준다
 * 8. isOk가 true면 ans를 출력하고 아니면 -1을 출력하면 정답이 된다.
 * 
 * 해결방법: 
 *
 * 시간복잡도: O(s.length())
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int count = 0;
        s += ".";
        StringBuilder ans = new StringBuilder();
        boolean isOk = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'X'){
                count++;
            }else{

                for (int j = 0; j < count / 4; j++) {
                    ans.append("AAAA");
                }
                count %= 4;

                for (int j = 0; j < count / 2; j++) {
                    ans.append("BB");
                }
                count %= 2;

                if(count != 0){
                    isOk = false;
                    break;
                }

                if(i!=s.length()-1){
                    ans.append(".");
                }
            }
        }

        if(isOk){
            bw.write(ans.toString());
        }else{
            bw.write("-1");
        }

        br.close();
        bw.close();
    }
}

