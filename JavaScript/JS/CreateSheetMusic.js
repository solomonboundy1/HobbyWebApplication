
'use strict';

let inputCreateSheetMusicTitle = document.querySelector('#inputCreateSheetMusicTitle');
let inputCreateSheetMusicAuthor = document.querySelector('#inputCreateSheetMusicAuthor');
let inputCreateSheetMusicGenre = document.querySelector('#inputCreateSheetMusicGenre');
let inputCreateSheetMusicPrice = document.querySelector('#inputCreateSheetMusicPrice');
let inputCreateSheetMusicShopId = document.querySelector('#inputCreateSheetMusicShopId');
let createShopBtn = document.querySelector('#CreateSheetMusicBtn');

createShopBtn.addEventListener('click', () => {
    let createSheetMusicTitleValue = inputCreateSheetMusicTitle.value;
    let createSheetMusicAuthorValue = inputCreateSheetMusicAuthor.value;
    let createSheetMusicGenreValue = inputCreateSheetMusicGenre.value;
    let createSheetMusicPriceValue = inputCreateSheetMusicPrice.value;
    let createSheetMusicShopIdValue = inputCreateSheetMusicShopId.value;



    inputCreateSheetMusicTitle.value = "";
    inputCreateSheetMusicAuthor.value = "";
    inputCreateSheetMusicGenre.value = "";
    inputCreateSheetMusicPrice.value = "";
    inputCreateSheetMusicShopId.value = "";

    let newSheetMusic = {


        title: `${createSheetMusicTitleValue}`,
        author: `${createSheetMusicAuthorValue}`,
        genre: `${createSheetMusicGenreValue}`,
        price: `${createSheetMusicPriceValue}`,
        shop: {
            id: `${createSheetMusicShopIdValue}`

        }

    }
    postRequest(newSheetMusic);

})

let postRequest = (newSheetMusic) => {

    console.log(newSheetMusic);
    fetch('http://localhost:9005/sheetmusic/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/JSON',

        },
        body: JSON.stringify(newSheetMusic)
    }).then((response) => {
        console.log(response);
        return response.json();
    }).then((data) => {
        console.log(data);
    });

}

