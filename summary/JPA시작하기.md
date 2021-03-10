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
<pre>
<?xml version="1.0" encoding="UTF-8"?> 
	<project xmlns="http://maven.apache.org/POM/4.0.0" 
	 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"> 
	 <modelVersion>4.0.0</modelVersion>
	 
	 <groupId>jpa-basic</groupId> 
	 <artifactId>ex1-hello-jpa</artifactId> 
	 <version>1.0.0</version> 
	 
	 <dependencies> 
		 <!-- JPA 하이버네이트 --> 
		 <dependency> 
			 <groupId>org.hibernate</groupId> 
			 <artifactId>hibernate-entitymanager</artifactId> 
			 <version>5.3.10.Final</version> 
		 </dependency> 
	 
		<!-- H2 데이터베이스 --> 
		 <dependency> 
			 <groupId>com.h2database</groupId> 
			 <artifactId>h2</artifactId> 
			 <version>1.4.199</version> 
		 </dependency> 
	 </dependencies> 
</project> 
</pre>
<h4>persistence.xml</h4>
<ul>
	<li>JPA 설정 파일</li>
	<li>/META-INF/persistence.xml 위치</li>
	<li>persistence-unit name으로 이름 지정</li>
	<li>javax.persistence로 시작 : JPA 표준 속성</li>
	<li>hibernate로 시작 : 하이버네이트 전용 속성</li>
</ul>
<pre>
<?xml version="1.0" encoding="UTF-8"?> 
<persistence version="2.2" 
 xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"> 
 <persistence-unit name="hello"> 
	 <properties> 
		 <!-- 필수 속성 --> 
		 <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/> 
		 <property name="javax.persistence.jdbc.user" value="sa"/> 
		 <property name="javax.persistence.jdbc.password" value=""/> 
		 <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/test"/> 
		 <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/> 
		 
		 <!-- 옵션 --> 
		 <property name="hibernate.show_sql" value="true"/> 
		 <property name="hibernate.format_sql" value="true"/> 
		 <property name="hibernate.use_sql_comments" value="true"/> 
		 <!--<property name="hibernate.hbm2ddl.auto" value="create" />--> 
	 </properties> 
 </persistence-unit> 
</persistence> 
</pre>
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