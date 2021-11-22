'use strict';



let deleteRequest = (id) => {

    fetch(`http://localhost:9005/shop/delete/${id}`, {
        method: 'DELETE'
    })
        .then((response) => {
            if (response.status !== 204) {
                console.error(`status: ${response.status} `);
                return;
            }
            console.log("delete successful!");

        });

}

let deleteShopButton = document.querySelector('#DeleteShopBtn');
console.log(deleteShopButton);

let deleteText = document.querySelector('#inputDeleteShop');

let deleteFunction = () => {
    let deleteTextValue = deleteText.value;
    let id = deleteTextValue;
    deleteRequest(id);


}


deleteShopButton.addEventListener('click', deleteFunction);
