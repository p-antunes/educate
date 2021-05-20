const $ = q => {
    return document.querySelector(q);
};


$('#btnlogin').addEventListener('click', function () {
    login();
});


function login() {
    let credenciais = {
        "email": $('#emailLogin').value.trim(),
        "password": $('#pwd1').value.trim(),
    }

    fetch('http://127.0.0.1:8080/api/auth/signin', {
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        mode: 'cors',
        method: 'POST',
        body: JSON.stringify(credenciais),
        credentials: 'include'
    })
        .then(function (response) {
            console.log(response);
            if (!response.ok) {
                throw new Error(response.statusText);
            }
            return response.json();
        })
        .catch(function (err) {
            console.log(err);
        })
        .then(function (result) {
            if (result) {
                sessionStorage.setItem('id_user', result.userId);
                sessionStorage.setItem('role', result.role);
                sessionStorage.setItem("accessToken", result.accessToken);
                console.log(result);

                TypeOfUserPage(result.role);

            } else {
                Swal.fire(
                    'Os dados que inseriu não estão corretos!',
                    '',
                    'warning'
                )
                console.log(result);
            }
        });
};



function TypeOfUserPage(type) {
    switch (type) {
        case "ROLE_CHILD": window.location.replace("./menu_child.html")
            break;
        case "ROLE_TEENAGER": window.location.replace("./menu-adolescente.html")
            break;
        case "ROLE_FAMILY": window.location.replace("./menu-familias.html")
            break;
        case "ROLE_PROCHILDCOLLAB": window.location.replace("./menu-prochild.html")
            break;
        case "ROLE_PSYCHOLOGIST": window.location.replace("./menu-psicologa.html")
            break;
        default:
            break;
    }
}























