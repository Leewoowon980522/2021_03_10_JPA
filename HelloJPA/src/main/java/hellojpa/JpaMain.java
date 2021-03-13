package hellojpa;

import org.hibernate.annotations.common.reflection.XMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory는 애플리케이션 로딩시점에 하나만 만들어놔야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();//데이터를 변경하는 모든 작업은 Transaction안에서 작업해야함
        tx.begin();//시작

        try {
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            //member.setTeamId(team.getId());
            member.setTeam(team);
            em.persist(member);

            em.flush();em.clear();

            Member findmember = em.find(Member.class,member.getId());
           /* Team findTeam = findmember.getTeam();
            System.out.println("findTeam == " + findTeam.getId());*/
            List<Member> members = findmember.getTeam().getMembers();
            for(Member m : members){
                System.out.println("m = " + m.getName());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
