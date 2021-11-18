
'use strict';

let inputCreateShopName = document.querySelector('#inputCreateShopName');
let inputCreateShopAddress = document.querySelector('#inputCreateShopAddress');
let createShopBtn = document.querySelector('#CreateShopBtn');

createShopBtn.addEventListener('click', () => {
    let createShopNameValue = inputCreateShopName.value;
    let createShopAddressValue = inputCreateShopAddress.value;

    inputCreateShopName.value = "";
    inputCreateShopAddress.value = "";

    let newShop = {


        shopName: `${createShopNameValue}`,
        address: `${createShopAddressValue}`,


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
    });

}

