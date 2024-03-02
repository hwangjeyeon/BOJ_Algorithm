import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 일단 제일 첫번째 문자를 덱에 넣어주기 위해 비어있는 경우 그냥 앞에다가 넣어주자
 * 2. 이어서 앞에 값과 비교해서 사전 순으로 더 크면 앞에다가 넣는다
 * 3. 만약 그렇지 않으면 뒤에다가 넣는다.
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<String> de = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                if(de.isEmpty()){
                    de.addFirst(st.nextToken());
                }else{
                    String input = st.nextToken();
                    if(de.peekFirst().compareTo(input) < 0){
                        de.addLast(input);
                    }else{
                        de.addFirst(input);
                    }
                }
            }


            for (String s : de) {
                bw.write(s);
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

}

