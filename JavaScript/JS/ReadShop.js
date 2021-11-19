let readAllShopBtn = document.querySelector('#ReadAllShopBtn');
let readShopBtn = document.querySelector('#ReadShopBtn');
let inputReadShopId = document.querySelector('#inputReadShopId');
const cardParent = document.querySelector('#cardList');

let readId = () => {
    let idValue = inputReadShopId.value;

    viewOne(idValue);

}
let viewAll = () => {



    fetch(`http://localhost:9005/shop/getAll`)
        .then((response) => {
            response.json()
                .then((data) => {
                    console.log(data);
                    console.log(data[0].name);
                    data.forEach((data) => {
                        createCards(data);
                    })

                });
        });

}

let viewOne = (id) => {

    fetch(`http://localhost:9005/shop/getOne/${id}`)
        .then((response) => {
            response.json()
                .then((data) => {
                    console.log(data);
                    createCards(data);
                });
        });

}
// New function to post data to my web page

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

readAllShopBtn.addEventListener('click', viewAll);
readShopBtn.addEventListener('click', readId);