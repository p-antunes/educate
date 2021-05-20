const variavel=document.getElementById("firstGrayRectangleDireitosFamilias");
variavel.onclick=dadosfirstbox;

const variavelone=document.getElementById("secondGrayRectangleDireitosFamilias");
variavelone.onclick=dadossecondbox;

const variaveltwo = document.getElementById("buttonbackDireitosFamilias");
variaveltwo.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstbox(){
    window.location.href="VideosAdolescentes.html" //ao carregar no botão vai para a página "VideosCrianças.html"
}

function dadossecondbox(){
    window.location.href="ArtigosDireitosAdolescentes.html" //ao carregar no botão vai para a página "ArtigosCrianças.html"
}