package ru.javamentor.EcoCRM.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Token;

import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TokenDaoImpl extends AbstractDaoImpl<Token>  implements TokenDao {

    @Override
    public void deleteOldTokens() {

        Query query = entityManager.createQuery("DELETE FROM Token t WHERE :currentTime - t.tokenCreateTime > 60000 ");
        query.setParameter("currentTime", System.currentTimeMillis());
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);


    }// Query query = entityManager.createQuery("select t from " + entityBeanType.getSimpleName() + " t where t." + fieldName + "=:fieldValue");

}


