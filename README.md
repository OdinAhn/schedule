// API adress
https://documenter.getpostman.com/view/55269687/2sBXwyGnN3

// ERD address
https://www.erdcloud.com/d/BfRC4KKHBCwdPvYG6

<1>
// 3 Layer Architecture의 목적
- 관심사의 분리
    - 각 계층은 고유한 책임만 담당
    - 변경 사항의 영향 범위 최소화
- 유지보수성 향상
    - 코드의 가독성과 이해도 증가
    - 독립적인 테스트 가능
- 재사용성 증대
    - 각 계층을 독립적으로 재사용
    - 모듈화된 설계
- 확장성 개선
    - 특정 계층만 변경하여 기능 확장
    - 새로운 기술 도입 용이

<2>
@RequestParam
-> HTTP요청의 Body에 있는 데이터를 객체로 변환 할때 사용합니다.

@PathVariable
-> URL 경로의 일부를 변수로 받을떄 사용, 그러니까 URL 경로 자체에 값이 반드시 있어야 하는 경우에 사용합니다.

@RequestBody
-> 쿼리 파라미터를 받아옵니다. Key/Value 값이 조건부이기 때문에, 있어도 되고 없어도 되는 값일 때 사용합니다.(검색용)
