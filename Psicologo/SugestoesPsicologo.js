const variavel = document.getElementById("buttonbackSugestoesPsicologo");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}