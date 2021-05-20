const variavel=document.getElementById("firstBlueSquarePaginaInicialCrianças");
variavel.onclick=dadosfirstsquare;

const variavelone=document.getElementById("secondBlueSquarePaginaInicialCrianças");
variavelone.onclick=dadossecondsquare;

const variaveltwo=document.getElementById("thirdBlueSquarePaginaInicialCrianças");
variaveltwo.onclick=dadosthirdsquare;

const variavelthree=document.getElementById("fourthBlueSquarePaginaInicialCrianças");
variavelthree.onclick=dadosfourthsquare;

const variavelfive=document.getElementById("sixthBlueSquarePaginaInicialCrianças");
variavelfive.onclick=dadossixthsquare;

const variavelsix=document.getElementById("iconmenuPaginaInicialCrianças");
variavelsix.onclick=dadosmenu;

const variavelseven=document.getElementById("buttonDenunciaPaginaInicialCrianças");
variavelseven.onclick=denuncia;

const variaveleight=document.getElementById("closeX");
variaveleight.onclick=fechardenuncia;

const variavelnine=document.getElementById("fifthBlueSquarePaginaInicialCrianças");
variavelnine.onclick=linhasapoio;

const variavelten=document.getElementById("closeXLinhasPsicologo");
variavelten.onclick=closelinhasapoio;



function dadosfirstsquare(){
    window.location.href="ChatCrianças.html" //ao carregar no botão vai para a página "ChatCrianças.html"
    }

function dadossecondsquare(){
    window.location.href="JogosCrianças.html" //ao carregar no botão vai para a página "JogosCrianças.html"
    }

function dadosthirdsquare(){
    window.location.href="ForumCrianças.html" //ao carregar no botão vai para a página "ForumCrianças.html"
    }

function dadosfourthsquare(){
    window.location.href="DireitosCrianças.html" //ao carregar no botão vai para a página "DireitosCrianças.html"
    }

function dadossixthsquare(){
    window.location.href="ContaCrianças.html" //ao carregar no botão vai para a página "ContaCrianças.html"
    }

function dadosmenu(){
    window.location.href="MenuCrianças.html" //ao carregar no botão vai para a página "ContaCrianças.html"
    }

function denuncia(){
    document.getElementById("bgmodalPaginaInicialCrianças").className = "bgmodalPaginaInicialCrianças"; 
    }

function fechardenuncia() {
    document.getElementById("bgmodalPaginaInicialCrianças").className="hidden" //carregar no X e fechar o aviso
}

function linhasapoio(){
    document.getElementById("bgmodalLinhasApoioPsicologo").className = "bgmodalLinhasApoioPsicologo"; 
    }

function closelinhasapoio() {
    document.getElementById("bgmodalLinhasApoioPsicologo").className="hidden" //carregar no X e fechar o aviso
}