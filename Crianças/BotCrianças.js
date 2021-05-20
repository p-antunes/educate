const variavel = document.getElementById("buttonbackBotCrianças");
variavel.onclick = goBack;

function goBack() { //voltar para a página anterior
    window.history.back()
}