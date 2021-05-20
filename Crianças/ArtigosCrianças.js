const variavel = document.getElementById("buttonbackArtigosCrianças");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}