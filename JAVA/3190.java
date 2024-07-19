import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 뱀이 움직일 배열을 하나 만든다
 * 2. 사과의 위치를 입력 받아 배열의 판에 배정한다. 사과가 있는 위치는 1로 처리한다.
 * 3. 뱀의 상태를 저장할 클래스를 하나 만든다.
 * 3-1. 뱀의 상태로 현재 바라보는 방향, 몸의 길이, 현재 뱀의 몸이 있는 위치들을 필드로 받는다
 * 3-2. 뱀의 위치는 몸과 충돌하는 경우를 위해 덱 자료구조를 이용하여 관리한다.
 * 4. 뱀의 객체를 하나 생성해준다. 초기 방향은 R, 길이는 1, 현재 머리 위치, 꼬리위치는 0,0으로 한다.
 * 5. 주어진 규칙을 하나씩 진행한다. 먼저 뱀의 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 6. 해당 로직은 Move라는 별도의 메소드를 만들어 관리한다.
 * 7. 충돌 여부를 체크한다. finishCheck 메소드를 별도로 만들어서 관리한다
 * 7-1. 충돌 여부는 덱의 맨 앞값을 가져와서 y와 x좌표를 각각 검사한다. 모두 통과하면, 몸과 닿는지 확인하기 위해 덱의 앞에 값을 빼서 현재 위치와 검사하고 뒤에 다시 넣는 과정을 진행한다.
 * 8. 충돌하지 않았다면 해당 칸에 사과가 있는지 체크하고 있다면 몸의 길이를 증가시킨다. 그리고 반드시 사과를 지워야 한다
 * 9. 만약 없다면 꼬리의 길이를 감소시킨다. 덱에 끝에 있는 값을 하나 제거한다.
 * 10. 이제 방향 회전을 위해 Map다가 저장해둔 값들을 가져온다. 임의의 절대 나올 수 없는 값을 default로 해서 그 경우가 아닐경우, 방향을 회전시킨다
 * 11. 반복문을 탈출하면 time을 출력한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2*k)
 * 공간복잡도: O(n^2)
 *
 */


class Position{
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Snake{

    int direction;
    int length;
    Deque<Position> position = new LinkedList<>();

    public Snake(int direction, int length, Position position) {
        this.direction = direction;
        this.length = length;
        this.position.addFirst(position);
    }

    public void directionInit(){
        if(direction > 3){
            direction = 0;
        }

        if(direction < 0){
            direction = 3;
        }
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y-1][x-1] = 1;
        }

        Snake snake = new Snake(0, 1, new Position(0, 0));

        int l = Integer.parseInt(br.readLine());
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            map.put(time, direction);
        }


        int time = 0;
        Position now = new Position(0,0);
        while(true){
            time++;
            move(snake, now);
            if(finishCheck(snake, n, now)){
               break;
            }
            if(arr[now.y][now.x] == 1){
                arr[now.y][now.x] = 0;
                snake.length++;
            }else{
                snake.position.pollLast();
            }

            if(map.getOrDefault(time, 'F') != 'F'){
                directionChange(map.get(time), snake);
            }
        }

        bw.write(time+"");

        br.close();
        bw.close();
    }

    private static void move(Snake snake, Position now) {
        if(snake.direction == 0){
            now.x++;
        }else if(snake.direction == 2){
            now.x--;
        }else if(snake.direction == 3){
            now.y--;
        }else if(snake.direction == 1){
            now.y++;
        }
        snake.position.addFirst(new Position(now.y, now.x));
    }

    private static void directionChange(char direction,Snake snake) {
        if(direction == 'D'){
            snake.direction++;
            snake.directionInit();
        }else if(direction == 'L'){
            snake.direction--;
            snake.directionInit();
        }
    }

    private static boolean finishCheck(Snake snake, int n, Position now){
        if(snake.position.peekFirst().y >= n || snake.position.peekFirst().y < 0){
            return true;
        }

        if(snake.position.peekFirst().x >= n || snake.position.peekFirst().x < 0){
            return true;
        }
        int size = snake.position.size();
        for (int i = 0; i < size-1; i++) {
            Position position = snake.position.pollLast();
            if(now.y == position.y && now.x == position.x){
                return true;
            }
            snake.position.addFirst(position);
        }
        snake.position.addFirst(snake.position.pollLast());

        return false;
    }

}

