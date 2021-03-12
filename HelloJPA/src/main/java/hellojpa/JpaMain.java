package hellojpa;

import org.hibernate.annotations.common.reflection.XMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory는 애플리케이션 로딩시점에 하나만 만들어놔야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();//데이터를 변경하는 모든 작업은 Transaction안에서 작업해야함
        tx.begin();//시작

        try {
            /*
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);//저장
            */
            //Member findMember = em.find(Member.class,2L);
            /* 값 find
            System.out.println("findMember id = " + findMember.getId());
            System.out.println("findMember name = " + findMember.getName());
            */
            //em.remove(findMember); 찾은 id로 DB에서 삭제
            //findMember.setName("HelloJPA");
            // JPA를 통해 Entity를 가져오면 JPA가 관리를 하는데 Transaction이 커밋하는 시점에서 변동사항이 있으면 UPDATE 커밋을 날리기 때문에값이 바뀜
/*
            Member member = em.find(Member.class,150L);
            member.setName("ZZZZ");

            System.out.println("=============");
            */
            Member member = new Member();
            //member.setId("ID_A");
            member.setName("C");
            em.persist(member);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
