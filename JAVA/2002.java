import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 일단 Map을 활용하는 문제라는 것은 알았고, key를 자동차명 value를 들어간 순서로 지정해서 HashMap으로 map인스턴스를 만든다
 * 2. LinkedHashMap을 사용할 수도 있는데 굳이..? 라는 생각이 들었다. 어차피 value로 순서 넣으면 구분되는거 아닌가 라는 생각하여 HashMap으로 선언하였다
 * 3. 이제 구분하는 부분 구현에서 초반에 좀 틀렸는데, 현재 순회 순서와 차가 나온 순서를 비교하는 방법으로 정답을 구했기 때문이다
 * 4. 이 방식은 여러 오류가 있었기에 반례를 통해서 다른 방법을 모색하게 되었다
 * 5. 생각한 방법은 완전탐색이었다. 입력값과 시간 제한을 보면 완탐을 해도 시간초과가 발생하지 않기 때문에 완전탐색을 선택하였다
 * 6. 그전에 나온 차량의 값들은 리스트에 넣는다. 리스트에 넣은 값들을 완전탐색해서 나보다 작은 순서 번호가 내 뒤 리스트에 있는 경우 count 값을 올리기 break하도록했다
 * 7. 완성한 ans를 출력하면 정답이 된다
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String car = br.readLine();
            map.put(car, i);
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String car = br.readLine();
            list.add(map.get(car));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(list.get(i) > list.get(j)){
                    count++;
                    break;
                }
            }
        }



        bw.write(count+"");

        br.close();
        bw.close();
    }


}
