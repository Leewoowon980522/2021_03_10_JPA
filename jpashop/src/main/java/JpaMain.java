import jpabook.jpasjop.domain.Book;
import jpabook.jpasjop.domain.Order;
import jpabook.jpasjop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Book book = new Book();
            book.setName("책이름");
            book.setAutor("저자");
            em.persist(book);


            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            emf.close();
        }
    }
}
