import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 그냥 문자열에 저장해서 출력하면된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String microsoft = "       _.-;;-._\n" +
                "'-..-'|   ||   |\n" +
                "'-..-'|_.-;;-._|\n" +
                "'-..-'|   ||   |\n" +
                "'-..-'|_.-''-._|";
        bw.write(microsoft);
        br.close();
        bw.close();
    }

}
