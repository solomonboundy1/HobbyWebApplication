let readAllSheetMusic = document.querySelector('#ReadAllSheetMusicBtn');

let viewAll = () => {



    fetch(`http://localhost:9005/sheetmusic/getAll`)
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
// New function to post data to my web page

let createCards = (data) => {

    // First find my parent element
    const cardParent = document.querySelector('#cardList');

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
    childShopID.textContent = "Shop ID : " + data.shop_id;

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

readAllSheetMusic.addEventListener('click', viewAll);