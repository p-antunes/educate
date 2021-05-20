const checkbox = document.getElementById("checkboxContaFamilias");
checkbox.onclick = checkboxCheckedContaFamilias;

const variavel = document.getElementById("buttonbackContaFamilias");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function checkboxCheckedContaFamilias() {
    if (document.getElementById("checkboxContaFamilias").checked)
        document.getElementById("twelfthBoxContaFamilias").className = "twelfthBoxContaFamilias";
        document.getElementById("textConfirmContaFamilias").className = "textConfirmContaFamilias";

        document.getElementById("thirteenBoxContaFamilias").className = "thirteenBoxContaFamilias";
        document.getElementById("textNewPasswordContaFamilias").className = "textNewPasswordContaFamilias";

        document.getElementById("fourteenBoxContaFamilias").className = "fourteenBoxContaFamilias";
        document.getElementById("textConfirmNewPasswordContaFamilias").className = "textConfirmNewPasswordContaFamilias";
        
        document.getElementById("eleventhBoxContaFamilias").style.background = "#EFF0F6";
        document.getElementById("textChoosePasswordContaFamilias").style.color = "#4C4C4C";

        if ((document.getElementById("checkboxContaFamilias").checked==false)){
        document.getElementById("twelfthBoxContaFamilias").className = "hidden";
        document.getElementById("textConfirmContaFamilias").className = "hidden";

        document.getElementById("thirteenBoxContaFamilias").className = "hidden";
        document.getElementById("textNewPasswordContaFamilias").className = "hidden";

        document.getElementById("fourteenBoxContaFamilias").className = "hidden";
        document.getElementById("textConfirmNewPasswordContaFamilias").className = "hidden";
        
        document.getElementById("eleventhBoxContaFamilias").style.background = "#D8D8D9";
        document.getElementById("textChoosePasswordContaFamilias").style.color = "#9e9e9e";    
        }
}