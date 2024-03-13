import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 일단 숫자로 출력하기 위해 스택을 사용해서 각각의 문자의 숫자 크기를 확인한다
 * 2. 비어있으면 일단 스택에 넣는다. 그 다음 값을 확인하고 만약 작은 숫자가 큰 숫자의 왼쪽에 오는 경우인 경우 그 숫자를 더해주고 continue한다
 * 3. 아닐 경우 pop하고 그 수에 해당하는 값을 ans에 더하고 현재 숫자를 스택에 넣는다.
 * 4. 이제 숫자를 문자로 변환해야 하는데 큰 수부터 차례대로 진행한다
 * 5. 1000 -> 900 -> 500 -> 400 -> 100 -> 90 -> 40 -> 10 -> 9 -> 4 -> 5 -> 1 순으로 진행한다
 * 6. 이어서 400부터는 V, L D에 대한 체크를 진행해준다.
 * 7. 세가지 분류로 체크해준다. 반복 가능한 경우, 반복이 안 되는 경우, 반복이 안 되면서 이미 문자열에 추가가 안된경우
 * 8. 이렇게 문자를 StringBuilder에 완성해주고 출력하면 정답이 된다.
 *
 * - 절차적으로 하니까 노가다가 심해서 함수형으로 바꿔서 풀었다. 앞으로 최대한 함수형으로 생각하도록 연습하자
 * - Stack의 contains와 StringBuilder의 indexOf랑 비슷하다 indexOf 결과가 false면 -1을 리턴한다
 * - 고정된 각 문자의 값 속성은 Map을 이용해서 쉽게 풀었다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(입력문자열 크기)
 * 공간복잡도: O(입력문자열 크기)
 *
 */


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int ans = 0;
        Stack<Character> stack = new Stack<>();
        ans += countCheck(first, stack, 0, map);
        ans += countCheck(second, stack, 0, map);


        parseNumberToString(ans);

        bw.write(ans+"\n");
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void parseNumberToString(int number){
        int count = 0;
        number = part1(count, number, 1000, "M");
        number = part2(number, 900, "CM");
        number = part2(number, 500, "D");
        number = part3(number, 400, "D", "CD");
        number = part1(count, number, 100, "C");
        number = part2(number, 90, "XC");
        number = part3(number, 50, "L", "L");
        number = part3(number, 40, "L", "XL");
        number = part1(count, number, 10, "X");
        number = part2(number, 9, "IX");
        number = part2(number, 5, "V");
        number = part3(number, 4, "V", "IV");

        while(count < 3 && number > 0){
            sb.append("I");
            number--;
            count++;
        }
    }

    private static int part3(int number, int a, String b, String s) {
        if(sb.indexOf(b) == -1 && number / a > 0){
            number -= a;
            sb.append(s);
        }
        return number;
    }

    private static int part2(int number, int a, String s) {
        if(number / a > 0){
            number -= a;
            sb.append(s);
        }
        return number;
    }

    private static int part1(int count, int number, int a, String message) {
        while (count < 3 && number / a > 0){
            number -= a;
            sb.append(message);
            count++;
        }
        return number;
    }

    private static int countCheck(char[] number, Stack<Character> stack, int ans, Map<Character, Integer> map) {
        for (int i = 0; i < number.length; i++) {
            if(stack.isEmpty()){
                stack.push(number[i]);
            }else{
                if(stack.peek() == 'I'){
                    if(number[i] == 'V'){
                        ans += 4;
                        stack.pop();
                        continue;
                    }else if(number[i] == 'X'){
                        ans += 9;
                        stack.pop();
                        continue;
                    }

                }else if(stack.peek() == 'X'){
                    if(number[i] == 'L'){
                        ans += 40;
                        stack.pop();
                        continue;
                    }else if(number[i] == 'C'){
                        ans += 90;
                        stack.pop();
                        continue;
                    }
                }else if(stack.peek() == 'C') {
                    if(number[i] == 'D'){
                        ans += 400;
                        stack.pop();
                        continue;
                    }else if(number[i] == 'M'){
                        ans += 900;
                        stack.pop();
                        continue;
                    }
                }
                ans += map.get(stack.pop());
                stack.push(number[i]);
            }
        }
        while(!stack.isEmpty()){
            ans += map.get(stack.pop());
        }
        return ans;
    }


}

