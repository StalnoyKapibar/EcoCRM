moment.locale("en");
class CalendarYvv{
    constructor(etiqueta="", diaSeleccionado="", primerDia="Lunes") {
        this.etiqueta = etiqueta; // метка, где это будет отображаться
        this.primerDia = primerDia; // начало недели
        this.diaSeleccionado = diaSeleccionado==""?moment().format("Y-M-D"):diaSeleccionado; // выбранный текущий день

        this.funcPer = function(e){}; // функция, выполняемая при запуске события нажатия
        this.funcNext = false; // функция, выполняемая при запуске события нажатия
        this.funcPrev = false; // функция, выполняемая при запуске события нажатия
        this.currentSelected = moment().format("Y-M-D"); // выбранный предмет

        this.diasResal = []; // важные дни
        this.colorResal = "#28a7454d"; // цвет важных дней
        this.textResalt = "#28a745"; // цвет текста важных дней

        this.bg = "bg-dark"; // цвет фона заголовка
        this.textColor = "text-white"; // цвет текста в заголовке
        this.btnH = "btn-outline-light"; // нормальный цвет кнопки
        this.btnD = "btn-rounded-success";// Цвет кнопки при наведении - "btn-outline-dark"

        this.__author = "Yordanch Vargas Velasque";
        this.__email = "snd.yvv@gmail.com";
        this.__version = "1.1.1";
    }
    startElements(){
        this.diaSeleccionado = this.corregirMesA(this.diaSeleccionado);
        this.inicioDia = moment(this.diaSeleccionado).format("dddd"); // день начала месяца
        this.mesSeleccionado = this.diaSeleccionado.split("-")[1]*1; // выбранный месяц
        this.anioSeleccionado = this.diaSeleccionado.split("-")[0]*1; // выбранный год
        this.cantDias = moment(this.diaSeleccionado).daysInMonth()*1; // количество дней месяца
        this.diasCoto = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
        this.diasLargo = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    }
    createCalendar(){
        this.startElements();
        var cont = $(this.etiqueta);
        var cntCale = $("<div class='calendar-yvv w-100'>");
        var headerCalendar = this.createHeaderM();
        var daysLettCalendar = this.createDayTag();
        var daysNumCalendar = this.createDaysMont();

        cont.html("");
        cntCale.append(headerCalendar);
        cntCale.append(daysLettCalendar);
        cntCale.append(daysNumCalendar);
        cont.append(cntCale);
    }
    createHeaderM(){
        var cont = $("<div class='d-flex justify-content-between p-2 border align-items-center border-bottom-0 "+this.bg+" "+this.textColor+"'>");
        var arrowL = $("<span class='btn "+this.btnH+"'>").html("<");
        var arrowR = $("<span class='btn "+this.btnH+"'>").html(">");
        var title = $("<span class='text-uppercase'>").html(moment(this.diaSeleccionado).format("MMMM - Y"));
        var _this = this;

        arrowL.on("click", function(e){
            _this.mesAnterior(_this)
        });
        arrowR.on("click", function(e){
            _this.mesSiguiente(_this)
        });
        cont.append(arrowL);
        cont.append(title);
        cont.append(arrowR);
        return cont;
    }
    createDayTag(){
        var newPrimerDia = this.firtsMayus(this.primerDia);
        var diasOrd = this.ordenarDiasMes(newPrimerDia);

        var cont = $("<div class='d-flex border w-100 border-top-0 "+this.bg+" "+this.textColor+"'>");

        diasOrd.fechCort.forEach(function(e){
            var div = $("<div class='d-flex border flex-fill w-100 justify-content-center p-2'>").html(e);
            cont.append(div);
        });
        return cont;
    }
    createDaysMont(){
        var diaSelected = this.corregirMesA(this.anioSeleccionado + "-" + this.mesSeleccionado + "-01");
        var primerDiaMes = moment(diaSelected).format("dddd");
        var diaInicio = this.firtsMayus(primerDiaMes); //this.firtsMayus(this.inicioDia);
        var diasOrd = this.ordenarDiasMes(this.firtsMayus(this.primerDia));
        var posMes = diasOrd.fechLarg.indexOf(diaInicio);

        var cnt = 0;
        var cntG = $("<div class='w-100'>");

        var cont = $("<div class='d-flex border w-100 border-top-0'>");
        var emptyTag = "<div class='d-flex border flex-fill w-100 justify-content-center pt-3 pb-3 btn' style='color:transparent'>";
        for(var j=0;j<posMes;j++){
            var div = $(emptyTag).html("0");
            cont.append(div);
            cnt++;
        }
        for(var i=0;i<this.cantDias;i++){
            var fechNow = this.anioSeleccionado+"-"+this.mesSeleccionado+"-"+(i+1);
            var div = $("<div class='d-flex border flex-fill w-100 justify-content-center pt-3 pb-3 btn "+this.btnD+"' data-date='"+fechNow+"'>").html(i+1);
            var clas_e = this;
            var _ind = (this.cantDias+posMes)%7;

            //выбранный день
            //красный круг
            // if(this.diaSeleccionado==fechNow){
            //     div = $("<div class='current-date-selected d-flex border flex-fill w-100 justify-content-center pt-3 pb-3 btn "+this.btnD+"' data-date='"+fechNow+"'>").html(i+1);
            // }
            //выделенные или важные дни
            //зеленый день
            // if(this.diasResal.indexOf(i+1)!=-1){
            //     div = $("<div class='d-flex border flex-fill w-100 justify-content-center pt-3 pb-3 btn "+this.btnD+"' data-date='"+fechNow+"' style='background: "+this.colorResal+"; color: "+this.textResalt+"; font-weight: bold;'>").html(i+1);
            // }

            div.on("click", function(e){
                var daySelec = $(e.target).attr("data-date");
                clas_e.currentSelected = daySelec;
                clas_e.funcPer(clas_e)
            });
            cont.append(div);
            if(cnt==6){
                //div.on("click", this.funcPer);
                cntG.append(cont);
                cont = $("<div class='d-flex border w-100 border-top-0'>");
                cnt = 0;
            }else if(this.cantDias==(i+1)){
                for(var j=0;j<(7-_ind);j++){
                    var div = $(emptyTag).html("0");
                    cont.append(div);
                    cnt++;
                }
                cntG.append(cont);
                cont = $("<div class='d-flex border w-100 border-top-0'>");
                cnt = 0;
            }else{
                //cont.append(div);
                cnt++;
            }
        }
        return cntG;
    }
    ordenarDiasMes(dia){
        var posMes = this.diasLargo.indexOf(dia);
        var fechCort = [];
        var fechLarg = [];

        for(var i=posMes;i<this.diasCoto.length;i++){
            fechCort.push(this.diasCoto[i]);
            fechLarg.push(this.diasLargo[i]);
        }
        for(var j=0;j<posMes;j++){
            fechCort.push(this.diasCoto[j]);
            fechLarg.push(this.diasLargo[j]);
        }
        return {fechCort, fechLarg};
    }
    firtsMayus(letter){
        var lett = "";
        for(var i=0;i<letter.length;i++){
            if(i==0) lett += "" + letter[i].toUpperCase();
            else lett += "" + letter[i].toLowerCase();
        }
        return lett;
    }
    mesAnterior(ev){
        ev.mesSeleccionado--;
        if(ev.mesSeleccionado==0){
            ev.anioSeleccionado--;
            ev.mesSeleccionado=12;
        }
        var day = ev.diaSeleccionado.split("-")[2]*1;
        ev.diaSeleccionado = ev.anioSeleccionado + "-" + ev.mesSeleccionado + "-" + day;
        ev.diaSeleccionado = ev.corregirMesA(ev.diaSeleccionado);
        ev.cantDias = moment(ev.diaSeleccionado).daysInMonth()*1;
        ev.createCalendar();

        if(this.funcPrev){
            this.funcPrev(ev)
        }else{
            ev.createCalendar();
        }
    }
    mesSiguiente(ev){
        ev.mesSeleccionado++;
        if(ev.mesSeleccionado==13){
            ev.anioSeleccionado++;
            ev.mesSeleccionado=1;
        }
        var day = ev.diaSeleccionado.split("-")[2]*1;
        ev.diaSeleccionado = ev.anioSeleccionado + "-" + ev.mesSeleccionado + "-" + day;
        ev.diaSeleccionado = ev.corregirMesA(ev.diaSeleccionado);
        ev.cantDias = moment(ev.diaSeleccionado).daysInMonth()*1;

        if(this.funcNext){
            this.funcNext(ev)
        }else{
            ev.createCalendar();
        }
    }
    corregirMesA(_f){
        var fec = _f.split("-");
        fec[1] = (fec[1]<10&&fec[1].length==1)?("0"+fec[1]):fec[1];
        fec[2] = (fec[2]<10&&fec[2].length==1)?("0"+fec[2]):fec[2];
        return fec.join("-");
    }

    // btn-rounded-success

    chooseDay(){
        var day = document.getElementsByClassName("btn-rounded-success");

        day.on("click", function(e){
            $('#myModal').modal('show');
        });
    }

}
