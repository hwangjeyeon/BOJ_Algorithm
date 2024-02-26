import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음 풀이를 보고 풀었을때, 해결하지 못해서 힌트를 참고하였다.
 * - 내가 처음 풀었을 때는 map과 그 value로 list를 사용하였으나, 다른 사람 풀이에서는 Set을 사용하였다.
 * - before after을 나눠주고 name 저장소도 set으로 나눠준다
 * - compareTo를 적극 활용하여 문제를 해결하였다.
 * - AcompareToB가 양수면 A가 크고 작으면 음수 그리고 같으면 0을 반환한다
 * - 위 특성을 활용해서 풀면 정답을 도출할 수 있다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();

        String input = null;
        while((input = br.readLine()) != null){
            String[] tmp = input.split(" ");
            String time = tmp[0];
            String name = tmp[1];

            nameSet.add(name);
            if(s.compareTo(time) >= 0){
                before.add(name);
            }else if(e.compareTo(time) <= 0 && q.compareTo(time) >= 0){
                after.add(name);
            }

        }


        int count = 0;
        for (String name : nameSet) {
           if(before.contains(name) && after.contains(name)){
               count++;
           }
        }

        bw.write(count+"");
        br.close();
        bw.close();
    }

}

