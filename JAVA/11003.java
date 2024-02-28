import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 완전 탐색은 불가능하다 입력값이 5000000인데 최소 이중포문을 써야하므로 시간 제한에 걸리게 된다.
 * 2. 10^9이므로 int형을 벗어나지 않으며, 더하는 연산도 없으므로 long을 사용할 필요가 없다
 * 3. 슬라이딩 윈도우와 덱을 사용해서 비어있으면 일단 값 넣고 출력.
 * 4. 값이 들어올 때 덱에 있는 마지막 값이 들어오는 값보다 크면 빼준다.
 * 5. 4번을 덱이 비어있지 않고, 마지막 값이 들어온 값보다 큰 동안 반복한다.
 * 6. 이후 덱의 크기를 비교하여 슬라이딩 윈도우 크기인 l보다 크면 빼려고 했으나 4~5번 과정에서 값이 빠져나가기 때문에 원하는 결과를 도출할 수 없는 케이스가 발생한다.
 * 7. 따라서 클래스로 값과 각 값의 들어온 순서를 필드로 해서 덱에 저장하고 현재 i에서 (l-1)만큼 뺀 값보다 작은 경우 슬라이딩 윈도우를 벗어난 값이므로 그 값을 빼준다.
 * 
 *
 * - 내가 아는 개념이 있다면 특정 유형에만 집중하지 않고 함께 활용해서 풀도록 연습하자
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Type{
    int value;
    int order;

    public Type(int value, int order) {
        this.value = value;
        this.order = order;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Type> de = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            Type type = new Type(now, i);
            if(de.isEmpty()){
                de.addFirst(type);
                sb.append(de.peekFirst().value).append(" ");
            }else{
                while(!de.isEmpty() && de.peekLast().value > now){
                    de.pollLast();
                }
                de.addLast(type);
                if(de.peekFirst().order < i - (l-1)){
                    de.pollFirst();
                }
                sb.append(de.peekFirst().value).append(" ");

            }

        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}

