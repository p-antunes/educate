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


hide('#pwd')
hide('#checkPwd')

fetch.getData('prochilds/' + sessionStorage.getItem("id_user")).then(data => {
  console.log(data)
  $('#email1').value = data.login.email
  $('#pwd').value = data.password
  $('#checkPwd').value = data.confirmPassword
  $('#name').value = data.name
  $('#birthDay').value = getDateFormat(data.birthDate);
  $('#city').value = data.city
  $('#country').value = data.county
  $('#postalCode').value = data.postalCode
  $('#adress').value = data.address
  $('#phoneNr').value = data.phoneNr
})



function getDateFormat(date) {
  let a = new Date().toISOString(date);
  var index = a.indexOf("T");
  console.log(a);
  console.log(a.substring(0, index));
  return a.substring(0, index);
}


$('#toggle-btn-1').addEventListener('change', function () {
  if (this.checked) {
    $('#pwd').value = "";
    $('#checkPwd').value = "";
    show('#pwd')
    show('#checkPwd')
  } else {
    hide('#pwd')
    hide('#checkPwd')
  }
});

$('#confirm').addEventListener('click', function () {
  changePwd().then(response => {
    console.log(response)
    if (response.ok) {
      Swal.fire(
        'Password mudado com sucesso!',
        '',
        'success'
      )
    } else {
      Swal.fire(
        'Não foi possivel alterar a password!',
        '',
        'error'
      )
    }
  })
})



const changePwd = async () => {
  let newPassword = {
    "password": $('#pwd').value,
    "confirmPassword": $('#checkPwd').value
  }
  const response = await fetch.postData('prochilds/' + sessionStorage.getItem('id_user') + '/password', newPassword);
  return response;
}
