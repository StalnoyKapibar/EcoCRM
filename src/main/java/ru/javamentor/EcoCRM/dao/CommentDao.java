package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Comment;

public interface CommentDao extends AbstractDao<Comment> {

    void insertByTaskId(long id, Comment comment);
}
