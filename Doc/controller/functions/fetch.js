"use strict";
export { getData, postData, deleteData, postFile,putData };


const urlBase = "http://localhost:8080/api/"

async function getData(route) {
    const response = await fetch(urlBase + route);
    const data = await response.json();
    return data;
}


async function postData(route, data) {
    console.log(urlBase + route)
    const response = await fetch(urlBase + route, {
        credentials: 'include',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("accessToken"),
            'Cookie': 'token=' + sessionStorage.getItem("accessToken")
        },
        method: 'POST',
        body: JSON.stringify(data)
    })
    return response;
}

async function putData(route, data) {
    console.log(urlBase + route)
    const response = await fetch(urlBase + route, {
        credentials: 'include',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("accessToken"),
            'Cookie': 'token=' + sessionStorage.getItem("accessToken")
        },
        method: 'PUT',
        body: JSON.stringify(data)
    })
    return response;
}


async function postFile(route, data){
    console.log(urlBase + route)
    const response = await fetch(urlBase + route, {
        method: 'POST',
        body: data
    })
    console.log(response)
    return response;
}

async function deleteData(route) {
    console.log(urlBase + route)
    const response = await fetch(urlBase + route, {
        credentials: 'include',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("accessToken"),
            'Cookie': 'token=' + sessionStorage.getItem("accessToken")
        },
        method: 'DELETE',
    })
    console.log(response)
    return response;
}



