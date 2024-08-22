import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 시작시간과 종료시간, 그리고 종료시간과 숫자를 구분해줄 클래스를 두개 선언한다
 * 2. 먼저 입력값은 시작 시간 순서대로 뽑기 위해 시작시간을 기준으로 오름차순 정렬된 우선순위 큐를 만들어 넣어준다
 * 3. 이어서 두개의 우선순위 큐를 만든다. 하나는 방의 번호를 오름차순으로 정렬하는 우선순위 큐고, 나머지 하나는 방을 사용하고 있는 유저들을 관리할 우선순위 큐다
 * 4. 방을 관리하는 우선순위 큐는 종료시간을 기준으로 오름차순 정렬을 한다
 * 5. 번호를 관리하는 우선순위 큐는 1부터 10만까지 미리 초기화해넣는다
 * 6. 이제 n만큼 순회하며 방에 사람을 넣는다. 이때, 방 번호별 들어간 사람의 수와 전체 필요한 방의 수를 구하기 위해 Map을 하나 더 사용한다
 * 7. 또한 방이 비어있지 않으면서 방의 종료시간이 현재 인원의 시작시간보다 작은동안 방에 있는 사람을 빼주고, 그 숫자를 방번호를 관리하는 우선순위 큐에 넣는다
 * 8. 이렇게 완성한 map의 크기와, 각 map의 값들을 for-each로 돌아 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Person{
    int start;
    int end;

    public Person(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Room{
    int end;
    int number;

    public Room(int end, int number) {
        this.end = end;
        this.number = number;
    }
}

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Person> pairs = new PriorityQueue<>((o1, o2)->{
            if(o1.start == o2.start){
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pairs.add(new Person(start, end));
        }
        PriorityQueue<Integer> number = new PriorityQueue<>();
        PriorityQueue<Room> room = new PriorityQueue<>((o1,o2) -> {
            if(o1.end == o2.end){
                return o1.number - o2.number;
            }
            return o1.end - o2.end;
        });

        for (int i = 1; i < 100001; i++) {
            number.add(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while(!room.isEmpty() && room.peek().end < pairs.peek().start){
                number.add(room.poll().number);
            }
            Person person = pairs.poll();
            int num = number.poll();
            map.put(num, map.getOrDefault(num, 0) + 1);

            room.add(new Room(person.end, num));
        }

        bw.write(map.size()+"\n");
        for (Integer value : map.values()) {
            bw.write(value +" ");
        }
        


        br.close();
        bw.close();
    }
}

