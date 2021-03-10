package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //JPA가 로딩될때 JPA를 사용하는 애로 인식해 관리한다.
public class Member {
    @Id //JPA에게 PK가 뭔지 알려줘야함
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
