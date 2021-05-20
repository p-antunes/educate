// import * as fetch from "./functions/fetch.js"
const urlBase = "http://localhost:8080/api/"


const $ = q => {
    return document.querySelector(q);
};


//Altera o id confirmar para o correspondente do butao da pagina
$('#btnlogin').addEventListener('click', function () {
    saveData();
});


function saveData() {

    // So precisas de alterar os estes paramentros
    let credenciais = {
        "email": $('#username').value,
        "password": $('#pwd1').value,
    }

    
    console.log(credenciais);

    (async () => {
        const settings = {
            method: 'POST',
            body: JSON.stringify(credenciais),
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            }
        };
        try {
            const fetchResponse = await fetch(`http://localhost:8080/api/auth/signin`, settings);
            const data = await fetchResponse.json();
            console.log(data)
            console.log(data.role)
            console.log(data.userId)
            sessionStorage.setItem('id_user', data.userId);
            sessionStorage.setItem('role', data.role);
            TypeOfUserPage(data.role)
        } catch (e) {
            return e;
        }

    })()


}

function TypeOfUserPage(type) {
    switch (type) {
        case "ROLE_CHILD": window.location = "menu_child.html"
            break;
        case "ROLE_TEENAGER": window.location = "menu-adolescente.html"
            break;
        case "ROLE_FAMILY": window.location = "menu-familias.html"
            break;
        case "ROLE_PROCHILDCOLLAB": window.location = "menu-prochild.html"
            break;
        case "ROLE_PSYCHOLOGIST": window.location = "menu-psicologa.html"
            break;
        default:
            break;
    }
}























