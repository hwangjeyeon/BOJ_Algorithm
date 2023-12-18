import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - n/2씩 나누고를 할 필요 없이 바로 n/k해서 그만큼씩 나눠서 임시배열에 저장한 뒤, 정렬하고 정답 배열에 추가하는 방법으로 풀면 간단하게 풀린다
 * - 다시 분할 정복 개념 공부 시작. 개념으로 접근하는데는 성공했으나, 정답까지 도출하지는 못하여서 힌트를 참고하였다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> chickenStore = new ArrayList<>();
        for(int i=0; i<n; i++){
            chickenStore.add(Integer.parseInt(st.nextToken()));
        }
        int k = Integer.parseInt(br.readLine());

        int criteria = n/k;
        List<Integer> sortedChickenStore = new ArrayList<>();
        for(int i=0; i<n; i+=criteria){
            List<Integer> tmp = new ArrayList<>(chickenStore.subList(i, i+criteria));
            Collections.sort(tmp);
            sortedChickenStore.addAll(tmp);
        }


        for(int i=0; i<sortedChickenStore.size(); i++){
            bw.write(sortedChickenStore.get(i) + " ");
        }


        br.close();
        bw.close();
    }

}
