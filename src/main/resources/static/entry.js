let foundationSubmit = document.getElementById('foundationSubmit');
let eventSubmit = document.getElementById('eventSubmit');

let purposeDropdown = document.getElementById('purposeDropDown');
let purposeClicker = document.getElementById('purposeClicker');

let foundationDropdown = document.getElementById('foundationDropDown');
// let foundationClicker = document.getElementById('foundationClicker');

let chosenFoundations = [];
let selectedPurpose = {};

let clicked = {purposes: false, foundations: false};

const eraseAllDisplays = () => {
    while (purposeDropdown.lastChild) {
        purposeDropdown.removeChild(purposeDropdown.lastChild);
    }

    while (foundationDropdown.lastChild) {
        foundationDropdown.removeChild(foundationDropdown.lastChild);
    }

}

async function getListOfFoundations() {
    let foundationsFromBackend = await fetch("/get-foundations");
    return await foundationsFromBackend.json();
}

async function getListOfPurposes() {
    let purposesFromBackend = await fetch('/get-purposes');
    return await purposesFromBackend.json();
}


eventSubmit.addEventListener('click', () => {

    event.preventDefault();

    let eventTitle = document.getElementById('eventTitleInput').value;
    let eventDate = document.getElementById('eventDate').value;
    let eventDollars = document.getElementById('eventDollars').value;
    let eventCents = document.getElementById('eventCents').value;

    let dataToSubmit = {
        title: eventTitle,
        date: eventDate,
        totalCostInCents: +(eventDollars * 100) + +eventCents,
        purpose: selectedPurpose,
        foundations: chosenFoundations,
    };


    fetch("/add-event", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(dataToSubmit),
    }).catch(error => console.log(error))

    document.getElementById('eventTitleInput').value = '';
    document.getElementById('eventDate').value = '';
    document.getElementById('eventDollars').value = '';
    document.getElementById('eventCents').value = '';

});


foundationSubmit.addEventListener('click', () => {
    let foundationName = document.getElementById('foundationName').value;
    console.log(foundationName);

    let dataToSubmit = {
        name: foundationName
    }

    fetch("/add-foundation", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(dataToSubmit),
    }).catch(error => console.log(error))

    document.getElementById('foundationName').value = '';
});


const showMatchingFoundations = purpose => {
    fetch('/get-matching-foundations', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(purpose),
    })
        .then(data => data.json()).then(listOfPossibles => {
            listOfPossibles.forEach(possibleFoundation => {


                let foundationRow = document.createElement('tr');
                let foundationName = document.createElement('td');
                let availableFunds = document.createElement('td');
                let inputForFunds = document.createElement('input');

                foundationName.classList.add('foundationDiv');

                foundationName.innerText = possibleFoundation.name;
                availableFunds.innerText = possibleFoundation.contributionAmount;

                foundationRow.appendChild(foundationName);
                foundationRow.appendChild(availableFunds);
                foundationRow.appendChild(inputForFunds);
                foundationDropdown.appendChild(foundationRow);


                // let foundationDiv = document.createElement('div');
                // let foundationInput = document.createElement('input');
                // foundationInput.style.display = 'none';
                //
                // foundationDiv.classList.add('foundationDiv');
                // foundationDiv.innerText = possibleFoundation.name;
                // foundationDiv.addEventListener('click', () => {
                //     foundationDiv.style.color = 'gold';
                //     foundationInput.style.display = 'block';
                //     chosenFoundations.push(possibleFoundation);
                // })
                //
                // foundationDiv.appendChild(foundationInput);
                // foundationDropdown.appendChild(foundationDiv);

            })

    })
        .catch(error => console.log(error));

}


const listPurposes = async () => {



    getListOfPurposes().then(list => {
        list.forEach(purpose => {
            let purposeDiv = document.createElement('div');
            purposeDiv.classList.add('foundationDiv');
            purposeDiv.innerText = purpose.title;
            purposeDiv.addEventListener('click', () => {
                let purposes = Array.from(purposeDropdown.querySelectorAll('.foundationDiv'));
                purposes.forEach(singlePurpose => {
                    singlePurpose.style.color = 'darkgreen'
                });

                purposeDiv.style.color = 'violet';
                selectedPurpose = purpose;

                while(foundationDropdown.lastChild) {
                    foundationDropdown.removeChild(foundationDropdown.lastChild);
                }
                showMatchingFoundations(purpose);
            })
            purposeDropdown.appendChild(purposeDiv);
        })

    })
}

purposeClicker.addEventListener('click', listPurposes);



// foundationClicker.addEventListener('click', listFoundations);

// const listFoundations = async () => {
//
//     getListOfFoundations().then(list => {
//         list.forEach(foundation => {
//             let foundationDiv = document.createElement('div');
//
//             let foundationInput = document.createElement('input');
//             foundationInput.style.display = 'none';
//
//             foundationDiv.classList.add('foundationDiv');
//             foundationDiv.innerText = foundation.name;
//             foundationDiv.addEventListener('click', () => {
//                 foundationDiv.style.color = 'gold';
//                 foundationInput.style.display = 'block';
//                 chosenFoundations.push(foundation);
//             })
//
//             foundationDiv.appendChild(foundationInput);
//             foundationDropdown.appendChild(foundationDiv);
//
//         })
//     });
// }
