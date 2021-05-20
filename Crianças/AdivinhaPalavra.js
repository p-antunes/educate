const variavel = document.getElementById("buttonbackSopaLetras");
variavel.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}