const variavel = document.getElementById("buttonbackArtigosPsicologo");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}