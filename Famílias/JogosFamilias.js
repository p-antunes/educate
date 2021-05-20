const variavel=document.getElementById("firstGrayRectangleJogosFamilias");
variavel.onclick=dadosfirstrectangle;

const variavelone=document.getElementById("secondGrayRectangleJogosFamilias");
variavelone.onclick=dadossecondrectangle;

const variaveltwo=document.getElementById("thirdGrayRectangleJogosFamilias");
variaveltwo.onclick=dadossecondrectangle;

const variavelthree = document.getElementById("buttonbackJogosFamilias");
variavelthree.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstrectangle(){
    window.location.href="CartazesJogosFamilias.html" //ao carregar no botão vai para a página "CartazesAdolescentes.html"
    }

function dadossecondrectangle(){
    window.location.href="SopaLetrasJogosFamilias.html" //ao carregar no botão vai para a página "SopaLetrasAdolescentes.html"
    }

function dadossecondrectangle(){
    window.location.href="RankJogosFamilias.html" //ao carregar no botão vai para a página "RankAdolescentes.html"
    }