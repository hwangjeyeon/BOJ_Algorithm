import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 구현 로직 30분 디버깅 2시간 반...
 * - 디버깅을 줄이기 위한 방법을 찾아야겠다
 * - 주어진 조건대로 로직을 구현하면 된다.
 * - 계속 한두개 예제 답이 안나와서 해맸는데, 결국은 시계방향으로 돌때 i+1에 저장한 값을 그대로 다시 재사용해서 문제가 발생했었던 것이었다.
 * - 이 부분 해결하니까 바로 정답..
 * - 꾸준히 깡구현 문제를 풀면서 성장해나가야겠다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */
class Gear{
    char[] wheel;

    public Gear(char[] wheel) {
        this.wheel = wheel;
    }

}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Gear[] gears = new Gear[4];
        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear(br.readLine().toCharArray());
        }
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int point = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            rotateEvent(gears, number, direction);
        }

        point = getPoint(gears, point);


        bw.write(String.valueOf(point));
        br.close();
        bw.close();
    }

    private static void rotateEvent(Gear[] gears, int number, int direction) {
        char[] allGearLeftWheel = new char[4];
        char[] allGearRightWheel = new char[4];


        for (int i = 0; i < 4; i++) {
            allGearLeftWheel[i] = gears[i].wheel[6];
            allGearRightWheel[i] = gears[i].wheel[2];
        }


        //현재 톱니바퀴 방향대로 회전
        if(direction == 1){
            char nowLastWheel = gears[number-1].wheel[7];
            char now_tmp;
            char next_tmp = gears[number-1].wheel[0];
            for (int i = 0; i < 7; i++) {
                now_tmp = next_tmp;
                next_tmp = gears[number-1].wheel[i+1];
                gears[number-1].wheel[i+1] = now_tmp;
            }
            gears[number-1].wheel[0] = nowLastWheel;
        }else{
            char nowFirstWheel = gears[number-1].wheel[0];
            for (int i = 1; i < 8; i++) {
                gears[number-1].wheel[i-1] = gears[number-1].wheel[i];
            }
            gears[number-1].wheel[7] = nowFirstWheel;
        }



        //왼쪽
        int leftDirection = direction;
        int leftPos = number-2;
        char nowLeftWheel = allGearLeftWheel[number-1];
        while(leftPos >= 0){
            if(nowLeftWheel == allGearRightWheel[leftPos]){
                break;
            }

            if(leftDirection == 1){
                char nowFirstWheel = gears[leftPos].wheel[0];
                for (int i = 1; i < 8; i++) {
                    gears[leftPos].wheel[i-1] = gears[leftPos].wheel[i];
                }
                gears[leftPos].wheel[7] = nowFirstWheel;

                leftDirection = -1;
            }else{
                char nowLastWheel = gears[leftPos].wheel[7];
                char now_tmp;
                char next_tmp = gears[leftPos].wheel[0];
                for (int i = 0; i < 7; i++) {
                    now_tmp = next_tmp;
                    next_tmp = gears[leftPos].wheel[i+1];
                    gears[leftPos].wheel[i+1] = now_tmp;
                }
                gears[leftPos].wheel[0] = nowLastWheel;

                leftDirection = 1;
            }
            nowLeftWheel = allGearLeftWheel[leftPos];
            leftPos--;
        }



        //오른쪽
        int rightDirection = direction;
        int rightPos = number;
        char nowRightWheel = allGearRightWheel[number-1];
        while(rightPos < 4){
            if(nowRightWheel == allGearLeftWheel[rightPos]){
                break;
            }
            if(rightDirection == 1){
                char nowFirstWheel = gears[rightPos].wheel[0];
                for (int i = 1; i < 8; i++) {
                    gears[rightPos].wheel[i-1] = gears[rightPos].wheel[i];
                }
                gears[rightPos].wheel[7] = nowFirstWheel;

                rightDirection = -1;
            }else{
                char nowLastWheel = gears[rightPos].wheel[7];
                char now_tmp;
                char next_tmp = gears[rightPos].wheel[0];
                for (int i = 0; i < 7; i++) {
                    now_tmp = next_tmp;
                    next_tmp = gears[rightPos].wheel[i+1];
                    gears[rightPos].wheel[i+1] = now_tmp;
                }
                gears[rightPos].wheel[0] = nowLastWheel;

                rightDirection = 1;
            }
            nowRightWheel = allGearRightWheel[rightPos];
            rightPos++;
        }

    }

    private static int getPoint(Gear[] gears, int point) {
        int points = point;
        for (int i = 0; i < 4; i++) {
            if(gears[i].wheel[0] == '0'){
                points += 0;
            }else{
                switch (i){
                    case 0:
                        points += 1;
                        break;
                    case 1:
                        points += 2;
                        break;
                    case 2:
                        points += 4;
                        break;
                    case 3:
                        points += 8;
                        break;
                }
            }
        }
        return points;
    }


}

