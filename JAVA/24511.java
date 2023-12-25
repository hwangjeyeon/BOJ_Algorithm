import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문제 이해가 좀 어려웠다.. 이해를 위해 설명을 찾아봤다
 * - n의 원소만큼 m의 원소를 순회하는 문제로 최악의 경우 n*m의 시간복잡도가 나올 수 있다
 * - 즉 m의 원소 한개를 n개 만큼의 원소와 다 비교해야한다는 것이다.
 * - 시간복잡도 1초임을 생각했을 때, 입력값이 둘다 최대 10만이므로 시간초과가 발생할 것이 예상된다
 * - 따라서 이중 for문을 이용한 순회는 정답이 될 수 없다
 * - 문제를 잘 살펴보았을 때, 자료구조 타입이 큐인 경우는 삽입되고 원래 자리에 있던 원소가 튀어나오지만, 스택인 경우 삽입했던 원소가 그대로 다시 튀어나온다.
 * - 이것을 고려했을 때, 스택의 경우는 제외하고 큐의 경우만 생각하면 되는 것으로 생각할 수 있다
 * - 이어서 덱에 큐인 경우만 뒤로 넣고, 원소 m만큼을 순회해서 각 원소 m은 앞으로 넣고 맨 뒤에 있는 원소는 poll해서 출력한다.
 * - 코드를 간단하게 하기 위해 StringBuilder를 사용하였다.
 * - 완성된 StringBuilder를 출력하면 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> type = new ArrayList<>();

        List<Integer> elements = new ArrayList<>();
        for(int i=0; i<n; i++){
            type.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        Deque<Integer> de = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            elements.add(Integer.parseInt(st.nextToken()));
            if(type.get(i) == 0){
                de.addLast(elements.get(i));
            }
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        List<Integer> inserts = new ArrayList<>();
        for(int i=0; i<m; i++){
            inserts.add(Integer.parseInt(st.nextToken()));
            de.addFirst(inserts.get(i));
            sb.append(de.pollLast() + " ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
