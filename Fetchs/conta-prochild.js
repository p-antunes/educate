import * as fetch from "./functions/fetch.js"



const $ = q => {
    return document.querySelector(q);
  };
  

//Altera o id confirmar para o correspondente do butao da pagina
$('#confirm').addEventListener('click', function(){
    saveData();
});


function saveData(){

    //So precisas de alterar os estes paramentros
    let prochild =  {
        "email": $('#email').value,
        "password":$('#pwd').value,
        "confirmPassword":$('#checkPwd').value,
        "name":$('#name').value,
        "birthDate":$('#birthDay').value,
        "phoneNr": $('#phoneNr').value,
        "city":$('#city').value,
        "county": $('#country').value,
        "postalCode":$('#postalCode').value,
        "address":$('#adress').value,
        "role": {"idRole": 5}
        }
      console.log(prochild);
   
      fetch.postData('prochilds', prochild);
}

