package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.CommentDao;
import ru.javamentor.EcoCRM.model.Comment;

import java.time.LocalDate;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public AbstractDao<Comment> getDao() {
        return commentDao;
    }

    @Override
    public void insertByTaskId(long id, String textComment) {
        Comment comment = new Comment();
        comment.setMessage(textComment);
        comment.setTime(LocalDate.now());
        commentDao.insertByTaskId(id,comment);
    }
}
