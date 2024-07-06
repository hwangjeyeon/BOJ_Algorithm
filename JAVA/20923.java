import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 1. 각각 가지고 있는 덱 -> 덱 자료구조 사용
 * 2. 그라운드에 쌓이는 카드더미 -> 덱 자료구조 사용
 *
 * - 그라운드에 나와 있는 각각의 카드 더미에서 가장 위에 위치한 카드의 숫자 합이 5가 되는 순간 수연이가 종을 친다. 단, 어느 쪽의 그라운드도 비어있으면 안된다.
 * -> 각 숫자의 합이 5이면서 양쪽 덱의 크기가 0이 아닌 경우,
 * 그라운드에 나와 있는 각각의 카드 더미 중 가장 위에 위치한 카드의 숫자가 5가 나오는 순간 도도가 종을 친다.
 * -> 양쪽 덱의 맨 뒤에 있는 값이 5인 경우
 *
 * - 종을 쳤다면, 상대방의 그라운드에 있는 카드 더미를 뒤집어 자신의 덱 아래로 그대로 합친 후 자신의 그라운드에 있는 카드 더미 역시 뒤집어 자신의 덱 아래로 그대로 가져와 합친다.
 * -> 상대방 덱 카드를 모두 내 덱 카드 앞에다가 넣는다. 이때 카드더미 아래부터 앞에다가 넣는다
 * -> 이어서 내 덱 카드를 내 덱 카드 앞에다가 넣는다. 이때 카드더미 아래부터 앞에다가 넣는다.
 *
 * - 종을 쳐서 그라운드에 있는 카드 더미를 가져가는 행위는 게임의 진행 순서에 영향을 미치지 않는다.
 * -> 하나의 순회 진행 중에 위 과정 검증
 *
 * - 게임 진행 도중 자신의 덱에 있는 카드의 수가 0개가 되면 상대방이 승리한 것으로 본다.
 *-> 만약 양쪽 그라운드 밖의 덱의 사이즈가 0인 경우 win 지정하고 break
 * - M번 진행한 후 자신의 덱에 더 많은 카드를 지닌 사람이 승리한다.
 * -> 순회 종료 후, win 이름이 없으면 양쪽 덱의 크기 비교해서 더 큰 쪽 win 이름 지정
 *
 * - M번 진행 후 각자의 덱에 있는 카드의 개수가 같다면 비긴 것으로 본다.
 * -> 위 과정에서 같다면 win 이름 dosu 지정
 * 
 * 1. 위 주어진 조건 해석에 맞게 해주면 된다
 * 2. 세가지 주의할 점이 있는데, 먼저 2~4번 과정이라고 나와있는 한명이 카드를 내려놓고 조건이 맞으면 카드 더미를 덱에 넣는 과정을 진행횟수 한번으로 봐야한다
 * 3. 따라서 도도가 내려놓을때랑 수연이 내려놓을 때를 각각의 진행 횟수로 봐야하므로 i를 짝수와 홀수로 구분해서 진행한다
 * 4. 또한 카드더미를 덱에 넣는 과정을 메소드로 빼서 공통적으로 처리하도록 했는데, 이때 순서를 잘 뒤집어야 한다. 5인 경우는 su덱을 먼저 넣고 합이 5인경우는 do덱을 먼저 넣어야 한다
 * 5. 그리고 덱에서 뽑고나서 덱이 비어있는지 검토하는 과정을 거치고 검증 과정 거치기 전에 꼭 카드더미에 뽑은 카드를 넣어주자!
 * 
 * 해결방법:
 *
 *
 * 시간복잡도: O(m + n)
 * 공간복잡도: O(n)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> doDeck = new ArrayDeque<>();
        Deque<Integer> suDeck = new ArrayDeque<>();

        Deque<Integer> doCard = new ArrayDeque<>();
        Deque<Integer> suCard = new ArrayDeque<>();

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            doDeck.addLast(Integer.parseInt(st.nextToken()));
            suDeck.addLast(Integer.parseInt(st.nextToken()));
        }
        String winner = "Not";
        for (int i = 0; i < m; i++) {
            if(i % 2 == 0){
                int doNumber = doDeck.pollLast();
                if(doDeck.isEmpty()){
                    winner = "su";
                    break;
                }
                doCard.addLast(doNumber);
                if(doNumber == 5){
                    cardArrange(doDeck, suCard, doCard);
                }


                if(!doCard.isEmpty() && !suCard.isEmpty()){
                    if(doCard.peekLast() + suCard.peekLast() == 5){
                        cardArrange(suDeck, doCard, suCard);
                    }
                }
            }else{
                int suNumber = suDeck.pollLast();
                if(suDeck.isEmpty()){
                    winner = "do";
                    break;
                }
                suCard.addLast(suNumber);
                if(suNumber == 5){
                    cardArrange(doDeck, suCard, doCard);
                }

                if(!doCard.isEmpty() && !suCard.isEmpty()){
                    if(doCard.peekLast() + suCard.peekLast() == 5){
                        cardArrange(suDeck, doCard, suCard);
                    }
                }

            }


        }

        if(winner.equals("Not")){
            if(doDeck.size() > suDeck.size()){
                winner = "do";
            }else if(doDeck.size() < suDeck.size()){
                winner = "su";
            }else{
                winner = "dosu";
            }
        }

        bw.write(winner);

        br.close();
        bw.close();
    }

    private static void cardArrange(Deque<Integer> dosuDeck, Deque<Integer> doCard, Deque<Integer> suCard) {
        while (!doCard.isEmpty()){
            dosuDeck.addFirst(doCard.pollFirst());
        }

        while(!suCard.isEmpty()){
            dosuDeck.addFirst(suCard.pollFirst());
        }
    }

}

