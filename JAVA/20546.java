import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 두 사람의 현금과 보유 주식을 계산할 클래스를 만든다
 * 2. 이후 입력값을 받아 현금을 각 사람에게 입력하고, 전체 주식 정보는 배열에 저장한다
 * 3. 먼저 준현이의 경우를 계산한다. 단순히 보유 현금보다 현재 주가가 작거나 같다면 일단 그만큼 사서 보유 주식에 더한다
 * 4. 이어서 성민이의 경우를 계산한다. 전날과 비교해야하기 때문에, 1부터 순회한다
 * 5. 처음에는 무조건 가격이 될 떄 전량 매수하는줄 알았는데, 그게 아니였다. 상승치 하락치가 3일이 되었을 때만 전량 매수 전량매도하면 된다.
 * 6. 전날과 비교를 한다. 만약 상승이나 하락이면 그에 맞는 변수의 수치를 증가시킨다. 이때 다른 한쪽에는 반드시 0을 넣어줘야한다
 * 7. 이어서 상승이나 하락의 변동 수치가 3이라면 상승일 경우 현재 가진 돈을 전부 팔아 보유 재산에 더해주고, 주식의 개수도 감소시킨다.
 * 8. 각각이 3이 되었을 때를 검증할 때 반대 측에는 0으로 만들어주어야 함을 잊지 말자
 * 9. 이렇게 하고 각각을 정해진 공식대로 계산해서 비교한 뒤, 비교 결과에 따라 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

class Pair{
    int money;
    int stock;

    public Pair(int money, int stock) {
        this.money = money;
        this.stock = stock;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pair one = new Pair(n, 0);
        Pair two = new Pair(n, 0);

        int[] stockInfo = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stockInfo[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            if(stockInfo[i] <= one.money){
                one.stock += (one.money / stockInfo[i]);
                one.money = one.money % stockInfo[i];
            }
        }

        int increase = 0;
        int decrease = 0;
        for (int i = 1; i < 14; i++) {
            if(stockInfo[i-1] < stockInfo[i]){
                increase++;
                decrease = 0;
            }else if(stockInfo[i-1] > stockInfo[i]){
                decrease++;
                increase = 0;
            }

            if(increase == 3){
                two.money += (two.stock * stockInfo[i]);
                two.stock = 0;
                increase = 0;
            }else if(decrease == 3){
                two.stock += (two.money / stockInfo[i]);
                two.money = two.money % stockInfo[i];
                decrease = 0;
            }
        }

        int count1 = one.money + one.stock*stockInfo[13];
        int count2 = two.money + two.stock*stockInfo[13];

        if(count1 > count2){
            bw.write("BNP");
        }else if(count1 < count2){
            bw.write("TIMING");
        }else{
            bw.write("SAMESAME");
        }
        
        br.close();
        bw.close();
    }
}

