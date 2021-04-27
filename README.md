# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 숫자(BaseballGameNumber)
  * [x] 숫자는 1-9 까지 서로 다른 수로 이루어진 3자리의 수이다
* 결과(GameResult)
  * [x] 정답 또는 힌트를 제공한다
  * [x] 같은 수가 같은 자리에 있으면 스트라이크이다.
  * [x] 같은 수가 다른 자리에 있으면 볼이다.
  * [x] 같은 수가 전혀 없으면 낫싱이다. 
* 상대방(GameOperatorTest)
  * [x] 1-9 까지 서로 다른 임의의 수 3개를 선택한다.
* 결과메시지(GameResultMessage)
  * [x] GameResult 를 받아서 프린트할 메시지로 변경해 준다
  
* 출력뷰(PrintView)
  * [] 게임 진행 메시지를 출력한다. 
* 입력뷰(InputView)
  * [] 플레이어는 입력하는 컴퓨터가 생각하고 있는 3개의 숫자를 입력받는다.
* 컨트롤러(Controller)
  * [] 출력을 제공한다. 
  * [] 입력을 받아서 컴퓨터에 전달한다. 
  * [] 플레이어가 정답을 모두 맞추면 게임이 종료한다. 
 


