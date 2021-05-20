const variavel = document.getElementById("buttonbackBotFamilias");
variavel.onclick = goBack;

function goBack() { //voltar para a página anterior
    window.history.back()
}