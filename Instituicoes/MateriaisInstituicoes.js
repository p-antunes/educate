const variavel=document.getElementById("firstGrayRectangleMateriaisInstituicoes");
variavel.onclick=dadosfirstrectangle;

const variavelone=document.getElementById("secondGrayRectangleMateriaisInstituicoes");
variavelone.onclick=dadossecondrectangle;

const variavelthree = document.getElementById("buttonbackMateriaisInstituicoes");
variavelthree.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstrectangle(){
    window.location.href="MateriaisInstituicoes.html" //ao carregar no botão vai para a página "CartazesAdolescentes.html"
}

function dadossecondrectangle(){
    window.location.href="TodosMateriaisInstituicoes.html" //ao carregar no botão vai para a página "SopaLetrasAdolescentes.html"
}