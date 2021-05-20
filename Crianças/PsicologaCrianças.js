const variavel = document.getElementById("buttonbackPsicologaCrianças");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}