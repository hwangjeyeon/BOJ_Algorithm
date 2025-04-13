import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 깡 구현 문제다.. 인덱스 크기를 잘 비교해서 구현하자
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        int[] kingPos = new int[2];
        kingPos[0] = king.charAt(0) - 'A' + 1; // x
        kingPos[1] = Character.getNumericValue(king.charAt(1)); // y
        String stone = st.nextToken();
        int[] stonePos = new int[2];
        stonePos[0] = (stone.charAt(0) - 'A') + 1; // x
        stonePos[1] = Character.getNumericValue(stone.charAt(1)); // y
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.equals("R") && kingPos[0] < 8){
                kingPos[0]++;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[0] < 8){
                        stonePos[0]++;
                    }else{
                        kingPos[0]--;
                    }
                }
            }else if(s.equals("L") && kingPos[0] > 1){
                kingPos[0]--;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[0] > 1){
                        stonePos[0]--;
                    }else{
                        kingPos[0]++;
                    }
                }
            }else if(s.equals("B") && kingPos[1] > 1){
                kingPos[1]--;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[1] > 1){
                        stonePos[1]--;
                    }else{
                        kingPos[1]++;
                    }
                }
            }else if(s.equals("T") && kingPos[1] < 8){
                kingPos[1]++;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[1] < 8){
                        stonePos[1]++;
                    }else{
                        kingPos[1]--;
                    }
                }
            }else if(s.equals("RT") && kingPos[0] < 8 && kingPos[1] < 8){
                kingPos[0]++;
                kingPos[1]++;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[0] < 8 && stonePos[1] < 8){
                        stonePos[0]++;
                        stonePos[1]++;
                    }else{
                        kingPos[0]--;
                        kingPos[1]--;
                    }
                }
            }else if(s.equals("LT") && kingPos[0] > 1 && kingPos[1] < 8){
                kingPos[0]--;
                kingPos[1]++;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[0] > 1 && stonePos[1] < 8){
                        stonePos[0]--;
                        stonePos[1]++;
                    }else{
                        kingPos[0]++;
                        kingPos[1]--;
                    }
                }
            }else if(s.equals("RB") && kingPos[0] < 8 && kingPos[1] > 1){
                kingPos[0]++;
                kingPos[1]--;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[0] < 8 && stonePos[1] > 1){
                        stonePos[0]++;
                        stonePos[1]--;
                    }else{
                        kingPos[0]--;
                        kingPos[1]++;
                    }
                }
            }else if(s.equals("LB") && kingPos[0] > 1 && kingPos[1] > 1){
                kingPos[0]--;
                kingPos[1]--;
                if(kingPos[0] == stonePos[0] && kingPos[1] == stonePos[1]){
                    if(stonePos[0] > 1 && stonePos[1] > 1){
                        stonePos[0]--;
                        stonePos[1]--;
                    }else{
                        kingPos[0]++;
                        kingPos[1]++;
                    }
                }
            }
        }
        char a = (char) (kingPos[0] + 'A' - 1);
        bw.write(a + ""+(kingPos[1])+"\n");
        bw.write((char)(stonePos[0] +'A' -1) + "" + (stonePos[1]));


        br.close();
        bw.close();

    }
}
