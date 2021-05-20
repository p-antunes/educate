const variavel = document.getElementById("buttonbackForumFamilias");
variavel.onclick = goBack;

const variavelone=document.getElementById("firstGrayRectangleForumFamilias");
variavelone.onclick=dadosfirstsquare;

const variaveltwo=document.getElementById("secondGrayRectangleForumFamilias");
variaveltwo.onclick=dadossecondsquare;

const variavelthree=document.getElementById("thirdGrayRectangleForumFamilias");
variavelthree.onclick=dadosthirdsquare;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstsquare(){
    window.location.href="ArtigosFamilias.html" //ao carregar no botão vai para a página "ChatAdolescentes.html"
}

function dadossecondsquare(){
    window.location.href="SugestoesFamilias.html" //ao carregar no botão vai para a página "JogosAdolescentes.html"
}

function dadosthirdsquare(){
    window.location.href="CriticasFamilias.html" //ao carregar no botão vai para a página "ForumAdolescentes.html"
}
