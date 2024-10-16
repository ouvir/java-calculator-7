# java-calculator-precourse
[과제 내용](https://github.com/ouvir/java-calculator-7/blob/ouvir/docs/description.md)
## 기능 요구 사항 정리
1. 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현
2. 커스텀 구분자 설정 기능
3. 잘못된 값 입력 시, `IllegalArgumentException` 발생시키고 종료

궁금한점
- 만약, 커스텀 구분자와 기본 구분자를 같이 사용한다면?
예) `//;\n1,2:3;4` 와 같은 형태
> 이럴 경우, 사용자가 원하는 답은 구분자를 , : ; 3가지로 사용해서 처리하기를 원한다고 생각함!  

따라서 이 경우, 구분자를 추가하여 사용할 수 있도록 지정이 필요할 듯 함.

### 고민해봐야 할 것
1. 요구사항의 변경에 유연한 코드를 작성하자
   - 현재 입력한 문자열에서 기본 구분자와 커스텀 구분자를 통해, 숫자를 구분
     - 기본 구분자가 변경된다면? (1)
     - 커스텀 구분자를 구별하는 방식이 변경된다면? (2)
   - 숫자를 구분한 뒤, 이를 더하고 있다.
     - 더하기가 아닌, 다른 연산을 수행해야한다면? (3)
   - 잘못된 값을 입력하면 __특정__ 예외를 발생시킨다.
     - 특정 예외가 변경된다면? (4)

2. 테스트 주도 기반 코드를 작성하자.
   - 기능 요구사항을 더 작게 쪼개어 생각하며, 단위 테스트 단위로 구현하자.

### 역할 분리
필요한 역할들을 나누어 보자.
- 구분자 
  - 문자열을 구분하는 애들을 갖고 있으며, 이를 반환
- 문자열 파싱자(구분자에 의존)
  - 문자열을 구분자에 맞춰 자름
- 커스텀 구분자 추출자
  - 문자열에서 사용자 정의 구분자를 추출
- 연산자
  - 연산을 수행

### 기능 흐름도 (러프하게 구조 잡기)
1. 입력 받기
2. 입력에 대해, 커스텀 구분자를 확인하여, 구분자에 추가해줌
3. 기본 구분자와 커스텀 구분자를 통해, 숫자를 구분함
4. 숫자가 아닌 문자에 대한 예외 처리 진행
5. 각각의 숫자에 연산자를 통해, 결과값 얻기
6. 결과 출력

### 역할 구분하기
1. 구분자
2. 커스텀 구분자 구별용 문자
3. 연산자
4. 예외처리

### 역할의 필요 기능 생각해보기
1. 구분자
   - 구분자 추가 기능
   - 구분자 모두 가져오기

2. 커스텀 구분자 구별용 문자
   - 문자를 주면, 커스텀 구분자를 추출하는 기능

3. 연산자
   - 구분자를 통해, 연산을 수행하는 기능

4. 예외처리
   - 특정 예외 상황에 대한, 처리를 진행

이제, 관련 기능을 하나씩 만족시키면서, 테스트를 작성하고 이를 만족하는 식으로 코드를 짜보자.