const variavel = document.getElementById("buttonbackCriticasPsicologo");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}