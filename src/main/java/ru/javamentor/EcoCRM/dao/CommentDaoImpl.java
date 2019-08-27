package ru.javamentor.EcoCRM.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.EcoCRM.model.Comment;

import javax.persistence.Query;


@Repository
@Transactional
public class CommentDaoImpl extends AbstractDaoImpl<Comment> implements CommentDao {
    @Override
    public void insertByTaskId(long id, Comment comment) {
        Query query = entityManager.createNativeQuery("INSERT INTO tasks_comments (task_id, comments_id) VALUES(?,?)");
        query.setParameter("1", Long.valueOf(id));
        query.setParameter("2", comment.getId());
    }
}
