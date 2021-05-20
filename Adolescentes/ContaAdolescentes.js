const checkbox = document.getElementById("checkboxContaAdolescentes");
checkbox.onclick = checkboxCheckedContaAdolescentes;

const variavel = document.getElementById("buttonbackContaAdolescentes");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function checkboxCheckedContaAdolescentes() {
    if (document.getElementById("checkboxContaAdolescentes").checked)
        document.getElementById("twelfthBoxContaAdolescentes").className = "twelfthBoxContaAdolescentes";
        document.getElementById("textConfirmContaAdolescentes").className = "textConfirmContaAdolescentes";

        document.getElementById("thirteenBoxContaAdolescentes").className = "thirteenBoxContaAdolescentes";
        document.getElementById("textNewPasswordContaAdolescentes").className = "textNewPasswordContaAdolescentes";

        document.getElementById("fourteenBoxContaAdolescentes").className = "fourteenBoxContaAdolescentes";
        document.getElementById("textConfirmNewPasswordContaAdolescentes").className = "textConfirmNewPasswordContaAdolescentes";
        
        document.getElementById("eleventhBoxContaAdolescentes").style.background = "#EFF0F6";
        document.getElementById("textChoosePasswordContaAdolescentes").style.color = "#4C4C4C";

        if ((document.getElementById("checkboxContaAdolescentes").checked==false)){
        document.getElementById("twelfthBoxContaAdolescentes").className = "hidden";
        document.getElementById("textConfirmContaAdolescentes").className = "hidden";

        document.getElementById("thirteenBoxContaAdolescentes").className = "hidden";
        document.getElementById("textNewPasswordContaAdolescentes").className = "hidden";

        document.getElementById("fourteenBoxContaAdolescentes").className = "hidden";
        document.getElementById("textConfirmNewPasswordContaAdolescentes").className = "hidden";
        
        document.getElementById("eleventhBoxContaAdolescentes").style.background = "#D8D8D9";
        document.getElementById("textChoosePasswordContaAdolescentes").style.color = "#9e9e9e";    
        }
}