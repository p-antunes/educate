import * as fetch from "./functions/fetch.js"

const $ = q => {
    return document.querySelector(q);
};


//Altera o id confirmar para o correspondente do butao da pagina
$('#confirm').addEventListener('click', function () {
    saveData();
});


function saveData() {
    if ($('#email3').value.trim() == '' && $('#descricao').value.trim() == '') {
        Swal.fire(
            'Preencha todos os campos!',
            '',
            'error'
        )
    } else {
        let denounce = {
            "title": $('#email3').value.trim(),
            "description": $('#descricao').value.trim()
        }
        console.log(denounce);
        fetch.postData('reports/anonymous', denounce).then(response => {
            console.log(response)

            if (response.ok) {
                Swal.fire(
                    'A sua denuncia foi enviada com sucesso!',
                    '',
                    'success'
                ).then((result) => {
                    if (result.value) {
                        $('#email3').value = '';
                        $('#descricao').value = '';
                    }
                })
            } else {
                Swal.fire(
                    'Erro de submissao!',
                    '',
                    'error'
                ) 
            }
        }

        );
    }
}