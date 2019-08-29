package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.ReportDao;
import ru.javamentor.EcoCRM.dao.RequestDAO;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.Request;
import ru.javamentor.EcoCRM.model.User;

import java.util.List;

@Service
public class RequestServiceImpl extends AbstractServiceImpl<Request> implements RequestService {

    private RequestDAO requestDao;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;
    @Autowired
    public RequestServiceImpl(RequestDAO requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public RequestDAO getDao() {
        return requestDao;
    }

    //Добавление заявки на участие в проекте
    public void addRequestToAccept(Long projectId){
        Project projectRequested = projectService.get(projectId);
        Long ManagerId = projectRequested.getManager().getId();

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Request newRequest = new Request(currentUser.getName() + " " + currentUser.getSurname(),projectRequested.getPetition().getAddressHome(),currentUser.getId(),projectRequested.getId(),ManagerId);

        User Manager = userService.get(ManagerId);
        List<Request> currentRequests = Manager.getRequestList();
        currentRequests.add(newRequest);
        this.insert(newRequest);
        Manager.setRequestList(currentRequests);
        userService.update(Manager);
    }
    public void acceptRequest(Long id){
        //Добавление пользователя к проекту
        Request request = this.get(id);

        User user = userService.get(request.getManagerId());
        user.getRequestList().removeIf(req -> req.getId().equals(request.getId()));
        userService.update(user);
        Project project = projectService.get(request.getProjectId());
        List<User> members = project.getUsers();
        members.add(userService.get(request.getPersonId()));
        project.setUsers(members);
        projectService.update(project);
        this.delete(request);
    }
}
