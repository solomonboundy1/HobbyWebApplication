'use strict';
let inputUpdateSheetMusicTitle = document.querySelector('#inputUpdateSheetMusicTitle');
let inputUpdateSheetMusicAuthor = document.querySelector('#inputUpdateSheetMusicAuthor');
let inputUpdateSheetMusicGenre = document.querySelector('#inputUpdateSheetMusicGenre');
let inputUpdateSheetMusicPrice = document.querySelector('#inputUpdateSheetMusicPrice');
let inputUpdateSheetMusicShopId = document.querySelector('#inputUpdateSheetMusicShopId');
let UpdateSheetMusicBtn = document.querySelector('#UpdateSheetMusicBtn');

let inputUpdateSheetMusicId = document.querySelector('#inputUpdateSheetMusicId');


let updateSheetMusic = (id) => {

    let shop = {

        title: inputUpdateSheetMusicTitle.value,
        author: inputUpdateSheetMusicAuthor.value,
        genre: inputUpdateSheetMusicGenre.value,
        price: inputUpdateSheetMusicPrice.value,
        shop: {
            id: inputUpdateSheetMusicShopId.value

        }
    };

    fetch(`http://localhost:9005/sheetmusic/update/${id}`, {
        method: `PUT`,
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(shop)
    }).then((response) => {
        response.json();
    })
        .then(() => {
            console.log(`succesful`);
        });

};


UpdateSheetMusicBtn.addEventListener('click', function () {
    updateSheetMusic(inputUpdateSheetMusicId.value);
})