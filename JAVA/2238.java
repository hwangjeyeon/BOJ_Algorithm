import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이름, 참여자가 부른 비용, 참여 순서를 필드로 갖는 Auction 클래스를 만들어서 이를 활용하였다.
 * - 이어서 최대 입력값을 봤을 때, 시간초과를 하지 않으므로, 각 숫자를 인덱스 번호로 하는 배열을 만들어서 참여자가 부른 비용 빈도수를 저장한다
 * - 이를 이용해서 인덱스 번호 별로 순회했을 때, 0을 제외한 가장 작은 인덱스를 찾는다
 * - 이후 리스트에 담긴 Auction 클래스들을 순회하여, 해당 인덱스와 같은 비용의 인스턴스를 찾아, 그중 가장 순서가 빠른 인스턴스를 정답으로 한다
 * - 이렇게 완성된 정답을 출력한다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Auction{
    private final String name;
    private final int money;
    private final int Order;

    public Auction(String name, int money, int order) {
        this.name = name;
        this.money = money;
        this.Order = order;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getOrder() {
        return Order;
    }
}



public class Main {

    static int[] moneyCounts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        moneyCounts = new int[u+1];
        Auction auctionMember;
        List<Auction> auctionMembers = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());
            auctionMember = new Auction(name, money, i);
            auctionMembers.add(auctionMember);
            moneyCounts[money]++;
        }

        long minCounts = 10001;
        long minIndex = 10001;
        for(int i=0; i<=u; i++){
            if(moneyCounts[i] == 0){
                continue;
            }
            if(minCounts > moneyCounts[i]){
                minCounts = moneyCounts[i];

                if(minCounts == moneyCounts[i]){
                    minIndex = i;
                }
            }
        }
        String ansName = "";
        long ansMoney = 0;
        long ansOrder = 100001;
        for (Auction member : auctionMembers) {
            if(member.getMoney() == minIndex){
                if(member.getOrder() < ansOrder){
                    ansName = member.getName();
                    ansMoney = member.getMoney();
                    ansOrder = member.getOrder();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(ansMoney != 0 || ansOrder != 100001){
            sb.append(ansName)
                    .append(" ")
                    .append(ansMoney);
            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }

}
