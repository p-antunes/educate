const variavel = document.getElementById("buttonbackForumPsicologo");
variavel.onclick = goBack;

const variavelone=document.getElementById("firstGrayRectangleForumPsicologo");
variavelone.onclick=dadosfirstsquare;

const variaveltwo=document.getElementById("secondGrayRectangleForumPsicologo");
variaveltwo.onclick=dadossecondsquare;

const variavelthree=document.getElementById("thirdGrayRectangleForumPsicologo");
variavelthree.onclick=dadosthirdsquare;


function goBack() { 
    window.history.back()
}

function dadosfirstsquare(){
    window.location.href="ArtigosPsicologo.html" 
}

function dadossecondsquare(){
    window.location.href="SugestoesPsicologo.html" 
}

function dadosthirdsquare(){
    window.location.href="CriticasPsicologo.html" 
}