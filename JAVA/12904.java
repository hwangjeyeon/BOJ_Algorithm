import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에는 S에서 T로 가는 경우로 문제를 풀었으나 2%에서 틀려버렸다
 *
 * - 문제 해결:
 * 2. 질문게시판의 힌트를 보고 아이디어를 얻어 풀 수 있었다
 * 3. 발상을 역전시켜보자 T에서 S로 가는 경우를 구하면 문제를 해결할 수 있다
 * 4. 한가지 더 주의할점은 B일때 순서를 뒤집어야하므로 먼저 지우고 뒤집어야한다!
 * 5. 이렇게 두 문자열의 길이가 같아질때까지 반복하면 되며, t는 StringBuilder 사용하여 쉽게 뒤집고 삭제하면 된다
 * 6. 완성한 결과가 contentEquals이 아닐 경우 0, 맞으면 초기값 1로 출력하면 정답이 된다.
 *
 * 시간복잡도: O(|T - S|)
 * 공간복잡도: O(|T|)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        int ans = 1;
        while(t.length() > s.length()){
            if(t.charAt(t.length()-1) == 'A'){
                t.deleteCharAt(t.length()-1);
            }else{
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if(!s.contentEquals(t.toString())){
            ans = 0;
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}

