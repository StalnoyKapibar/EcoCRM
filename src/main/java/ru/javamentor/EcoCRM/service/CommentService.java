package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Comment;

public interface CommentService extends AbstractService<Comment> {
    void insertByTaskId(long id,String comment);
}
