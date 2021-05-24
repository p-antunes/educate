import * as fetch from "./functions/fetch.js"

const $ = q => {
    return document.querySelector(q);
};

const show = q => {
    $(q).style.display = 'block';
};

getMateriais()

function getMateriais() {
    fetch.getData('files').then(data => {
        console.log(data);
        let txt = ''
        for (let i = 0; i < data.length; i++) {
            console.log(data[i])
            console.log(addAPIToUrl(data[i]))
            let img = addAPIToUrl(data[i])

            txt += '<div class="col-md-6"><img width="500" style="margin:10px; border-radius:10px;" src="' + img + '"></div>'
        }
        console.log(txt)


        $('#images').innerHTML = txt;
    });
}








$('#addFile').addEventListener("click", e => {

    e.preventDefault();

    Swal.fire({
        title: 'Adicionar material',
        inputAttributes: {
            autocapitalize: 'off'
        },
        html: `<label class="custom-file-upload">
        <input id="file" type="file"/>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-upload"
            viewBox="0 0 16 16">
            <path
                d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
            <path
                d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708l3-3z" />
        </svg> Upload do material
        </label><div class="container"><img id="imageSwl" src="" alt="your image" width=180px;
        style="display:none"/></div>`,
        didOpen: () => {
            console.log($('#file'))
            $('#file').addEventListener("change", function () {               
                readURL(this)
            })
        },
        showCancelButton: true,
        confirmButtonText: 'Adicionar',
        cancelButtonText: 'Cancelar',
        confirmButtonColor: '#130470',
        showLoaderOnConfirm: true,
        preConfirm: async () => {
            if ($('#file') == null) {
                Swal.fire(
                    'É necessario escolher um material!',
                    '',
                    'error'
                )
            } else {
                let response = await addFile();
                console.log(response)

                if (response.ok) {
                    Swal.fire(
                        'Material adicionado com sucesso!',
                        '',
                        'success'
                    ).then((result) => {
                        if (result.value) {
                            getMateriais()
                        }
                    })
                } else {
                    Swal.fire(
                        'Não foi possivel adicionar o material!',
                        '',
                        'error'
                    )
                }
            }
        }
    });
})




function addAPIToUrl(obj) {
    let url = obj.url;
    return url.substring(0, 22) + "api/" + url.substring(22,);
}

const addFile = async () => {
    const formData = new FormData();

    console.log($('#file').files);

    formData.append("file", $('#file').files[0]);
    const response = fetch.postFile('upload', formData);
    return response;
}

function readURL(input) {
    show('#imageSwl')
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageSwl')
                .setAttribute('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}



