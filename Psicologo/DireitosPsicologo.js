const variavel=document.getElementById("firstGrayRectangleDireitosPsicologo");
variavel.onclick=dadosfirstbox;

const variavelone=document.getElementById("secondGrayRectangleDireitosPsicologo");
variavelone.onclick=dadossecondbox;

const variaveltwo = document.getElementById("buttonbackDireitosPsicologo");
variaveltwo.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstbox(){
    window.location.href="VideosPsicologo.html" //ao carregar no botão vai para a página "VideosCrianças.html"
}

function dadossecondbox(){
    window.location.href="ArtigosDireitosPsicologo.html" //ao carregar no botão vai para a página "ArtigosCrianças.html"
}