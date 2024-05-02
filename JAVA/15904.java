import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 처음에는 단순 contains로 풀었으나 틀렸다. 
 * 2. 틀린 원인을 분석해보니 contains 되어있는 문자열에 또 UCPC 문자가 있을 수 있어서 였다
 * 3. i--로 해결해보았으나 또다시 틀렸다
 * 4. 이번에는 분석해보니 똑같은 문자에서 두개 이상이 있을 때, 발견된 위치부터 다시 탐색을 해야하는데 처음부터 탐색하도록 하였기 때문이었다
 * 5. 따라서 이중 포문으로 비교를 하면서 해당하는 문자를 발견해도 break하지 않고 그대로 진행하되, pos를 검사해서 ucpc의 길이-1 보다 크면 break해서 탈출한다
 * 6. 완성된 결과를 isFind에 따라서 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 *
 * 시간복잡도: O(s.length*s[i].length())
 * 공간복잡도: O(s[i].length)
 *
 */



public class Main {

    private static final char[] ucpc = {'U','C','P','C'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        int pos = 0;
        boolean isFind = false;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                if(s[i].charAt(j) == ucpc[pos]){
                    pos++;
                }
                if(pos > ucpc.length-1){
                    isFind = true;
                    break;
                }
            }
            if(isFind){
                break;
            }
        }

        if(isFind){
            bw.write("I love UCPC");
        }else{
            bw.write("I hate UCPC");
        }




        br.close();
        bw.close();
    }
}

