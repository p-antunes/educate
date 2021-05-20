import * as fetch from "./functions/fetch.js"



const $ = q => {
    return document.querySelector(q);
  };
  

  

fetch.getData('children/' + sessionStorage.getItem("id_user")).then(data => {
  console.log(data)
  $('#email').value = data.login.email
  $('#pwd').value = data.password
  $('#checkPwd').value = data.confirmPassword
  $('#name').value = data.name  
  $('#birthDay').value = getDateFormat(data.birthDate);
  $('#city').value = data.city
  $('#country').value = data.county
  $('#postalCode').value = data.postalCode
  $('#adress').value = data.address
  $('#school').value = data.school
})


function getDateFormat(date){
  let a = new Date().toISOString();
  var index = a.indexOf("T");
  console.log(a);
  console.log(a.substring(0, index));
  return a.substring(0, index);
}

//Altera o id confirmar para o correspondente do butao da pagina
// $('#confirm').addEventListener('click', function(){
//     saveData();
// });


// function saveData(){

//     //So precisas de alterar os estes paramentros
    // let dataChild =  {
    //     "email": $('#email').value,
    //     "password":$('#pwd').value,
    //     "confirmPassword":$('#checkPwd').value,
    //     "name":$('#name').value,
    //     "birthDate":$('#birthDay').value,
    //     "city":$('#city').value,
    //     "county": $('#country').value,
    //     "postalCode":$('#postalCode').value,
    //     "address":$('#adress').value,
    //     "school":$('#school').value,
    //     "role": {"idRole": 1}
    //     }
//       console.log(dataChild);
   
//       fetch.postData('children', dataChild);
// }

  
  
  



















