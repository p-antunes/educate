const variavel=document.getElementById("firstGrayRectangleMateriaisFamilias");
variavel.onclick=dadosfirstrectangle;

const variavelone=document.getElementById("secondGrayRectangleMateriaisFamilias");
variavelone.onclick=dadossecondrectangle;

const variavelthree = document.getElementById("buttonbackMateriaisFamilias");
variavelthree.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstrectangle(){
    window.location.href="MateriaisMateriaisFamilias.html" //ao carregar no botão vai para a página "CartazesAdolescentes.html"
}

function dadossecondrectangle(){
    window.location.href="TodosMateriaisMateriaisFamilias.html" //ao carregar no botão vai para a página "SopaLetrasAdolescentes.html"
}