const variavel = document.getElementById("buttonbackMenuAdolescentes");
variavel.onclick = goBack;

const variavelone = document.getElementById("rectangleContaMenuAdolescentes");
variavelone.onclick=dadosgreensquare;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosgreensquare(){
    window.location.href="ContaAdolescentes.html" //ao carregar no botão vai para a página "ContaAdolescentes.html"
}