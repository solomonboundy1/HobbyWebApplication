'use strict';


let inputReadShopId = document.querySelector('#inputReadShopId');
let ReadShopBtn = document.querySelector('#ReadShopBtn');
let newText = document.createElement('p');
let newSearch = document.createElement('div');

newSearch.classList = "searchShopField";






let getRequest = (id) => {
    fetch(`http://localhost:9005/shop/getOne/${id}`, {
        method: 'GET'
    })
        .then((response) => {
            if (response.status !== 202) {
                console.error(`status: ${response.status} `)
                return
            }
            response.json()
                .then((data) => {
                    console.log(data);
                }).catch((error) => {
                    console.error(`${error}`);
                });
        });

}

let readFunction = () => {
    let inputReadShopIdValue = inputReadShopId.value;
    let id = inputReadShopIdValue;
    getRequest(id);

}

// ReadShopBtn.addEventListener('click', readFunction)
// newText.textContent = ""
// newSearch.appendChild(newText);