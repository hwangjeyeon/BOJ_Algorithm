import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 입력받은 수만큼 반복문 돌려서 출력하면 된다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 * 해커톤으로 힘들어서 브5로 대체...
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = "";
        for(int i=0; i<n; i++){
            s+="*";
            bw.write(s+"\n");
        }



        br.close();
        bw.close();
    }


}
