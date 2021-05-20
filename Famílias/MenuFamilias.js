const variavel = document.getElementById("buttonbackMenuFamilias");
variavel.onclick = goBack;

const variavelone = document.getElementById("rectangleContaMenuFamilias");
variavelone.onclick=dadosgreensquare;


function goBack() { //voltar para a página anterior
    window.history.back()
}

function dadosgreensquare(){
    window.location.href="ContaFamilias.html" //ao carregar no botão vai para a página "ContaAdolescentes.html"
}