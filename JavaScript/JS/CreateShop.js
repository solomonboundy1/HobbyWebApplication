
'use strict';

let inputCreateShopName = document.querySelector('#inputCreateShopName');
let inputCreateShopAddress = document.querySelector('#inputCreateShopAddress');
let createShopBtn = document.querySelector('#CreateShopBtn');
const cardParent = document.querySelector('#cardListCreate');



createShopBtn.addEventListener('click', () => {
    let createShopNameValue = inputCreateShopName.value;
    let createShopAddressValue = inputCreateShopAddress.value;

    inputCreateShopName.value = "";
    inputCreateShopAddress.value = "";

    let newShop = {


        shopName: `${createShopNameValue}`,
        address: `${createShopAddressValue}`


    }
    postRequest(newShop);

})

let postRequest = (newShop) => {

    console.log(newShop);
    fetch('http://localhost:9005/shop/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/JSON',

        },
        body: JSON.stringify(newShop)
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
    const childId = document.createElement('h5');
    const childShopName = document.createElement('h5');
    const childAddress = document.createElement('h5');

    // Modify my elements, passing in the data

    childId.textContent = "ID: " + data.id
    childShopName.textContent = "Shop Name: " + data.shopName;
    childAddress.textContent = "Address: " + data.address;

    // Modify the classes in my card
    childBody.className = "card-body";
    child.className = "card";

    // Append the elements
    childBody.appendChild(childId);
    childBody.appendChild(childShopName);
    childBody.appendChild(childAddress);

    child.appendChild(childBody);


    cardParent.appendChild(child);



}

