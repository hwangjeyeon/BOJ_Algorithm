import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. ext는 Set에 넣어야지 시간초과가 발생하지 않는다
 * 2. Collections.sort안에서 퍼포먼스를 보여주는 문제다
 * 3. 따라서 File이라는 별도의 클래스를 만들어서 구현하면 된다
 * 4. cur과 nxt를 받아서 ext 확장자 포함여부를 확인하낟
 * 5. 다르다면 cur - nxt를 할 수 있게 0, 1로 지정한 값을 넣어주고, 아니라면 확장자 사전 순으로 정렬한다
 * 6. 완성한 결과를 순회해서 각각 풀네임으로 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class File{
    String fullName;
    String name;
    String ext;

    public File(String fullName) {
        this.fullName = fullName;
        name = fullName.substring(0, fullName.lastIndexOf('.'));
        ext = fullName.substring(fullName.lastIndexOf('.') + 1);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<File> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new File(br.readLine()));
        }
        Set<String> ext = new HashSet<>();
        for (int i = 0; i < m; i++) {
            ext.add(br.readLine());
        }

        Collections.sort(list, (o1, o2) -> {

            if (o1.name.equals(o2.name)) {
                int cur = ext.contains(o1.ext) ? 0 : 1;
                int nxt = ext.contains(o2.ext) ? 0 : 1;
                if(cur != nxt) {
                    return cur - nxt;
                }else{
                    return o1.ext.compareTo(o2.ext);
                }
            }

            return o1.name.compareTo(o2.name);
        });

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).fullName+"\n");
        }

        br.close();
        bw.close();
    }
}
