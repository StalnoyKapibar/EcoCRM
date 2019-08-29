package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.PetitionDao;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.Status;

import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

@Service
public class PetitionServiceImpl extends AbstractServiceImpl<Petition> implements PetitionService {

    @Autowired
    private PetitionDao petitionDao;

    @Autowired
    private UserService userService;

    @Autowired
    public PetitionServiceImpl(PetitionDao petitionDao) {
        this.petitionDao = petitionDao;
    }

    @Override
    public PetitionDao getDao() {
        return petitionDao;
    }

    @Override
    public List<PetitionDTO> getAllPetition() {
        List<Petition> petitionList = new ArrayList<>();
        List<PetitionDTO> petitionDTOList = new ArrayList<>();
        petitionList = petitionDao.getAllPetitionWithStatusTodo();

        for (Petition petiton : petitionList) {
            LocalDate data = petiton.getData();
            long id = petiton.getId();
            String adress = petiton.getAddressHome();
            if(adress == null){
                adress = "данных нет";
            }
            String area = petiton.getHouseDistrict();
            if(area == null){
                area = "данных нет";
            }
            List<User> users = new ArrayList<>(petiton.getUserPetition());
            PetitionDTO petitionDTO = new PetitionDTO(data, adress, area, id, users);
            petitionDTOList.add(petitionDTO);
        }
        petitionDTOList.sort((o1, o2) -> o1.getData().compareTo(o2.getData()));
        return petitionDTOList;
    }

    @Override
    public List<PetitionDTO> getAllPetitionForAdmin(){
        List<Petition> petitionList = petitionDao.getAllPetitionForAdmin();
        List<PetitionDTO> petitionDTOList = new ArrayList<>();
        long id;
        for (Petition petition : petitionList){
            LocalDate date = petition.getData();
             id = petition.getId();
            String adress = petition.getAddressHome();
            if(adress == null){
                adress = "Нет данных";
            }
            String area = petition.getHouseDistrict();
            if(area == null){
                area = "Нет данных";
            }
            Set<User> users = petitionDao.getAllUserForAdmin(id);
            List<User> usersOne = new ArrayList<>();
            usersOne.addAll(users);
            PetitionDTO petitionDTO = new PetitionDTO(date,adress,area, id, usersOne);
            petitionDTOList.add(petitionDTO);
        }
        return petitionDTOList;
    }

    @Override
    public void addUserPetition(Long petitionId, User user) {
        Petition petition = get(petitionId);
        User userMember = userService.get(user.getId());
        petition.setStatus(Status.IN_PROGRESS);
        petition.getUserPetition().add(userMember);
        petitionDao.update(petition);
    }
}


