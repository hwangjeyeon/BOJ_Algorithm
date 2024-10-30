import java.io.*;
import java.util.*;

/**
    1. 팔각의자는 문자 배열로 관리하자
    2. 회전 로직은 별도의 메소드로 만들어서 사용하자

*/


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        char[][] arr = new char[4][8];
        for(int i=0; i<4; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 회전 전파 대상 의자 체크, 방향이 0이면 미대상 
            int[] chk = new int[4];
            chk[n-1] = d;
            rotateChk(arr, n, d, chk);


            // 대상 의사들 모두 회전
            rotate(arr, chk);

            // 12시 방향 남쪽지방 사람 착석 여부 확인
            // for(int j=0; j< 4; j++){
            //     for(int s=0; s<8; s++){
            //         System.out.print(arr[j][s]);
            //     }
            //     System.out.println();
            
            // }
            // System.out.println();
        }
        ans = (Character.getNumericValue(arr[0][0]) == 1 ? 1 : 0) * 1 
        + (Character.getNumericValue(arr[1][0]) == 1 ? 1 : 0) * 2
        + (Character.getNumericValue(arr[2][0]) == 1 ? 1 : 0) * 4
        + (Character.getNumericValue(arr[3][0]) == 1 ? 1 : 0) * 8;
        // for(int i=0; i< 4; i++){
        //     for(int j=0; j<8; j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }

        System.out.print(ans);

    }

    private static void rotate(char[][] arr, int[] chk){
        for(int i=0; i<chk.length; i++){
            // System.out.println(chk[i]);
            if(chk[i] == 0){
                continue;
            }

            if(chk[i] == 1){
                    char tmp = arr[i][7];
                    List<Character> list = new ArrayList<>();
                    list.add(tmp);

                    for(int k=0; k<7; k++){
                        list.add(arr[i][k]);
                    }

                    for(int k=0; k<8; k++){
                        arr[i][k] = list.get(k);
                    }
                }else if(chk[i] == -1){
                    char tmp = arr[i][0];
                    List<Character> list = new ArrayList<>();
                    for(int k=1; k<8; k++){
                        list.add(arr[i][k]);
                    }
                    list.add(tmp);

                    for(int k=0; k<8; k++){
                        arr[i][k] = list.get(k);
                    }
                }
        }
    }

    
    private static void rotateChk(char[][] arr, int n, int d, int[] chk){
        
        if(n == 1){
            int tmp = d;
            for(int i=0; i<3; i++){
                
                if(arr[i][2] != arr[i+1][6]){
                    tmp = -tmp;
                    chk[i+1] = tmp;
                    continue;
                }

                break;
            }
        }else if(n == 2){
            if(arr[0][2] != arr[1][6]){
                chk[0] = -d;
            }
            int tmp = d;
            for(int i=1; i<3; i++){
                
                if(arr[i][2] != arr[i+1][6]){
                    tmp = -tmp;
                    chk[i+1] = tmp;
                    continue;
                }
                break;
            }


        }else if(n == 3){
            int tmp = d;
            for(int i=2; i>0; i--){
                if(arr[i][6] != arr[i-1][2]){
                    tmp = -tmp;
                    chk[i-1] = tmp;
                    continue;
                }
                
                break;
            }

            if(arr[2][2] != arr[3][6]){
                chk[3] = -d;
            }

        }else{
            int tmp = d;
            for(int i=3; i>0; i--){
                
                if(arr[i][6] != arr[i-1][2]){
                    tmp = -tmp;
                    chk[i-1] = tmp;
                    continue;
                }
                break;
            } 
        }


    }

}