import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이 문제는 두가지 키포인트를 잡아야한다. TreeSet, Map, TreeSet을 타입으로 갖는 List를 활용해서 해결한다. TreeMap을 단순 활용하는 문제가 아니다
 * 2. 두번째, 유형이 3가지 이상이면 TreeMap 같은거는 지양하자. 그냥 클래스 만들어서 관리하자
 * 3. 두가지 유형의 클래스를 만들었다 첫번째는 문제번호와 난이도를 갖는 클래스, 두번째는 난이도와 알고리즘 분류는 갖는 클래스다
 * 4. TreeSet에는 문제번호와 난이도를 갖는 클래스를 넣어주고, 정렬은 오름차순으로 통일하며 난이도 -> 문제번호 순으로 정렬한다
 * 5. TreeSet을 선택한 이유는 '이전에 추천 문제 리스트에 있던 문제 번호가 다른 난이도와 다른 알고리즘 분류로 다시 들어 올 수 있다.'는 조건때문이다
 * 6. 이어서 정렬이 필요없는 난이도와 유형 필드를 갖는 문제는 단순 HashMap으로 관리한다
 * 7. 또한 문제 번호를 기준으로 문제번호와 난이도를 찾아야하므로 TreeSet을 타입으로 하는 리스트를 만들어 관리한다
 * 8. add는 입력과 동일하게, solved는 remove로 생각하면 된다
 * 9. recommend들은 x에 따라 분류해서 출력하면 된다.
 * 10. recommend, recommend2는 last와 first를 이용해서 출력하면 되고, recommend3는 higher과 lower을 이용해서 출력하면 된다
 *
 *
 * (참고. 우선순위 큐 6개 쓰면 해결할 수 있다. 이후 도전해볼 계획)
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(nlogn)
 *
 */

class Problem{
    int num;
    int difficulty;

    public Problem(int num, int difficulty) {
        this.num = num;
        this.difficulty = difficulty;
    }
}

class Problem2{
    int difficulty;
    int type;

    public Problem2(int difficulty, int type) {
        this.difficulty = difficulty;
        this.type = type;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Problem> pb1 = new TreeSet<>((o1, o2)->{
            if(o1.difficulty == o2.difficulty){
                return o1.num - o2.num;
            }
            return o1.difficulty - o2.difficulty;
        });
        Map<Integer, Problem2> pb2 = new HashMap<>();
        List<TreeSet<Problem>> list = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            list.add(new TreeSet<>((o1, o2)->{
                if(o1.difficulty == o2.difficulty){
                    return o1.num - o2.num;
                }
                return o1.difficulty - o2.difficulty;
            }));
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pb1.add(new Problem(a,b));
            pb2.put(a, new Problem2(b,c));
            list.get(c).add(new Problem(a,b));
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            switch(command[0]) {
                case "add":
                    int a = Integer.parseInt(command[1]);
                    int b = Integer.parseInt(command[2]);
                    int c = Integer.parseInt(command[3]);
                    pb1.add(new Problem(a,b));
                    pb2.put(a, new Problem2(b,c));
                    list.get(c).add(new Problem(a,b));
                    break;
                case "recommend":
                    int x = Integer.parseInt(command[1]);
                    int y = Integer.parseInt(command[2]);
                    if(y == 1){
                        bw.write(list.get(x).last().num+ "\n");
                    }else{
                        bw.write(list.get(x).first().num+ "\n");
                    }

                    break;
                case "recommend2":
                    int x2 = Integer.parseInt(command[1]);
                    if(x2 == 1){
                        bw.write(pb1.last().num+ "\n");
                    }else{
                        bw.write(pb1.first().num+ "\n");
                    }

                    break;
                case "recommend3":
                    int x3 = Integer.parseInt(command[1]);
                    int y3 = Integer.parseInt(command[2]);
                    if(x3 == 1){
                        Problem tmp = new Problem(-1, y3);
                        bw.write((pb1.higher(tmp) == null ? -1 : pb1.higher(tmp).num) +"\n");
                    }else{
                        Problem tmp = new Problem(-1, y3);
                        bw.write((pb1.lower(tmp) == null ? -1 : pb1.lower(tmp).num)+"\n");
                    }

                    break;
                case "solved":
                    int num = Integer.parseInt(command[1]);
                    int difficulty = pb2.get(num).difficulty;
                    int type = pb2.get(num).type;
                    pb1.remove(new Problem(num,difficulty));
                    pb2.remove(num);
                    list.get(type).remove(new Problem(num, difficulty));

                    break;
            }

        }

        br.close();
        bw.close();
    }

}
