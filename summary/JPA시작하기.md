<h2>사용 DB</h2>
<ul>
	<li>h2 : http://www.h2database.com/</li>
	<li>웹용 쿼리툴 제공</li>
	<li>MySQL, Oracle 데이터베이스 시뮬레이션 가능</li>
	<li>시퀀스, AUTO INCREMENT 기능 지원</li>
</ul>
<h2>프로젝트 설정</h2>
<h3>라이브러리 추가</h3>
<h4>pom.xml</h4>
<img src="https://user-images.githubusercontent.com/76415175/110690978-e8713200-8227-11eb-8e42-905beab6ae1f.PNG">
<h4>persistence.xml</h4>
<ul>
	<li>JPA 설정 파일</li>
	<li>/META-INF/persistence.xml 위치</li>
	<li>persistence-unit name으로 이름 지정</li>
	<li>javax.persistence로 시작 : JPA 표준 속성</li>
	<li>hibernate로 시작 : 하이버네이트 전용 속성</li>
</ul>
<img src="https://user-images.githubusercontent.com/76415175/110691083-08085a80-8228-11eb-85c6-11ec802ed853.PNG">
<h2>데이터베이스 방언</h2>
<ul>
	<li>JPA는 특정 데이터베이스에 종속X</li>
	<li>각각의 데이터베이스가 제공하는 SQL 문법과 함수는 조금씩 다름</li>
	<ul>
		<li>가변 문자: MySQL은 VARCHAR, Oracle은 VARCHAR2</li>
		<li>문자열을 자르는 함수: SQL 표준은 SUBSTRING(), Oracle은 SUBSTR()</li>
		<li>페이징: MySQL은 LIMIT , Oracle은 ROWNUM</li>
	</ul>
	<li>방언: SQL 표준을 지키지 않는 특정 데이터베이스만의 고유한 기능</li>
</ul>
<h2>데이터베이스 방언</h2>
<img src="https://user-images.githubusercontent.com/76415175/110689424-02aa1080-8226-11eb-8de2-8a282c60ae25.PNG">
<ul>
	<li> hibernate.dialect 속성에 지정</li>
	<ul>
		<li>H2 : org.hibernate.dialect.H2Dialect</li>
		<li>Oracle 10g : org.hibernate.dialect.Oracle10gDialect</li>
		<li>MySQL : org.hibernate.dialect.MySQL5InnoDBDialect</li>
	</ul>
	<li>하이버네이트는 40가지 이상의 데이터베이스 방언 지원</li>
</ul>
<h2>JPA 구동방식</h2>
<img src="https://user-images.githubusercontent.com/76415175/110696729-c7f8a600-822e-11eb-84e0-277cf0ab471f.PNG">
<ul>
	<li>@Entity : JPA가 관리할 객체</li>
	<li>@Id : 데이터베이스 PK와 매핑</li>
</ul>
<h2>주의 사항</h2>
<ul>
	<li>엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유</li>
	<li>엔티티 매니저는 쓰레드간에 공유X (사용하고 버려야 한다).</li>
	<li>JPA의 모든 데이터 변경은 트랜잭션 안에서 실행</li>
</ul>
