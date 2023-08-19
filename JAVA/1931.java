import java.io.*;
import java.util.*;


/**
 * 풀이 방법: 일단 입력은 C++에서 많이 쓰던 Pair로 받고 그리디 알고리즘을 이용해서 끝나는 시간이 빠른 회의 사간을 먼저 탐욕적으로 선택하는 방법을 이용해 풀었다.
 * 접근 방법: 시작 시간을 기준으로, 회의 시간이 짧은 것을 기준으로도 생각해보았으나 도저히 답이 나오지 않았고, 결국 3번째 경우인 끝나는 시간이 빠른 회의 시간을 기준으로 접근했다
 * 변수 선언:
 * List<Pair<Long, Long>> conference = 회의시간을 담는 리스트 배열
 * Long pivot = 비교를 위한 기준점 -> 회의 끝나는 시간이다.
 * int count = 정답 출력을 위한 변수로 끝나는 시간을 기준으로 오름차순 정렬하기 때문에, 무조건적으로 첫번째 회의는 선택되므로 1로 초기화한다.
 * 풀이 과정:
 * 1. 회의 시간을 입력받아 리스트에 저장한다 -> 이때 javafx 라이브러리의 Pair를 사용했는데 백준 컴파일러가 인식을 못해서 클래스를 만들었다
 * 2-1. 입력받은 리스트를 두가지 조건으로 오름차순 정렬한다.
 * 2-2. 먼저 회의 끝나는 시간인 value를 기준으로 오름차순 정렬한다
 * 2-3. value가 같은 경우 key를 기준으로 오름차순 정렬한다
 * 3. pivot에 리스트 배열의 첫번째 value값을 넣어주고 순차적으로 조회한다. 이때 키값이 pivot보다 크거나 같은 경우 count를 증가하고 그 값을 pivot에 넣는다
 * 4. 최종적으로 pivot을 출력한다.
 *
 */




class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }


    public V getValue() {
        return value;
    }

}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Pair<Long, Long>> conference = new ArrayList<>();
        int count = 1;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            conference.add(new Pair<>(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));
        }

        Collections.sort(conference, new Comparator<Pair<Long, Long>>() {
            @Override
            public int compare(Pair<Long, Long> pair1, Pair<Long, Long> pair2) {
                int compareValue = Long.compare(pair1.getValue(), pair2.getValue());
                if (compareValue == 0) {
                    return Long.compare(pair1.getKey(), pair2.getKey());
                }
                return compareValue;
            }
        });

        br.close();

        Long pivot = conference.get(0).getValue();
        for(int i=1; i<conference.size(); i++){
            if(pivot <= conference.get(i).getKey()){
               count++;
               pivot = conference.get(i).getValue();
            }
        }

        bw.write(count + "");
        bw.close();

    }
}
