fetch(`http://localhost:9005/Shop/getAll`)
    .then((response) => {
        response.json()
            .then((data) => {
                console.log(data);
                console.log(data[0].name);

                // cardName.textContent = "Name :" + data[0].name;
                // cardQuantity.textContent = "Quantity :" + data[0].quantity;
                // cardPriority.textContent = "Priority :" + data[0].high_priority;
                // cardID.textContent = "ID :" + data[0].item_id;

                // For each object in the array
                // Run the createCard method passing in the object
                data.forEach((data) => {
                    createCards(data);
                })

            });
    });


// New function to post data to my web page

let createCards = (data) => {

    // First find my parent element
    const cardParent = document.querySelector('#cardList');

    // Create a new card 
    const child = document.createElement('div');
    const childBody = document.createElement('div');
    const childName = document.createElement('h5');
    const childQuantity = document.createElement('h5');
    const childPriority = document.createElement('h5');
    const childID = document.createElement('h5');

    // Modify my elements, passing in the data

    childName.textContent = "Name: " + data.name
    childQuantity.textContent = "Quantity : " + data.quantity;
    childPriority.textContent = "Priority : " + data.high_priority;
    childID.textContent = "ID : " + data.item_id;

    // Modify the classes in my card
    childBody.className = "card-body";
    child.className = "card";

    // Append the elements
    childBody.appendChild(childName);
    childBody.appendChild(childQuantity);
    childBody.appendChild(childPriority);
    childBody.appendChild(childID);

    child.appendChild(childBody);

    cardParent.appendChild(child);

}