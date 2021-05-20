const variavel=document.getElementById("firstYellowBoxDireitosCrianças");
variavel.onclick=dadosfirstbox;

const variavelone=document.getElementById("secondYellowBoxDireitosCrianças");
variavelone.onclick=dadossecondbox;

const variaveltwo = document.getElementById("buttonbackDireitosCrianças");
variaveltwo.onclick = goBack;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosfirstbox(){
    window.location.href="VideosCrianças.html" //ao carregar no botão vai para a página "VideosCrianças.html"
    }

function dadossecondbox(){
    window.location.href="ArtigosCrianças.html" //ao carregar no botão vai para a página "ArtigosCrianças.html"
    }