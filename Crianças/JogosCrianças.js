const variavelone=document.getElementById("secondRoseRectangleJogosCrianças");
variavelone.onclick=dadossecondrectangle;

const variaveltwo = document.getElementById("buttonbackJogosCrianças");
variaveltwo.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadossecondrectangle(){
    window.location.href="AdivinhaPalavra.html" //ao carregar no botão vai para a página "SopaLetras.html"
    }