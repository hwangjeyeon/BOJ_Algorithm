import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 덱을 사용하여 푸는 문제이며, 이 문제에서 어려웠던 점은 인덱스를 출력해야한다는 점이었다.
 * - 단순히 값을 출력하는 문제였다면, 쉬운 문제였겠지만 인덱스도 같이 보관해야해서 많이 어려웠다.
 * - 해결방법은 다양하나 선택한 방법은 인덱스와 그 값을 하나의 필드로 가지는 객체를 생성해서 덱에 저장하는 방법이었다
 * - 이어서 값이 양수거나 음수일때 각각 찾는 방법은 양수일때는 맨 앞에 있는 값을 맨뒤로 보내고, 음수일때는 맨 뒤에 있는 값을 맨 앞으로 보내는 방법이다.
 * - 이때 해당 객체의 value값 만큼 반복한다.
 * - 양수는 그 값에서 1만큼 빼고서 반복을 통해 맨 뒤로 보내는 과정을 진행해야하는데, 먼저 풍선 터트리는 현재의 값이 제거되면서 맨앞의 값이 하나 밀리게 되기 때문이다.
 * - 음수는 그 왼쪽에 값이 없는 상태이기 때문에 양수와 다르게 값을 감소시킬 이유가 없다.
 * - 이동하는 것은 그 값이 포함되어있다고 가정하고 이동해야한다. 하지만 이동할때는 그 값을 제거하고 간다고도 해야한다
 * - 이렇게 하는 이유는 이렇게 반복해서 다시 원점으로 돌아왔을 때에 문제가 생길 수 있기 때문이다.
 * - 이 논리와 과정을 통해서 반복할때마다 정답을 출력하면 된다.
 * 
 * - 인덱스 출력 부분에서 힌트를 참고했다. 
 * - 클래스를 활용하는 방법도 적극적으로 활용해야겠다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static class Index{
        int idx;
        int value;

        public Index(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return idx;
        }

        public int getValue() {
            return value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Index> de = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Index index;
        for(int i=0; i<n; i++){
            de.add(new Index(i+1, Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<n; i++){
            int tmp = de.getFirst().getValue();
            int val = de.getFirst().getIdx();
            de.pollFirst();
            bw.write(val + " ");
            if(de.isEmpty()){
                break;
            }

            if(tmp > 0) {
                tmp--;
                while (!de.isEmpty() && tmp > 0) {
                    de.addLast(de.pollFirst());
                    tmp--;
                }
            }else{
                while(!de.isEmpty() && tmp < 0){
                    de.addFirst(de.pollLast());
                    tmp++;
                }
            }

        }

        br.close();
        bw.close();
    }

}
