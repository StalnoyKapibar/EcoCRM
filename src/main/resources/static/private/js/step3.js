function step3(stepDto) {
    stepId = stepDto.id;
    $.each(stepDto.tasks, function (key, value) {
        if (value.name !== null) {
            if (value.type === 'CONTRACTOR_INFO') {
                $('#task3_' + value.id+'_').append(
                    '<div id="task_3_1"><a type="button" onclick="addContractor()" class="btn btn-outline-primary">Добавить заготовителя +</a><table class="table table-hover">\n' +
                    '<tbody id="tableCompany"></tbody></table></div>')
            }
        }
    });

    $.each(stepDto.contractors, function (k, company) {
        $('#tableCompany').append(
            '<tr><td data-toggle="modal" data-target="#contractor_modal">'+ company.name +'</td>' +
            '<td><a class="btn btn-warning" onclick="showContractor()">Данные</a></td><td><div class="dropdown"><input id="datepicker3" width="276" />' +
            '<button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="1" onclick="getData(this.id)">Назначить встречу' +
            '</button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton"><input id="1_datapiker" placeholder="назначить встречу">' +
            '<button class="btn btn-success" type="button" onclick="appoint(1)">назначить</button></div></div></td></tr>');
    });
}

function addContractor() {
    
}