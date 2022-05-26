
'use strict';

let inputCreateSheetMusicTitle = document.querySelector('#inputCreateSheetMusicTitle');
let inputCreateSheetMusicAuthor = document.querySelector('#inputCreateSheetMusicAuthor');
let inputCreateSheetMusicGenre = document.querySelector('#inputCreateSheetMusicGenre');
let inputCreateSheetMusicPrice = document.querySelector('#inputCreateSheetMusicPrice');
let inputCreateSheetMusicShopId = document.querySelector('#inputCreateSheetMusicShopId');
let createSheetMusicBtn = document.querySelector('#CreateSheetMusicBtn');
const cardParent = document.querySelector('#cardListCreate1');

createSheetMusicBtn.addEventListener('click', () => {
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
        createCards(data);
    });

}


let createCards = (data) => {

    // First find my parent element

    console.log(cardParent);
    // Create a new card 
    const child = document.createElement('div');
    const childBody = document.createElement('div');
    const childTitle = document.createElement('h5');
    const childAuthor = document.createElement('h5');
    const childGenre = document.createElement('h5');
    const childPrice = document.createElement('h5');
    const childShopID = document.createElement('h5');

    // Modify my elements, passing in the data

    childTitle.textContent = "Title: " + data.title
    childAuthor.textContent = "Author: " + data.author;
    childGenre.textContent = "Genre: " + data.genre;
    childPrice.textContent = "Price: " + data.price;
    childShopID.textContent = "Shop_Id : " + data.shop;

    // Modify the classes in my card
    childBody.className = "card-body";
    child.className = "card";

    // Append the elements
    childBody.appendChild(childTitle);
    childBody.appendChild(childAuthor);
    childBody.appendChild(childGenre);
    childBody.appendChild(childPrice);
    childBody.appendChild(childShopID);


    child.appendChild(childBody);


    cardParent.appendChild(child);


}