const checkbox = document.getElementById("anotherCombobox");
checkbox.onclick = comboboxRegisto;


function comboboxRegisto() {
    if (document.getElementById("anotherCombobox").checked)
        document.getElementById("twelfthBoxContaCrianças").className = "twelfthBoxContaCrianças";
        document.getElementById("textConfirmContaCrianças").className = "textConfirmContaCrianças";

        document.getElementById("thirteenBoxContaCrianças").className = "thirteenBoxContaCrianças";
        document.getElementById("textNewPasswordContaCrianças").className = "textNewPasswordContaCrianças";

        document.getElementById("fourteenBoxContaCrianças").className = "fourteenBoxContaCrianças";
        document.getElementById("textConfirmNewPasswordContaCrianças").className = "textConfirmNewPasswordContaCrianças";
        
        document.getElementById("eleventhBoxContaCrianças").style.background = "#EFF0F6";
        document.getElementById("textChoosePasswordContaCrianças").style.color = "#4C4C4C";

        if ((document.getElementById("checkboxContaCrianças").checked==false)){
        document.getElementById("twelfthBoxContaCrianças").className = "hidden";
        document.getElementById("textConfirmContaCrianças").className = "hidden";

        document.getElementById("thirteenBoxContaCrianças").className = "hidden";
        document.getElementById("textNewPasswordContaCrianças").className = "hidden";

        document.getElementById("fourteenBoxContaCrianças").className = "hidden";
        document.getElementById("textConfirmNewPasswordContaCrianças").className = "hidden";
        
        document.getElementById("eleventhBoxContaCrianças").style.background = "#D8D8D9";
        document.getElementById("textChoosePasswordContaCrianças").style.color = "#9e9e9e";    
        }
}




import * as fetch from "./functions/fetch.js"


const $ = q => {
  return document.querySelector(q);
};

const show = q => {
  $(q).style.display = 'block';
};

const hide = q => {
  $(q).style.display = 'none';
};

document.querySelector('.country_select').addEventListener('change', (event) => {
  getParamsUsers(event.target.value)
  sessionStorage.setItem('type', event.target.value)
})



$('#btnRegistar').addEventListener('click', function(){
  let type = sessionStorage.getItem('type'); 
  let userRoute = getTypeUser(type)
  let userData = getDataParms(type);
  console.log(userRoute)
  console.log(userData)
  fetch.postData(userRoute, userData);
})


function getDataParms(type){
  let dataChild =  {
    "email": $('#email').value,
    "password":$('#pwd').value,
    "confirmPassword":$('#checkPwd').value,
    "name":$('#name').value,
    "birthDate":$('#birthDay').value + " 00:00:00",
    "city":$('#city').value,
    "county": $('#country').value,
    "postalCode":$('#postalCode').value,
    "address":$('#adress').value,
    "school":$('#school').value,
    "role": {"idRole": 1}
    }

    let dataTeenager =  {
      "email": $('#email').value,
      "password":$('#pwd').value,
      "confirmPassword":$('#checkPwd').value,
      "name":$('#name').value,
      "birthDate":$('#birthDay').value + " 00:00:00",
      "phoneNr": $('#phoneNr').value,
      "city":$('#city').value,
      "county": $('#country').value,
      "postalCode":$('#postalCode').value,
      "address":$('#adress').value,
      "school":$('#school').value,
      "role": {"idRole": 2}
      }

      let dataFamily = {
        "email": $('#email').value,
        "password": $('#pwd').value,
        "confirmPassword": $('#checkPwd').value,
        "name": $('#name').value,
        "birthDate": $('#birthDay').value + " 00:00:00",
        "phoneNr": $('#phoneNr').value,
        "city": $('#city').value,
        "county": $('#country').value,
        "postalCode": $('#postalCode').value,
        "address": $('#adress').value,
        "role": { "idRole": 3 }
    }

      let dataProchild =  {
        "email": $('#email').value,
        "password":$('#pwd').value,
        "confirmPassword":$('#checkPwd').value,
        "name":$('#name').value,
        "birthDate":$('#birthDay').value + " 00:00:00",
        "phoneNr": $('#phoneNr').value,
        "city":$('#city').value,
        "county": $('#country').value,
        "postalCode":$('#postalCode').value,
        "address":$('#adress').value,
        "role": {"idRole": 5}
        }

        let psychologist =  {
          "email": $('#email').value,
          "password":$('#pwd').value,
          "confirmPassword":$('#checkPwd').value,
          "name":$('#name').value,
          "birthDate":$('#birthDay').value + " 00:00:00",
          "phoneNr": $('#phoneNr').value,
          "city":$('#city').value,
          "county": $('#country').value,
          "postalCode":$('#postalCode').value,
          "address":$('#adress').value,
          "role": {"idRole": 6}
          }


        switch (type) {
          case '1': return dataChild
            break;
          case '2': return dataTeenager
            break;
          case '3': return dataFamily
            break;
          case '4': return psychologist
            break;
          case '5': return dataProchild
            break;
        }

}

function getTypeUser(type){
  switch (type) {
    case '1': return "children"
      break;
    case '2': return "teenagers"
      break;
    case '3': return "family"
      break;
    case '4': return "psychologists"
      break;
    case '5': return "prochilds"
      break;
  }
}




function getParamsUsers(type) {
  console.log(type)
  getNoneParms()

  switch (type) {
    case '1': getChildParms()
      break;
    case '2': getTeenagerParms()
      break;
    case '3': getAdultsParms()
      break;
    case '4': getAdultsParms()
      break;
    case '5': getAdultsParms()
      break;
  }
}


function getNoneParms() {
  hide("#name")
  hide("#birthDay")
  hide("#email")
  hide("#postalCode")
  hide("#city")
  hide("#country")
  hide("#adress")
  hide("#phoneNr")
  hide("#school")
  hide("#pwd")
  hide("#checkPwd")
};

function getTeenagerParms() {
  show("#name")
  show("#birthDay")
  show("#email")
  show("#postalCode")
  show("#city")
  show("#country")
  show("#adress")
  show("#phoneNr")
  show("#school")
  show("#pwd")
  show("#checkPwd")
}


function getAdultsParms() {
  show("#name")
  show("#birthDay")
  show("#email")
  show("#postalCode")
  show("#city")
  show("#country")
  show("#adress")
  show("#phoneNr")
  show("#pwd")
  show("#checkPwd")
}

function getChildParms() {
  show("#name")
  show("#birthDay")
  show("#email")
  show("#postalCode")
  show("#city")
  show("#country")
  show("#adress")
  show("#school")
  show("#pwd")
  show("#checkPwd")
}




// //Altera o id confirmar para o correspondente do butao da pagina
// $('#confirm').addEventListener('click', function(){
//     saveData();
// });


// function saveData(){

//     //So precisas de alterar os estes paramentros
//     let teenager =  {
//         "email": $('#email').value,
//         "password":$('#pwd').value,
//         "confirmPassword":$('#checkPwd').value,
//         "name":$('#name').value,
//         "birthDate":$('#birthDay').value,
//         "phoneNr": $('#phoneNr').value,
//         "city":$('#city').value,
//         "county": $('#country').value,
//         "postalCode":$('#postalCode').value,
//         "address":$('#adress').value,
//         "school":$('#school').value,
//         "role": {"idRole": 2}
//         }
//       console.log(teenager);

//       fetch.postData('teenagers', teenager);
// }







// $('#typeUser').addEventListener("change", function() {
//     if($('#typeUser').value == "addNew")
//     {
//         addActivityItem();
//     }
// });

// function addActivityItem() {
//     // ... Code to add item here
// }

































































