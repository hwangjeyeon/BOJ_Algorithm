import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 분기를 잘 줘야하는 문제다
 * 2. 경우의 수를 잘 따져보자. 골이 들어올때마다 우리가 판단해야할 것은 현재 스코어와 마지막으로 이겼던 팀의 정보이다
 * 3. 만약 스코어가 뒤집어지거나 같아진다면 마지막으로 이겼던 팀이 그 이전에 골 넣은 시간만큼의 시간점수를 얻게 된다
 * 4 이점을 이용해서 시간을 계산한다. 시간은 문제에서 가장 작은 단위인 초로 통일해서 계산한다
 * 5. String.format을 이용해서 주어진 형식에 맞게 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int lastT = 0;
        int lastWin = -1;

        int[] score = new int[2];
        int[] num = new int[2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken()) - 1;
            String[] time = st.nextToken().split(":");
            int nowM = Integer.parseInt(time[0]);
            int nowS = Integer.parseInt(time[1]);
            if(lastWin == -1){
                lastT = nowM*60 + nowS;
                lastWin = team;
                num[lastWin]++;
                continue;
            }
            if(num[0] > num[1]){
                lastWin = 0;
            }else if(num[0] < num[1]){
                lastWin = 1;
            }else{
                lastT = (nowM*60 + nowS);
                num[team]++;
                continue;
            }
            num[team]++;
            score[lastWin] += (nowM*60 + nowS) - lastT;
            lastT = (nowM*60 + nowS);
        }
        if(num[0] != num[1]){
            if(num[0] > num[1]){
                lastWin = 0;
            }else{
                lastWin = 1;
            }
            score[lastWin] += 48*60 - lastT;
        }

        bw.write(String.format("%02d",score[0]/60) + ":" + String.format("%02d", score[0]%60)
                + "\n" + String.format("%02d",score[1]/60) + ":" + String.format("%02d", score[1]%60));

        br.close();
        bw.close();

    }
}
