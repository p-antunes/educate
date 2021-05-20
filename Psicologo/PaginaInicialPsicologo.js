const variavel=document.getElementById("firstGraySquarePaginaInicialPsicologo");
variavel.onclick=dadosfirstsquare;

const variavelone=document.getElementById("secondGraySquarePaginaInicialPsicologo");
variavelone.onclick=dadossecondsquare;

const variaveltwo=document.getElementById("thirdGraySquarePaginaInicialPsicologo");
variaveltwo.onclick=dadosthirdsquare;

const variavelthree=document.getElementById("fourthGraySquarePaginaInicialPsicologo");
variavelthree.onclick=dadosfourthsquare;

const variavelsix=document.getElementById("iconmenuPaginaInicialPsicologo");
variavelsix.onclick=dadosmenu;


function dadosfirstsquare(){
    window.location.href="DenunciasPsicologo.html"
}

function dadossecondsquare(){
    window.location.href="DireitosPsicologo.html"
}

function dadosthirdsquare(){
    window.location.href="ContaPsicologo.html"
}

function dadosfourthsquare(){
    window.location.href="ForumPsicologo.html"
}

function dadosmenu(){
    window.location.href="MenuPsicologo.html"
}