const variavel=document.getElementById("firstGrayRectangleDireitosAdolescentes");
variavel.onclick=dadosfirstbox;

const variavelone=document.getElementById("secondGrayRectangleDireitosAdolescentes");
variavelone.onclick=dadossecondbox;

const variaveltwo = document.getElementById("buttonbackDireitosAdolescentes");
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