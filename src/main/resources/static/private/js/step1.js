 function step1(stepDto) {
    stepId = stepDto.id;
    $.each(stepDto.tasks, function (key, value) {

            if (value.type === 'PETITIONER_INFO') {
                $('#task3_' + value.id+'_').append('<label class="h6">ФИО</label>' +
                    '<input type="text" class="form-control" placeholder="ФИО заявителя" value="'+stepDto.petition.userName+'" id="fio_petitioner">' +
                    '<br>' +
                    '<label class="h6">Email</label>\n' +
                    '<input type="text" class="form-control" placeholder="email" value="'+stepDto.petition.email+'" id = "email_petitioner">\n' +
                    '<br>\n' +
                    '<label class="h6">Контактная информация</label>\n' +
                    '<input type="text" class="form-control" placeholder="контакная информация" value="'+stepDto.petition.contactInformation+'"  id="contacts_petitioner">\n' +
                    '\n' +
                    '<br>\n' +
                    '<div class="h6">Статус</div>\n' +
                    '<div id = "status_petitioner">\n' +
                    '<div class="form-check">\n' +
                    '<input type="radio" class="form-check-input" id="resident" value="Житель, собственник жилья" name="status">\n' +
                    '<label class="form-check-label">Житель, собственник жилья</label>\n' +
                    '</div>\n' +
                    '<div class="form-check">\n' +
                    '<input type="radio" class="form-check-input" id="manage_representative"\n' +
                    'name="status" value="Представитель управляющей организации (УК, ТСЖ и\n т.п.)">' +
                    '<label class="form-check-label">Представитель управляющей организации (УК, ТСЖ и\n т.п.)</label>\n' +
                    '</div>' +
                    '</div>' +
                    '<br>' +
                    '<div class="h6">Участвует в деятельности движения "Раздельный сбор"</div>\n' +
                    '                                <div id = "activity_petitioner">\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="radio" class="form-check-input activity" id="monthly"\n' +
                    '                                           name="activity" value="Участвую в ежемесячных акциях и сдаю своё\n' +
                    '                                        вторсырьё">\n' +
                    '                                    <label class="form-check-label">Участвую в ежемесячных акциях и сдаю своё\n' +
                    '                                        вторсырьё</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="radio" class="form-check-input activity" id="volunteer"\n' +
                    '                                           name="activity" value="Волонтер на акциях">\n' +
                    '                                    <label class="form-check-label">Волонтер на акциях</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="radio" class="form-check-input activity" id="corrdinator"\n' +
                    '                                           name="activity" value="Координатор на акциях">\n' +
                    '                                    <label class="form-check-label">Координатор на акциях</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="radio" class="form-check-input activity" id="participant"\n' +
                    '                                           name="activity" value="Участник рабочих групп движения">\n' +
                    '                                    <label class="form-check-label" for="participant">Участник рабочих групп\n' +
                    '                                        движения</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="radio" class="form-check-input activity" id="no_participate"\n' +
                    '                                           name="activity" value="Не принимаю участия в деятельности движения">\n' +
                    '                                    <label class="form-check-label" for="participant">Не принимаю участия в\n' +
                    '                                        деятельности движения</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="radio" class="form-check-input" id="another_active"\n' +
                    '                                           name="activity" value="другое">\n' +
                    '                                    <label class="form-check-label" for="participant">другое</label>\n' +
                    '                                </div>\n' +
                    '                                <input type="text" class="form-control" id="another_active_input" disabled>\n' +
                    '                                </div>\n' +
                    '\n' +
                    '                                <br>\n' +
                    '                                <div class="h6">Накопление какого мусора хотелось бы организовать?</div>\n' +
                    '                                <div id = "row_type">\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="paper" value="Бумага/картон">\n' +
                    '                                    <label class="form-check-label">Бумага/картон</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="glass" value="Стекло">\n' +
                    '                                    <label class="form-check-label">Стекло</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="metal" value="Металл">\n' +
                    '                                    <label class="form-check-label">Металл</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="hard_plastic" value="Твёрдый пластик">\n' +
                    '                                    <label class="form-check-label">Твёрдый пластик</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="soft_plastic" value="Мягкий пластик">\n' +
                    '                                    <label class="form-check-label">Мягкий пластик</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="tetra_pak" value="Тетрапак">\n' +
                    '                                    <label class="form-check-label">Тетрапак</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="organic_waste" value="Органические отходы">\n' +
                    '                                    <label class="form-check-label">Органические отходы</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="hazardous_waste" value="Опасные отходы (батарейки, лампочки и т.п.)">\n' +
                    '                                    <label class="form-check-label">Опасные отходы (батарейки, лампочки и\n' +
                    '                                        т.п.)</label>\n' +
                    '                                </div>\n' +
                    '                                <div class="form-check">\n' +
                    '                                    <input type="checkbox" class="form-check-input" id="another_waste" value="другое">\n' +
                    '                                    <label class="form-check-label">другое</label>\n' +
                    '                                </div>\n' +
                    '                                <input type="text" class="form-control" id="another_waste_input" disabled>\n' +
                    '</div>\n' +
                    '<br>' +
                    '    <label class="h6">Адрес дома</label>\n' +
                    '    <input type="text" class="form-control" placeholder="ФИО заявителя" value="'+stepDto.petition.adresHome+'" id="home_adres">\n' +
                    '<br>' +
                    '    <div class="form-row align-items-center">\n' +
                    '        <div class="col-auto my-1">\n' +
                    '            <label class="mr-sm-2" for="home_district">В каком районе расположен дом? *</label>\n' +
                    '            <select class="custom-select mr-sm-2" name="houseArea" id = "home_district">\n' +
                    '                <option selected>С какого ты района? епта</option>\n' +
                    '                <option value="Адмиралтейский район">Адмиралтейский район</option>\n' +
                    '                <option value="Василеостровский район">Василеостровский район</option>\n' +
                    '                <option value="Выборгский район">Выборгский район</option>\n' +
                    '                <option value="Калинский район">Калинский район</option>\n' +
                    '                <option value="Колпинский район">Колпинский район</option>\n' +
                    '                <option value="Красногвардейский район">Красногвардейский район</option>\n' +
                    '                <option value="Красносельский район">Красносельский район</option>\n' +
                    '                <option value="Кронштадский район">Кронштадский район</option>\n' +
                    '                <option value="Курортный район">Курортный район</option>\n' +
                    '                <option value="Московский район">Московский район</option>\n' +
                    '                <option value="Невский район">Невский район</option>\n' +
                    '                <option value="Петроградский район">Петроградский район</option>\n' +
                    '                <option value="Петродворцовый район">Выборгский район</option>\n' +
                    '                <option value="Приморский район">Приморский район</option>\n' +
                    '                <option value="Пушкинский район">Пушкинский район</option>\n' +
                    '                <option value="Фрунзенский район">Фрунзенский район</option>\n' +
                    '                <option value="Центральный район">Центральный район</option>\n' +
                    '                <option value="Всеволожский район ЛО">Всеволожский район ЛО</option>\n' +
                    '                <option value="Гатчинский район">Гатчинский район</option>\n' +
                    '                <option value="Кировский район">Кировский район</option>\n' +
                    '                <option value="Сосновоборский район">Сосновоборский район</option>\n' +
                    '                <option value="Тосненский район">Тосненский район</option>\n' +
                    '                <option value="Другой район">Другой район</option>\n' +
                    '            </select>\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '    <br>\n' +
                    '    <label class="h6">Сколько квартир в доме</label>\n' +
                    '    <input type="text" class="form-control" placeholder="Коллиесвто квартир в доме" value="'+stepDto.petition.countOfApartments+'" id ="apartments_count">\n' +
                    '<br>\n' +
                    '<div class="h6">Какая форма управления Вашим домом</div>\n' +
                    '<div id = "home_management_form">\n' +
                    '<div class="form-check">\n' +
                    '<input type="radio" class="form-check-input" id="tszh" name="management_form" value="Товарищество собственников жилья">\n' +
                    '        <label class="form-check-label">Товарищество собственников жилья</label>\n' +
                    '    </div>' +
                    '    <div class="form-check">' +
                    '        <input type="radio" class="form-check-input" id="yk" value="Управляющая компания"' +
                    '               name="management_form">\n' +
                    '        <label class="form-check-label">Управляющая компания</label>\n' +
                    '    </div>\n' +
                    '\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="zhks" value="Жилищно-коммунальная служба (ЖКС)"\n' +
                    '               name="management_form">\n' +
                    '        <label class="form-check-label">Жилищно-коммунальная служба (ЖКС)</label>\n' +
                    '    </div>\n' +
                    '\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="another_m_f" value="другая"\n' +
                    '               name="management_form">\n' +
                    '        <label class="form-check-label">другая</label>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <div class="h6">Есть ли совет многоквартирного дома</div>\n' +
                    '    <div id = "home_sovet">\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="sovet_yes" value="Да" name="home_sovet">\n' +
                    '        <label class="form-check-label">Да</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="sovet_no" value="Нет" name="home_sovet">\n' +
                    '        <label class="form-check-label">Нет</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="sovet_doubts" value="Сомневается" name="home_sovet">\n' +
                    '        <label class="form-check-label">Сомневается</label>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <div class="h6">Как управляющая организация относится к РНО?</div>\n' +
                    '    <div id = "menegement_org_relate">\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="positive_relate" name="menegement_org_relate" value="Положительно, ждёт предложений">\n' +
                    '        <label class="form-check-label">Положительно, ждёт предложений</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="negative_relate" name="menegement_org_relate" value="Отрицательно, не верит в раздельный сбор">\n' +
                    '        <label class="form-check-label">Отрицательно, не верит в раздельный сбор</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="unknown_relation" name="menegement_org_relate" value="Не знаю">\n' +
                    '        <label class="form-check-label">Не знаю</label>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <br>\n' +
                    '    <label class="h6">Контактная информация правления дома</label>\n' +
                    '    <input type="text" class="form-control" placeholder="Контактная информация правления дома" value="'+stepDto.petition.boardHouseContactInformation+'" id ="contact_management">\n' +
                    '    <br>\n' +
                    '    <label class="h6">Дополнительня информация</label>\n' +
                    '    <input type="text" class="form-control" placeholder="Контактная информация правления дома" value="'+stepDto.petition.additionalInformation+'" id ="additional_information">\n' +
                    '    <br>\n' +
                    '    <div class="h6">Имеется ли у Вашего дома своя контейнерная площадка (КП)?</div>\n' +
                    '    <div id = "container_place">\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="cont_place_yes" value="Да" name="container_place">\n' +
                    '        <label class="form-check-label">Да</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="cont_place_no" value="Нет" name="container_place">\n' +
                    '        <label class="form-check-label">Нет</label>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <br>\n' +
                    '    <label class="h6">Если КП имеется, то укажите её площадь и особенности устройства</label>\n' +
                    '    <input type="text" class="form-control" value="'+stepDto.petition.containerSize+'" id ="container_area">\n' +
                    '    <br>\n' +
                    '    <div class="h6">Если КП имеется, то укажите собственника земли, на которой она находится</div>\n' +
                    '    <div id = "container_area_owner">\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="home_owner" name="container_area_owner" value="Собственник дома">\n' +
                    '        <label class="form-check-label">Собственник дома</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="municipality_owner" name="container_area_owner" value="Муниципальное образование">\n' +
                    '        <label class="form-check-label">Муниципальное образование</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="city_owner" name="container_area_owner" value="Город (субъект РФ)">\n' +
                    '        <label class="form-check-label">Город (субъект РФ)</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" value="Другое" id="another_owner" name="container_area_owner">\n' +
                    '        <label class="form-check-label">Другое</label>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <br>\n' +
                    '    <div class="h6">Имеется ли в Вашем доме мусоропровод?</div>\n' +
                    '    <div id = "chute_form">\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="chute_yes" value="Да" name="chute">\n' +
                    '        <label class="form-check-label">Да</label>\n' +
                    '    </div>\n' +
                    '    <div class="form-check">\n' +
                    '        <input type="radio" class="form-check-input" id="chute_no" value="нет" name="chute">\n' +
                    '        <label class="form-check-label">Нет</label>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <br>\n' +
                    '    <label class="h6">Какая компания занимается вывозом ТКО?</label>\n' +
                    '    <input type="text" class="form-control" value="'+stepDto.petition.exportGarbage+'" id ="garbage_disposal_company">\n' +
                    '    <br>\n');
                $('#status_petitioner [value = '+stepDto.petition.statusHome+']').prop('checked',true);
                $('#activity_petitioner [value = '+stepDto.petition.separateCollection+']').prop('checked',true);
                $('#row_type [value = '+stepDto.petition.typeOfRawMaterial+']').prop('checked',true);
                $('#home_district [value = '+stepDto.petition.typeOfRawMaterial+']').attr("selected", "selected");
                $('#home_management_form [value = '+stepDto.petition.homeControlForm+']').prop('checked',true);
                $('#home_sovet [value = '+stepDto.petition.houseCouncil+']').prop('checked',true);
                $('#menegement_org_relate [value = '+stepDto.petition.managementOrganization+']').prop('checked',true);
                $('#container_place[value = '+stepDto.petition.containerSite+']').prop('checked',true);
                $('#container_area_owner[value = '+stepDto.petition.containerOwner+']').prop('checked',true);
                $('#chute_form [value = '+stepDto.petition.garbage+']').prop('checked',true);
            }

            $('#task3_' + value.id+'_').append(
                '<label for="comment" class="h6">Комментарий:</label>\n' +
                '<textarea class="form-control" rows="5"></textarea></div>');

    });

}