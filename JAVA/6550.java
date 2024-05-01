import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. s 문자열에 있는 값들을 하나씩 뽑아서 t의 값들과 비교한다. 
 * 2. 이때 비교마다 처음부터 계산하면 시간초과가 발생할 수 있다. 따라서 발견할 때마다 그 다음 값은 발견한 지점 + 1부터 시작해서 찾도록 한다
 * 3. count도 같이 세어주어서 만약 s의 길이와 같아지면 반복문을 탈출하고 그에 맞는 결과를 출력하도록 한다.
 * 
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(s.length + t.length())
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while((input = br.readLine()) != null){
            String[] tmp = input.split(" ");
            String s = tmp[0];
            String t = tmp[1];

            int start = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                for (int j = start; j < t.length(); j++) {
                    if(a == t.charAt(j)){
                        start = j+1;
                        count++;
                        break;
                    }
                }
                if(count == s.length()){
                    break;
                }

            }

            if(count == s.length()){
                bw.write("Yes\n");
            }else{
                bw.write("No\n");
            }


        }


        br.close();
        bw.close();
    }

}

