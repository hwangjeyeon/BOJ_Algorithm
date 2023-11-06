import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - List에 크로아티아 단어를 넣어준다
 * - 모든 크로아티아 언어를 비교한다. 이때, 입력받은 문자열에 해당하는 단어가 있는지 확인한다
 * - 단어를 확인할 때, 중복되는 단어가 존재할 수 있으므로, indexOf가 -1이 아닐동안에 반복하며, 해당 단어가 있으면, count값을 증가시키고 replaceFirst로 해당 부분을 " "로 바꾼다
 * - 이렇게 바꾼 단어를 최종적으로 확인할 때, " "을 ""로 다시 replace해주고, 남은 단어의 수를 세어준 다음 정답을 출력한다
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String alphabet = br.readLine();
        List<String> croatia = new ArrayList<>();
        croatia.add("c=");
        croatia.add("c-");
        croatia.add("dz=");
        croatia.add("d-");
        croatia.add("lj");
        croatia.add("nj");
        croatia.add("s=");
        croatia.add("z=");
        int count = 0;
        for (String co:croatia) {
            int index;
            while((index = alphabet.indexOf(co)) != -1){
                alphabet = alphabet.replaceFirst(co," ");
                count++;
            }
        }
        
        alphabet = alphabet.replace(" ", "");
        count += alphabet.length();


        bw.write(count + "");
        br.close();
        bw.close();
    }
}
