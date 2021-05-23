const $ = q => {
    return document.querySelector(q);
};

const data = async() => {
    let response = await fetch('./bot.json');
    return response.json();
}

async function queryBot(bot){
    let txt = ``

    for (let i = 0; i < bot.length; i++) {
        console.log(bot[i])
        txt += `<div id="question${i}" class="questions">
             ${bot[i].query}
        </div>`
    }
    console.log(txt)
    $('#bot').innerHTML = txt
}

async function swalBot(bot) {
    for (let i = 0; i < bot.length; i++) {
        $(`#question${i}`).addEventListener('click', function () {
            Swal.fire(
                `${bot[i].query}`,
                `${bot[i].answer}`,
                ''
            )
        });
    }
}

(async() => {
    let queries = await data()
    console.log(await data())
    await queryBot(queries)
    await swalBot(queries)
})()