const variavel = document.getElementById("buttonbackBotAdolescentes");
variavel.onclick = goBack;

function goBack() { //voltar para a página anterior
    window.history.back()
}