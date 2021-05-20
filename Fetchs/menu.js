import * as fetch from "./functions/fetch.js"



const $ = q => {
    return document.querySelector(q);
  };
  

let typeUser = TypeOfUser(sessionStorage.getItem("role"));
let id = sessionStorage.getItem("id_user");
console.log(typeUser)
fetch.getData(typeUser + "/" + id).then(data => {
    console.log(data)
    $('#tituloMenuChild').innerHTML = `Olá ${data.name} !`

})




function TypeOfUser(type) {
    switch (type) {
        case "ROLE_CHILD": return "children";
        case "ROLE_TEENAGER": return "teenagers"
        case "ROLE_FAMILY": return "family"
        case "ROLE_PROCHILDCOLLAB": return "prochilds"
        case "ROLE_PSYCHOLOGIST": return "psychologists"
        default:
            break;
    }
}