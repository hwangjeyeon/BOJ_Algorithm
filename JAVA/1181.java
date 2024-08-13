import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 중복이 되지 않으면서 정렬을 하려면 Set을 사용해야하고 이중 TreeSet으로 객체를 선언해주면 된다
 * 2. 이어서 람다식으로 조건에 맞도록 설정한 뒤, n만큼 입력받고 for-each로 출력하면 정답이 된다.
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

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>((o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (String s : set) {
            bw.write(s+"\n");
        }


        br.close();
        bw.close();
    }
}

