const variavel=document.getElementById("firstGrayRectangleJogosAdolescentes");
variavel.onclick=dadosfirstrectangle;

const variavelone=document.getElementById("secondGrayRectangleJogosAdolescentes");
variavelone.onclick=dadossecondrectangle;

const variaveltwo=document.getElementById("thirdGrayRectangleJogosAdolescentes");
variaveltwo.onclick=dadossecondrectangle;

const variavelthree = document.getElementById("buttonbackJogosAdolescentes");
variavelthree.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstrectangle(){
    window.location.href="CartazesAdolescentes.html" //ao carregar no botão vai para a página "CartazesAdolescentes.html"
    }

function dadossecondrectangle(){
    window.location.href="SopaLetrasAdolescentes.html" //ao carregar no botão vai para a página "SopaLetrasAdolescentes.html"
    }

function dadossecondrectangle(){
    window.location.href="RankAdolescentes.html" //ao carregar no botão vai para a página "RankAdolescentes.html"
    }