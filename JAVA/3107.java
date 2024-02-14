import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음에 String변수로 하려고 했다가 제약이 많아서 StringBuilder를 사용하게 되었다.
 * - 앞으로 문자열 문제는 StringBuilder를 사용하자
 * - 먼저 ::가 있는지 체크를 한다. 있으면 그 사이에 G를 넣어서 구분을 해준다
 * - G가 있는 경우는 앞에 얼만큼 섹션이 있는지 확인 후 스킵해주고, 그 외에는 ':'를 기준으로 그 앞에 문자가 길이가 4이면 그대로 정답 문자열에 넣어주고 ":"를 넣는다
 * - 만약 길이가 4가 아니면 그만큼 앞에 0으로 채워주고 나머지 문자를 더한다음 ":"를 추가해서 넣어준다
 * - 이것을 문자 끝까지 반복하고, 순회를 마친다
 * - 이어서 ipv6가 각 총 8가지 섹션으로 나뉘는 것을 이용해서 섹션의 크기가 8보다 작으면 그룹 문자열이 있다는 것을 의미하므로 8- sectionCount만큼 "0000:"을 만들어준다
 * - 그 다음 앞에 있는 섹션의 수를 의미하는 before 변수 크기 *5 (숫자*4+":"*1)만큼 뒤 위치에 앞서 만든 "0000:"를 insert한다
 * - 마지막으로 맨 뒤에 있는 문자가 ":"이면 제거하고 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ipv6Reduce = new StringBuilder(br.readLine());
        int colonCount = 0;
        int sectionCount = 0;
        StringBuilder ipv6 = new StringBuilder();
        String tmp = "";
        int a = 0;
        while(a < ipv6Reduce.length()){
            if(ipv6Reduce.charAt(a) == ':' && ipv6Reduce.charAt(a+1) == ':'){
                ipv6Reduce.insert(a+1,"G");
                break;
            }
            a++;
        }

        for (int i = 0; i < ipv6Reduce.length(); i++) {
            if(ipv6Reduce.charAt(i) == ':'){
                colonCount++;
            }
        }


        int before = 0;
        for (int i = 0; i < ipv6Reduce.length(); i++) {
            if(ipv6Reduce.charAt(i) == 'G'){
                before = sectionCount;
                i++;
                continue;
            }

            if(ipv6Reduce.charAt(i) == ':'){
                sectionCount++;
                if(tmp.length() == 4){
                    ipv6.append(tmp);
                    ipv6.append(":");
                }else{
                    for (int j = 0; j < 4 - tmp.length(); j++) {
                        ipv6.append("0");
                    }
                    ipv6.append(tmp);
                    ipv6.append(":");
                }

                tmp = "";
                continue;
            }
            tmp += ipv6Reduce.charAt(i);
            if(i == ipv6Reduce.length()-1){
                if(tmp.length() == 4){
                    ipv6.append(tmp);
                    ipv6.append(":");
                }else{
                    for (int j = 0; j < 4 - tmp.length(); j++) {
                        ipv6.append("0");
                    }
                    ipv6.append(tmp);
                }
                sectionCount++;
            }
        }

        tmp = "";
        if(sectionCount < 8){
            for (int i = 0; i < 8 - sectionCount; i++) {
                tmp += "0000:";
            }
            ipv6.insert(before*5, tmp);
        }

        if(ipv6.toString().charAt(ipv6.length()-1)== ':'){
            ipv6.delete(ipv6.length()-1, ipv6.length());
        }

        System.out.println(ipv6);
        br.close();
        bw.close();
    }

}

