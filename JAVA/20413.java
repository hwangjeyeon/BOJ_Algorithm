import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 현재 위치의 등급을 확인하고 그 등급의 다음 등급에 해당하는 기준치 - 1을 한다
 * 2. 이전달의 금액을 기준치-1에서 빼서 남는 금액이 이번달 과금액이다.
 * 3. 한가지 주의할점은 다이아 등급은 이전달 금액을 신경 안써도 된다. 그 이후 등급도 존재않아 신경쓸 부분이 없고, 매달 최대 결제 금액이 다이아 등급 기준액이라는 조건만 존재하기 때문이다.
 * 4. 위와같이 하여 ans에 값을 더해주면 정답이 된다.
 * 5. 이때 bill이라는 변수를 만들어서 이전 달의 금액을 관리하도록 해서 풀었다.
 *
 * 해결방법:
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
        int[] rank = new int[5];
        rank[0] = 0;
        for (int i = 1; i < 5; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }
        char[] mvp = new char[n];
        String tmp = br.readLine();
        for (int i = 0; i < n; i++) {
            mvp[i] = tmp.charAt(i);
        }
        int ans = 0;
        int[] bill = new int[n];
        if(mvp[0] == 'B'){
            bill[0] = rank[1] - 1;
        }else if(mvp[0] == 'S'){
            bill[0] = rank[2] -  1;
        }else if(mvp[0] == 'G'){
            bill[0] = rank[3] -  1;
        }else if(mvp[0] == 'P'){
            bill[0] = rank[4] -  1;
        }else if(mvp[0] == 'D'){
            bill[0] = rank[4];
        }
        ans += bill[0];
        for (int i = 1; i < n; i++) {
            if(mvp[i] == 'B'){
                bill[i] = rank[1] - 1 - bill[i-1];
            }else if(mvp[i] == 'S'){
                bill[i] = rank[2] -  1 - bill[i-1];
            }else if(mvp[i] == 'G'){
                bill[i] = rank[3] -  1 - bill[i-1];
            }else if(mvp[i] == 'P'){
                bill[i] = rank[4] -  1 - bill[i-1];
            }else if(mvp[i] == 'D'){
                bill[i] = rank[4];
            }
            ans += bill[i];
        }







        bw.write(ans+"");


        br.close();
        bw.close();
    }



}

