const variavel = document.getElementById("buttonbackCartazes");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}