const variavel = document.getElementById("buttonbackForumAdolescentes");
variavel.onclick = goBack;

const variavelone=document.getElementById("firstGrayRectangleForumAdolescentes");
variavelone.onclick=dadosfirstsquare;

const variaveltwo=document.getElementById("secondGrayRectangleForumAdolescentes");
variaveltwo.onclick=dadossecondsquare;

const variavelthree=document.getElementById("thirdGrayRectangleForumAdolescentes");
variavelthree.onclick=dadosthirdsquare;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstsquare(){
    window.location.href="ArtigosAdolescentes.html" //ao carregar no botão vai para a página "ChatAdolescentes.html"
}

function dadossecondsquare(){
    window.location.href="SugestoesAdolescentes.html" //ao carregar no botão vai para a página "JogosAdolescentes.html"
}

function dadosthirdsquare(){
    window.location.href="CriticasAdolescentes.html" //ao carregar no botão vai para a página "ForumAdolescentes.html"
}