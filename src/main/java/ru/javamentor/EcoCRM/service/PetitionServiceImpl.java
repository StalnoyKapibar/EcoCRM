package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.PetitionDao;
import ru.javamentor.EcoCRM.dao.PetitionDaoImpl;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.Petition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionServiceImpl extends AbstractServiceImpl<Petition> implements PetitionService {



    @Autowired
    private PetitionDao petitionDao;

    @Autowired
    public PetitionServiceImpl(PetitionDao petitionDao) {
        this.petitionDao = petitionDao;
    }

    @Override
    public PetitionDao getDao() {
        return petitionDao;
    }

    public List<PetitionDTO> getAllPetition() {
        List<Petition> petitionList = new ArrayList<>();
        List<PetitionDTO> petitionDTOList = new ArrayList<>();
        petitionList = petitionDao.getAll();

        for (Petition petiton : petitionList) {
            LocalDate data = petiton.getData();
            String adress = petiton.getAdresHome();
            if(adress == null){
                adress = "данных нет";
            }
            String area = petiton.getHouseArea();
            if(area == null){
                area = "данных нет";
            }
            PetitionDTO petitionDTO = new PetitionDTO(data, adress, area);
            petitionDTOList.add(petitionDTO);
        }
        petitionDTOList.sort((o1, o2) -> o1.getData().compareTo(o2.getData()));
        return petitionDTOList;
    }
}


