# java-calculator-precourse

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현
기본 구분자 : ",", ":"
커스텀 구분자 : "//" 사이 값 "\n"

## 입력 예외
1. 음수
2. null Nan
3. 커스텀 구분자
- 예외시, 다시 입력 받기

## 기능 분리
1. 입력 문자 받기
2. 입력 문자 검증 (null, empty)
3. 커스텀 구분자 추출
4. 커스텀 구분자 포맷 제거 
5. 구분자 포맷에 전부 집어 넣고 split
6. split 된 문자 검증 (Nan, Negative)
7. 정수 변환 
8. 연산 적용
9. 결과 출력


## 책임 분리
#### AppConfig
- 의존성 주입 역할

#### Domain
- delimiter (구분자 추가, 구분자 이용 split)
  - CustomDelimiter(구현체)
- operator (연산 진행)
  - PlusOperator(구현체)

#### Service
- DelimiterExtractor(delimiter를 추출)
  - CustomDelimiterExtractor(구현체)
- DelimiterService(주입받은 delimiter 사용)
- OperatorService(주입받은 operator 사용)

#### Controller
- Calculator
  - service에 도메인 로직 사용 요청
  - view에 결과 전달
  - utils 이용 입력 값 검증 과 타입 변환

#### Utils
- TypeCast (타입 변환)
- Validator (검증)

#### View
- inputView
- outputView


#### 고민
- 검증에 대한 부분을 어디 책임으로 넣을 것인가
- 개발 순서 -> 기능 분리, 책임 분리, 기능테스트 작성, 기능 구현, 리팩토링
  - 구현 시간: 3시간
  - 이 부분에 대한 오버헤드 찾기 필요. (1주차도 오래걸리면;;)
- 만들어두면 좋을 템플릿 -> 예외 Enum 사용 템플릿 정도?
- 돌아가는 쓰레기란..?