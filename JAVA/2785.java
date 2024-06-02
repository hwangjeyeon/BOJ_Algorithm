import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 오름차순 정렬해서 가장 작은 체인을 하나씩 뽑아서 걸어주면 된다
 * 2. 만약 가장 작은 체인을 모두 다쓰면 그다음 체인으로 걸어주면 된다
 *
 * 해결방법:
 * 1. 삽입, 삭제를 잘 써서 구현하는 문제이므로 배열 말고 리스트를 쓰자
 * 2. 리스트 크기가 1보다 작거나 같으면 탈출하고 아니면 리스트의 set 기능을 사용해서, 0번째 인덱스의 값을 arr.get(0)-1해주고 arr.size()-1의 값은 remove한다
 * 3. 만약 첫번째 값의 크기가 0이면 해당 값을 remove해준다. 왜냐하면 그 뒤의 값이 떙겨지기 때문이다
 * 4. 완성한 count를 출력하면 정답이 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        int count = 0;
        while(true){
            if(arr.size() <= 1){
                break;
            }
            arr.set(0, arr.get(0)-1);
            arr.remove(arr.size() - 1);
            if(arr.get(0) == 0){
                arr.remove(0);
            }
            count++;
        }


        bw.write(count+"");
        br.close();
        bw.close();
    }



}

