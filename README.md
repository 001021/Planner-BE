# 자취생활 도우미 (Household Chores Planner)

자취생활 도우미는 일상 생활 속 다양한 관리 필요성에 응답하기 위해 만들어진 웹 애플리케이션입니다. 이 앱은 계정 관리, 청소, 요리 및 식단, 재정 관리 기능을 통합하여 사용자가 자신의 일상을 더 잘 조직하고 관리할 수 있게 해줍니다.

## 기능

- **계정 관리**: 사용자는 자신의 계정을 생성하고, 시스템에 로그인하여 비밀번호를 변경할 수 있습니다.
- **청소 관리**: 주간 청소 일정을 계획하고 관리할 수 있으며, 청소 체크리스트와 알림 기능을 통해 청소 상태를 추적할 수 있습니다.
- **요리 및 식단 관리**: 개인 식단을 계획하고, 필요한 식재료의 장보기 목록을 작성 및 관리할 수 있습니다. 또한 요리 레시피를 관리하고, 냉장고 재료를 효과적으로 관리할 수 있습니다.
- **재정 관리**: 사용자는 월별 지출을 추적하고, 개인 예산을 설정하고 관리할 수 있습니다.
- **ChatGPT 통합**: 집안일, 청소, 요리 및 식단, 금융 관리에 대한 질문에 ChatGPT를 통해 응답을 제공합니다.

## 기술 스택

- **프론트엔드**: HTML, CSS, JavaScript, Thymeleaf
- **백엔드**: Java, Spring Framework, Gradle, MySQL, MyBatis
- **도구**: IntelliJ IDEA, Git, Visual Studio Code

## 설치 방법

```bash
# Git 리포지토리 클론
git clone https://github.com/yourusername/household-chores-planner.git

# 프로젝트 디렉토리로 이동
cd household-chores-planner

# 의존성 설치 및 프로젝트 빌드
./gradlew build

# 애플리케이션 실행
java -jar build/libs/household-chores-planner-0.1.0.jar
```

