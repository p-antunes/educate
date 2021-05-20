const checkbox = document.getElementById("checkboxContaCrianças");
checkbox.onclick = checkboxCheckedContaCrianças;

const variavel = document.getElementById("buttonbackContaCrianças");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function checkboxCheckedContaCrianças() {
    if (document.getElementById("checkboxContaCrianças").checked)
        document.getElementById("twelfthBoxContaCrianças").className = "twelfthBoxContaCrianças";
        document.getElementById("textConfirmContaCrianças").className = "textConfirmContaCrianças";

        document.getElementById("thirteenBoxContaCrianças").className = "thirteenBoxContaCrianças";
        document.getElementById("textNewPasswordContaCrianças").className = "textNewPasswordContaCrianças";

        document.getElementById("fourteenBoxContaCrianças").className = "fourteenBoxContaCrianças";
        document.getElementById("textConfirmNewPasswordContaCrianças").className = "textConfirmNewPasswordContaCrianças";
        
        document.getElementById("eleventhBoxContaCrianças").style.background = "#EFF0F6";
        document.getElementById("textChoosePasswordContaCrianças").style.color = "#4C4C4C";

        if ((document.getElementById("checkboxContaCrianças").checked==false)){
        document.getElementById("twelfthBoxContaCrianças").className = "hidden";
        document.getElementById("textConfirmContaCrianças").className = "hidden";

        document.getElementById("thirteenBoxContaCrianças").className = "hidden";
        document.getElementById("textNewPasswordContaCrianças").className = "hidden";

        document.getElementById("fourteenBoxContaCrianças").className = "hidden";
        document.getElementById("textConfirmNewPasswordContaCrianças").className = "hidden";
        
        document.getElementById("eleventhBoxContaCrianças").style.background = "#D8D8D9";
        document.getElementById("textChoosePasswordContaCrianças").style.color = "#9e9e9e";    
        }
}