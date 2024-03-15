import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 회문인지 먼저 체크하고 아니면 유사회문인지 체크하고 둘다 아니면 일반 문자로 판단하면 된다
 * 2. 투포인터를 이용해서 양 끝에 포인터를 배치한다
 * 3. 먼저 두 포인터가 만나는 지점까지 두 문자의 같음이 계속되면 회문으로 판단한다
 * 4. 만약 도중에 같지 않음이 하나일 경우, 유사회문으로 판단하고 둘 이상일 경우, 일반 문자로 판단한다
 * 5. 두 문자가 같으면 왼쪽은 증가 오른쪽은 감소한다
 * 6. 두 문자가 다르면 왼쪽+1과 현재 오른쪽이 같은지 먼저 검사하고, 같으면 왼쪽을 증가시키며 아닐 경우, 반대도 검사해서 똑같이 해준다
 * 7. 6번에 해당하지 않는 경우, 일반 문자이고 해당되면서, 쭉 검사했을 때 같지 않은 개수가 더 증가하지 않으면 유사회문이다.
 *
 *
 * - 문제 해결:
 * 1. if로 검사하지 않고 각각 한쪽 방향으로 while문을 통해 검사를 해줘야 한다
 * 2. 그래서 if문으로 검사하면, 먼저 검사를 시작하는 쪽으로 확정되고 그 다음은 검사를 하지 않게 되어서 예상했던 답과 다르게 되는 문제가 발생한다
 * 3. 따라서 각각을 while문으로 검사하고, 두 결과를 비교해서 값을 따로 판단해줘야 한다
 * 4. 각각을 판단하는 동안 같은 문자가 없으면 count값을 증가시켜준다.
 * 5. 그리고 시작 전에 count를 1 증가시켜줘야 한다. 어쨌든 간에 같지 않은 값이 발견 되었기 때문이다.
 * 6. 그리고 5번을 하는 가장 큰 이유는 두 start와 end사이에 아무런 문자가 없는 즉, 서로 한칸 차이인 경우떄문이다. 이경우, 왼쪽 오른쪽 탐색에서 값이 증가되지 않고 0으로 출력될 수 있다. 값이 다른 경우가 있는데도 말이다
 * 7. 그리고 6번의 경우에는 하나만 교체하면 바꿀 수 있는 유사 회문이다. 따라서 1로 지정해줘서 이런 예외를 처리하는 것이다.
 *
 *
 * => 너무 안일하게 풀었던 문제이다. 골드문제는 더 깊이 고민하고, 반례를 더 생각해서 푸는 연습을 하자 
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            int start = 0;
            int end = input.length()-1;
            int count = 0;
            while(start <= end){
                if(input.charAt(start) == input.charAt(end)){
                    start++;
                    end--;
                }else{
                    count = 1;
                    int left = start + 1;
                    int right = end;
                    while(left <= right){
                        if(input.charAt(left) == input.charAt(right)){
                            left++;
                            right--;
                        }else{
                            count++;
                            break;
                        }
                    }

                    left = start;
                    right = end-1;
                    while(left <= right){
                        if(input.charAt(left) == input.charAt(right)){
                            left++;
                            right--;
                        }else{
                            count++;
                            break;
                        }
                    }
                    break;
                }
            }

            if(count >= 2){
                bw.write(count - 1 + "\n");
            }else{
                bw.write(count + "\n");
            }




        }


        br.close();
        bw.close();
    }
}

