import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 유니온-파인드를 이용하여 문제를 풀었다.
 * - 일단 자기자신을 가리키는 parent[i]배열을 만든다
 * - 그리고 진실을 알고 있는 사람을 리스트에 저장해둔다
 * - 이어서 여러 파티를 담을 수 있는 리스트 배열을 만들어준다
 * - 이를 이용해서 각 파티 리스트마다 그 요소들끼리 union해준다
 * - 이떄 일반적으로 b를 a에 합하는 방식으로 진행하는데 b가 진실을 알고 있는 사람이면 a를 b에 합하는 방식으로 한다
 * - 이 방식으로 리스트 배열에 추가해준다
 * - 이어서 해당 리스트 배열들을 순회해서 각 리스트의 요소가 단 하나라도 진실을 알고 있는 사람을 포함하고 있으면 count값을 증가시킨다
 * - 마지막에 전체 파티의 개수인 m에서 count의 개수를 뺀 값을 출력해준다.
 * - 이 방식을 유니온파인드 방식으로 선언한 이유가 진실을 알고 있는 사람이 어떤 파티에 참여하게 되면, 그 파티에 참여한 다른 사람들도 진실을 알게되기 때문이다.
 * - 진실이 전염되어 나가는 느낌이기에 해당 방식을 선택하게 되었다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int[] parent;
    static List<Integer> areYouT;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int countT = Integer.parseInt(st.nextToken());
        areYouT = new ArrayList<>();
        for (int i = 0; i < countT; i++) {
            areYouT.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] partyList = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            partyList[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int member = Integer.parseInt(st.nextToken());
            int firstMember = Integer.parseInt(st.nextToken());
            partyList[i].add(firstMember);

            for (int j = 1; j < member; j++) {
                int newMember = Integer.parseInt(st.nextToken());
                union(firstMember, newMember);
                partyList[i].add(newMember);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int member : partyList[i]) {
                if(areYouT.contains(find(parent[member]))){
                    count++;
                    break;
                }
            }
        }


        bw.write(m-count+"");
        br.close();
        bw.close();
    }

    static void union(int a, int b){
        int ta = find(a);
        int tb = find(b);
        if(areYouT.contains(tb)){
            int tmp = ta;
            ta = tb;
            tb = tmp;
        }
        parent[tb] = ta;
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

}
