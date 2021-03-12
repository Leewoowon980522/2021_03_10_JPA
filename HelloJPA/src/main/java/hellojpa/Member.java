package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //JPA가 로딩될때 JPA를 사용하는 애로 인식해 관리한다.
//@Table(name="MBR")
//@SequenceGenerator(name = "member_seq_generator",sequenceName = "member_seq")
@TableGenerator(name = "MEMBER_SEQ_GENERATER",table = "MY_SEQUENCES",pkColumnValue = "MEMBER_SEQ",allocationSize = 1)
public class Member {
    /*
    @Id //JPA에게 PK가 뭔지 알려줘야함
    private Long id;
    private String name;
    private int aaa;

    //JPA는 기본적으로 내부적으로 리플랙션등을 쓰기 때문에 동적으로 객체를 생성을 해야함 기본 생성자가 하나 필요
    public Member(){}
    public Member(Long id,String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    */

//
//    @Id//PK 매핑
//    private Long id;
//
//    //Colum에 name을 줘서 DB 컬럼명은 name임
//    //insertable 컬럼을 수정했을 때 DB에 insert를 할껀가말껀가 updatable update문이 나갈때 컬럼을 변경할껀가 말껀가
//    //등록하고 변경은 절때 하면 안된다면 updateble=false <- DB에서 강제로 업데이트를 하지않는한 변경되지 않는다.
//    //nullable=false면 not null이 붙는다.(기본 true)
//    //unique 제약조건을 주고싶다면 unique = true,잘 사용하지 않는다. 이름을 반영하기 어려움,@Table(uniqueConstraints="")에서 제약조건을 주면 이름까지 부여가 가능
//    //length를 주면 길이가 정해짐 length = 10 -> varchar(10)
//    //columnDefinition = "varchar(100) default 'EMPTY'"컬럼정의를 직접하고 싶다
//    @Column(name = "name",columnDefinition = "varchar(10) default 'Entity'")
//    private String username;
//    /*
//    //숫자가 엄청 클경우,소숫점일 때 사용하면 된다.
//    @Column(precision = 10,scale = 2)//소숫점 포함 전체 자리수 10,소수점자리수 2
//    private BigDecimal age;
//    */
//    private Integer age;//디비에 숫자타입이 적용(가장적절한)
//
//    //(default) ORDINAL : enum의 순서를 DB에 저장, STRING : enu, 이름을 DB에 저장
//    @Enumerated(EnumType.STRING)//객체에서 enum타입을 사용하려면 디비에는 enum타입은 없기에 Enumerated를 사용하면됨
//    private RoleType roleType;
//
//    /*
//    //LocalDate,LocalDateTime은 @Temporal 생략 가능
//    private LocalDate testLocalDate;//년원
//    private LocalDateTime testLocalDateTime;//년월일
//    */
//
//    @Temporal(TemporalType.TIMESTAMP)//날짜 타입을 사용하게 되면 Temporal을 사용하면 된다.(DATE,TIME,TIMESTAMP가 있음 ,매핑 타입을 정해줌)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob//지정할수 있는 속성이 없음 문자면은 clob 나머지는 blob
//    private String description;
//
//    @Transient //디비와 매핑되지 않음, 메모리에서만 사용하겠다는뜻
//    private int temp;
//
    @Id//직접할당
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "MEMBER_SEQ_GENERATER")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    public Member(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
