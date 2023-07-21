#include <iostream>
#include <vector>
#include <stack>


/*풀이방법:
 * 입력 숫자랑 같아질 때까지 첫줄에 입력한 숫자까지 반복해서 스택에 push한다.
 * 입력 예제 1번을 확인했을 때, 4가 나올때까지 스택에 1,2,3,4를 push하고 스택의 top과 입력값이 같으니 pop을 해준다
 * 3까지 pop하고 6을 봤을 때 스택의 top과 같지 않으니 이전에 4까지 스택에 push했으니까 이제 5를 push하고 비교하고 다시 6을 비교하고 push한다
 * 이러한 과정을 통해 반복문이 끝났을 때, 정상적이라면 스택은 비어있을 것이다 이를 활용하여 비어있지 않으면 NO, 비어있으면 그대로 출력한다
 * 1. 배열을과 스택과 문자열 변수를 준비한다
 * 2. 입력값을 배열에 저장한다
 * 3. 반복문을 돌리는데 1부터 입력값 n까지 돌리게 된다. 먼저 값을 push 해주고, 해당 값이 비어있지 않고, 스택의 탑이 아까 입력 받았던 값과 같은지 확인
 * 4. 같으면 스택을 pop하고 문자열에 추가하며 count 값을 올려 다음 입력값을 확인하기 위한 준비를 한다
 * 5. 해당 과정을 반복하여 최종 문자열을 출력하며, 반복문이 끝날때까지 스택을 비우지 못하는 경우 NO를 출력한다
 */



using namespace std;

int main() {

   int n;
   cin >> n;

   vector<int> a(n + 1);
   stack<int> b;
   string c;

   for (int i = 0; i < n; i++) {
      cin >> a[i];
   }

   int count = 0;

   for (int i = 1; i <= n; i++) {
      b.push(i);
      c += "+\n";
         while (!b.empty() && b.top() == a[count]) {
            b.pop();
            c+="-\n";
            count++;
         }
   }

   if (!b.empty()) {
      cout << "NO";
   }else {
         cout << c;
   }

}

