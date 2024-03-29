package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.model.Request;

public interface RequestService extends AbstractService<Request> {
    void addRequestToAccept(Long id);
    void acceptRequest(Long id);
}
