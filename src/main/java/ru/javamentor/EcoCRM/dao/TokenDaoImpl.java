//package ru.javamentor.EcoCRM.dao;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;
//import ru.javamentor.EcoCRM.model.Token;
//
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//
//@Repository
//@Transactional
//public class TokenDaoImpl extends AbstractDaoImpl<Token>  implements TokenDao {
//
//    @Value("${tokenTTL}")
//    private long tokenTTL;
//
//    @Override
//    public void deleteOldTokens() {
//
//        Query query = entityManager.createQuery("DELETE FROM Token t WHERE :currentTime - t.tokenCreateTime > :tokenTTL");
//        query.setParameter("currentTime", System.currentTimeMillis());
//        query.setParameter("tokenTTL", tokenTTL);
//        int rowsDeleted = query.executeUpdate();
//        System.out.println("entities deleted: " + rowsDeleted);
//
//
//    }
//
//}
//
//
