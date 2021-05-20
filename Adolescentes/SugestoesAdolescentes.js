const variavel = document.getElementById("buttonbackSugestoesAdolescentes");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}