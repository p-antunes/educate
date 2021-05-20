const variavel = document.getElementById("buttonbackMenuCrianças");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}