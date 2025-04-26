import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 방의 관점에서 접근하면 너무 어려운 문제다
 * 2. 유저의 관점에서 접근해야지 쉽게 해결할 수 있다
 * 3. 먼저 유지의 정보를 클래스로 만들어두자. 이 유저가 방에 속했는지까지 확인하려면 최소 3개의 속성은 필요하기 때문이다
 * 4. 미리 유저 정보를 담을 유저 클래스 배열을 하나 만들어두고, 유저 정보를 모두 배열에 담아두자
 * 5. 그리고 담은 순서대로 순회를하는데, 이때 방을 하나씩 만들어두자
 * 6. 그리고 현재 유저가 만약 방에 속하지 않았다면, 다시 모든 유저들을 확인하며 순회를 돌자. 시작은 현재 유저의 순번인 i부터 시작한다
 * 7. 방의 크기가 m이면 탈출하고 아니면 j번째 유저를 방에 넣어준다. 그 유저가 방에 속했는지와 범위를 벗어나는지 여부만 체크해주면 된다
 * 8. 이후 방을 이름순으로 오름차순 정렬해주고 방의 크기가 m이면 start 아니면 waiting을 출력한다
 * 9. 이후 방에 있는 모든 유저들을 뽑아내서 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(p^2)
 * 공간복잡도: O(p)
 *
 */

class Player {
    int num;
    String name;
    boolean check;

    Player(int num, String name) {
        this.num = num;
        this.name = name;
    }
}

public class Main {

    static final String start = "Started!";
    static final String waiting = "Waiting!";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            players[i] = new Player(l,n);
        }

        for (int i = 0; i < p; i++) {
            List<Player> rooms = new ArrayList<>();
            if(!players[i].check){
                for (int j = i; j < p; j++) {
                    if(rooms.size() == m){
                        break;
                    }
                    int l = players[j].num;
                    String n = players[j].name;
                    if(!players[j].check && players[i].num - 10 <= l && players[i].num + 10 >= l){
                        players[j].check = true;
                        rooms.add(new Player(l, n));
                    }
                }

                Collections.sort(rooms, (o1, o2) -> o1.name.compareTo(o2.name));
                if(rooms.size() == m){
                    bw.write(start+"\n");
                }else{
                    bw.write(waiting+"\n");
                }
                for (Player room : rooms) {
                    bw.write(room.num + " " + room.name +"\n");
                }
            }
        }

        br.close();
        bw.close();

    }
}
