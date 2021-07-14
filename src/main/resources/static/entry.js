let foundationSubmit = document.getElementById('foundationSubmit');
let eventSubmit = document.getElementById('eventSubmit');

let purposeDropdown = document.getElementById('purposeDropDown');
let purposeClicker = document.getElementById('purposeClicker');

let foundationDropdown = document.getElementById('foundationDropDown');


let chosenFoundations = [];
let selectedPurpose = {};
let idAndFoundationCombos = [];

// let idsToQuery = [];


async function getListOfPurposes() {
    let purposesFromBackend = await fetch('/get-purposes');
    return await purposesFromBackend.json();
}




eventSubmit.addEventListener('click', () => {

    let transactionObjectsToSend = [];

    event.preventDefault();

    let eventTitle = document.getElementById('eventTitleInput').value;
    let eventDate = document.getElementById('eventDate').value;
    let eventDollars = document.getElementById('eventDollars').value;
    let eventCents = document.getElementById('eventCents').value;

    idAndFoundationCombos.forEach(combo => {
        transactionObjectsToSend.push({
            foundation: combo.foundation,
            totalPennies: +document.getElementById(combo.id).value * 100,
        })
    })

    let dataToSubmit = {
        title: eventTitle,
        date: eventDate,
        totalCostInCents: +(eventDollars * 100) + +eventCents,
        purpose: selectedPurpose,
        transactions: transactionObjectsToSend
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

    transactionObjectsToSend = [];

    idAndFoundationCombos.forEach(combo => {
       document.getElementById(combo.id).value = '';
        })

});





const showMatchingFoundations = purpose => {

    idAndFoundationCombos = [];


    fetch('/get-matching-foundations', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(purpose),
    })
        .then(data => data.json()).then(listOfPossibles => {
            listOfPossibles.forEach(possibleFoundation => {

                const { id, name, contributionInPennies } = possibleFoundation;

                let foundationDollars = ~~(contributionInPennies / 100)
                let foundationCents =
                    contributionInPennies % 100 === 0 ? '00' : contributionInPennies % 100;

                let foundationRow = document.createElement('tr');
                let foundationName = document.createElement('td');
                let availableFunds = document.createElement('td');
                let inputForFunds = document.createElement('input');

                inputForFunds.id = id;

                let foundationAndIdToQuery = {
                    id,
                    foundation: possibleFoundation
                }

                idAndFoundationCombos.push(foundationAndIdToQuery);


                foundationName.classList.add('foundation');

                foundationName.innerText = name;
                availableFunds.innerText = `${foundationDollars}.${foundationCents}`;
                availableFunds.classList.add('availableFunds');

                foundationRow.appendChild(foundationName);
                foundationRow.appendChild(availableFunds);
                foundationRow.appendChild(inputForFunds);
                foundationDropdown.appendChild(foundationRow);
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

// const sendUpTransactions = () => {
//     idsToQuery.forEach(id => {
//         let transactionToSend = {
//             id,
//             totalPennies: +document.getElementById(id).value * 100
//         }
//         fetch('/add-transaction', {
//             method: 'POST',
//             headers: {
//                 "Content-Type": "application/json",
//             },
//             body: JSON.stringify(transactionToSend)
//         }).catch(error => console.log(error))
//     })
// }

