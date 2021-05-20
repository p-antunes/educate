const checkbox = document.getElementById("checkboxContaPsicologo");
checkbox.onclick = checkboxCheckedContaPsicologo;

const variavel = document.getElementById("buttonbackContaPsicologo");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function checkboxCheckedContaPsicologo() {
    if (document.getElementById("checkboxContaPsicologo").checked)
        document.getElementById("twelfthBoxContaPsicologo").className = "twelfthBoxContaPsicologo";
        document.getElementById("textConfirmContaPsicologo").className = "textConfirmContaPsicologo";

        document.getElementById("thirteenBoxContaPsicologo").className = "thirteenBoxContaPsicologo";
        document.getElementById("textNewPasswordContaPsicologo").className = "textNewPasswordContaPsicologo";

        document.getElementById("fourteenBoxContaPsicologo").className = "fourteenBoxContaPsicologo";
        document.getElementById("textConfirmNewPasswordContaPsicologo").className = "textConfirmNewPasswordContaPsicologo";
        
        document.getElementById("eleventhBoxContaPsicologo").style.background = "#EFF0F6";
        document.getElementById("textChoosePasswordContaPsicologo").style.color = "#4C4C4C";

        if ((document.getElementById("checkboxContaPsicologo").checked==false)){
        document.getElementById("twelfthBoxContaPsicologo").className = "hidden";
        document.getElementById("textConfirmContaPsicologo").className = "hidden";

        document.getElementById("thirteenBoxContaPsicologo").className = "hidden";
        document.getElementById("textNewPasswordContaPsicologo").className = "hidden";

        document.getElementById("fourteenBoxContaPsicologo").className = "hidden";
        document.getElementById("textConfirmNewPasswordContaPsicologo").className = "hidden";
        
        document.getElementById("eleventhBoxContaPsicologo").style.background = "#D8D8D9";
        document.getElementById("textChoosePasswordContaPsicologo").style.color = "#9e9e9e";    
        }
}