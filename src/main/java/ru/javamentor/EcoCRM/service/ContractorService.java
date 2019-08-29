package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Contractor;

public interface ContractorService extends AbstractService<Contractor> {
    void saveComment(Long id, String comment);
}
