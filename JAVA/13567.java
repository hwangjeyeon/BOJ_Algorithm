import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진대로 구현하면 된다. 자바를 쓰는만큼 최대한 객체지향적으로 하기 위해서 로봇이라는 객체를 만들고 그 안에서 주어진 동작을 하도록 구현하였다
 * 2. 방향은 0부터 3까지 각각 오른쪽, 아래, 왼쪽, 위쪽이다
 * 3. 로봇은 dir과 y, x좌표를 필드로 가지며 왼쪽으로 도는 경우와 오른쪽으로 도는 경우, 그리고 파라미터로 받는 거리만큼 현재 로봇의 방향에 따라 y,x좌표를 바꾸는 move 기능도 갖추고 있다
 * 4. TURN 명령어에서 0은 왼쪽으로 1은 오른쪽으로 방향을 튼다
 * 5. 아닌경우 move 기능으로 동작하는데, move 명령어를 실행 시킨 뒤, 인덱스 범위를 벗어나는지 체크한다
 * 6. 인덱스 범위를 벗어나는 경우 -1 출력을 위한 isOk를 false로 바꾸고 break한다.
 * 7. 이후 isOk가 false면 -1, 아니면 x, y축 순으로 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

class Robot{

    int dir;
    int y;
    int x;

    public Robot(int dir, int y, int x) {
        this.dir = dir;
        this.y = y;
        this.x = x;
    }


    public void turnLeft(){
        if(dir == 3){
            dir--;
        }else if(dir == 2){
            dir--;
        }else if(dir == 1){
            dir--;
        }else{
            dir = 3;
        }
    }

    public void turnRight(){
        if(dir == 0){
            dir++;
        }else if(dir == 1){
            dir++;
        }else if(dir == 2){
            dir++;
        }else{
            dir = 0;
        }
    }

    public void move(int a){
        if(dir == 0){
            this.x += a;
        }else if(dir == 1){
            this.y -= a;
        }else if(dir == 2){
            this.x -= a;
        }else{
            this.y += a;
        }
    }

}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(0, 0,0);
        boolean isOk = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int dis = Integer.parseInt(st.nextToken());
            if(order.equals("TURN")){
                if(dis == 0){
                    robot.turnLeft();
                }else{
                    robot.turnRight();
                }
            }else{
                robot.move(dis);
                if(robot.y < 0 || robot.x < 0 || robot.y > m || robot.x > m){
                    isOk = false;
                    break;
                }
            }
        }

        if(!isOk){
            bw.write("-1");
        }else{
            bw.write(robot.x + " " + robot.y);
        }


        br.close();
        bw.close();
    }
}

