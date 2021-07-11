let foundationSubmit = document.getElementById('foundationSubmit');
let eventSubmit = document.getElementById('eventSubmit');

let purposeDropdown = document.getElementById('purposeDropDown');
let purposeClicker = document.getElementById('purposeClicker');

let foundationDropdown = document.getElementById('foundationDropDown');
let foundationClicker = document.getElementById('foundationClicker');



let chosenFoundations = [];



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

    let dataToSubmit = {};

    if (eventDate === null && eventDollars === null) {
        dataToSubmit = {
            title: eventTitle,
            foundations: chosenFoundations
        }
    } else if (eventDollars === null && eventCents === null) {
        dataToSubmit = {
            title: eventTitle,
            date: eventDate,
            foundations: chosenFoundations


        }
    } else if (eventCents == null) {
        dataToSubmit = {
            title: eventTitle,
            date: eventDate,
            totalCostInCents: eventDollars * 100,
            foundations: chosenFoundations

        }
    } else {
        dataToSubmit = {
            title: eventTitle,
            date: eventDate,
            totalCostInCents: +(eventDollars * 100) + +eventCents,
            foundations: chosenFoundations

        }
    }

    console.log(dataToSubmit)

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


const listFoundations = async () => {
    getListOfFoundations().then(list => {
            list.forEach(foundation => {
                let foundationDiv = document.createElement('div');
                foundationDiv.classList.add('foundationDiv');
                foundationDiv.innerText = foundation.name;
                foundationDiv.addEventListener('click', ()=> {
                    foundationDiv.style.color = 'gold';
                    chosenFoundations.push(foundation);
                })
                foundationDropdown.appendChild(foundationDiv);


                console.log(foundation);
            })


    });
}

const listPurposes = async () => {
    getListOfPurposes().then(list => {
        list.forEach(purpose => {
            let purposeDiv = document.createElement('div');
            purposeDiv.classList.add('foundationDiv');
            purposeDiv.innerText = purpose.title;
            purposeDiv.addEventListener('click', ()=> {
                purposeDiv.style.color = 'gold';
            })
            purposeDropdown.appendChild(purposeDiv);
        })

    })
}

foundationClicker.addEventListener('click', listFoundations);
purposeClicker.addEventListener('click', listPurposes);
