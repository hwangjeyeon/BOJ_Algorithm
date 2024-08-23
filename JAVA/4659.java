import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 그냥 깡구현 문제다...
 * 2. if문 열심히 써서 실수 없이 하면 풀 수 있는 문제다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String s = br.readLine();
            if(s.equals("end")){
                break;
            }
            if(!s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o") && !s.contains("u")){
                bw.write("<" + s + ">" +" is not acceptable.\n");
                continue;
            }
            boolean isOk = true;
            for (int i = 0; i < s.length() - 2; i++) {
                if(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u'){
                   if(s.charAt(i+1) != 'a' && s.charAt(i+1) != 'e' && s.charAt(i+1) != 'i' && s.charAt(i+1) != 'o' && s.charAt(i+1) != 'u'
                   && s.charAt(i+2) != 'a' && s.charAt(i+2) != 'e' && s.charAt(i+2) != 'i' && s.charAt(i+2) != 'o' && s.charAt(i+2) != 'u'){
                       bw.write("<" + s + ">" +" is not acceptable.\n");
                       isOk = false;
                       break;
                   }
                }else{
                    if((s.charAt(i+1) == 'a' || s.charAt(i+1) == 'e' || s.charAt(i+1) == 'i' || s.charAt(i+1) == 'o' || s.charAt(i+1) == 'u')
                            && (s.charAt(i+2) == 'a' || s.charAt(i+2) == 'e' || s.charAt(i+2) == 'i' || s.charAt(i+2) == 'o' || s.charAt(i+2) == 'u')){
                        bw.write("<" + s + ">" +" is not acceptable.\n");
                        isOk = false;
                        break;
                    }
                }
            }

            if(!isOk){
                continue;
            }

            for (int i = 0; i < s.length() - 1; i++) {
                if(((s.charAt(i) != 'e' && s.charAt(i+1) != 'e') && (s.charAt(i) != 'o' && s.charAt(i+1) != 'o'))
                && (s.charAt(i) == s.charAt(i+1))){
                    bw.write("<" + s + ">" +" is not acceptable.\n");
                    isOk = false;
                    break;
                }
            }

            if(!isOk){
                continue;
            }

            bw.write("<" + s + ">" +" is acceptable.\n");

        }

        br.close();
        bw.close();
    }
}

