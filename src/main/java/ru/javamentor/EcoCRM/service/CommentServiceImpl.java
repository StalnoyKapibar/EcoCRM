package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.CommentDao;
import ru.javamentor.EcoCRM.model.Comment;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Comment> implements CommentService {

    private CommentDao commentDAO;

    @Autowired
    public CommentServiceImpl(CommentDao commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public AbstractDao<Comment> getDao() {
        return commentDAO;
    }

}
