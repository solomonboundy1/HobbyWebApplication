'use strict';
let inputUpdateShopName = document.querySelector('#inputUpdateShopName');
let inputUpdateShopAddress = document.querySelector('#inputUpdateShopAddress');
let UpdateShopBtn = document.querySelector('#UpdateShopBtn');

let inputUpdateShopId = document.querySelector('#inputUpdateShopId');
const cardParent = document.querySelector('#cardListUpdate');


let updateShop = (id) => {

    let shop = {
        "shopName": inputUpdateShopName.value,
        "address": inputUpdateShopAddress.value
    };

    fetch(`http://localhost:9005/shop/update/${id}`, {
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


UpdateShopBtn.addEventListener('click', function () {
    updateShop(inputUpdateShopId.value);
})
