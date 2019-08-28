package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ContractorDao;
import ru.javamentor.EcoCRM.model.Comment;
import ru.javamentor.EcoCRM.model.Contractor;

import java.time.LocalDate;

@Service
public class ContractorServiceImpl extends AbstractServiceImpl<Contractor> implements ContractorService {

    private ContractorDao contractorDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    public ContractorServiceImpl(ContractorDao contractorDao) {
        this.contractorDao = contractorDao;
    }

    @Override
    public AbstractDao<Contractor> getDao() {
        return contractorDao;
    }

    @Override
    public void saveComment(Long id, String comment) {
        Contractor contractor = contractorDao.get(id);
        Comment comm = new Comment(comment, LocalDate.now());
        commentService.insert(comm);
        contractor.getComments().add(comm);
        update(contractor);
    }
}
