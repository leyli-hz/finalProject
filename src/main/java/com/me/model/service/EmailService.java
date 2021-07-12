package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Email;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class EmailService implements GenericService<Email> {
    private static EmailService service = new EmailService();

    private EmailService() {
    }

    public static EmailService getInstance() {
        return service;
    }
    @Override
    public void save(Email emailObject) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(emailObject);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Email emailObject) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Email newEmail = entityManager.find(Email.class, emailObject.getEmailId());
        newEmail.setEmailId(emailObject.getEmailId());
        newEmail.setContent(emailObject.getContent());
        newEmail.setDateTime(emailObject.getDateTime());
        newEmail.setSubject(emailObject.getSubject());
        newEmail.setSenderID(emailObject.getSenderID());
        //newEmail.setReceiversID(emailObject.getReceiversID());

        entityManager.merge(newEmail);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void remove(int id) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Email email = entityManager.find(Email.class, id);
        entityManager.remove(email);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<Email> findAll() throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from email", Email.class);
        List resultList = query.getResultList();
        System.out.println("findAll() resultlist esh ejra shod!");
        entityManager.close();
        System.out.println("findAll() haamaash ejra shod!");
        return resultList;
    }

    public List<Email> joinEmail_EmailReceiver(int receiverId){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select email.* , email_receiver.receiver_id \n" +
                "from email inner join email_receiver\n" +
                "on email.email_id=email_receiver.email_id\n" +
                "where email_receiver.receiver_id=?1",Email.class);
        query.setParameter(1,receiverId);
        List<Email> receiversList = query.getResultList();

        return receiversList;
    }
}
