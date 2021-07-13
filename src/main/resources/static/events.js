let eventsTable = document.getElementById('eventsTable');
let eventSurgicalDiv = document.getElementById('eventSurgicalDiv');

let eventToDeleteID = 0;


async function getListOfEvents() {
    let eventsFromBackend = await fetch("/get-events");
    return await eventsFromBackend.json();
}

const submitEditedEvent = () => {

    let editedDollars = document.getElementById('dollars').value;

    let dataToSubmit = {
        title: document.getElementById('title').value,
        date: document.getElementById('date').value,
        totalCostInCents: +(editedDollars * 100) + +document.getElementById('cents').value,
    };

    fetch("/delete-event", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: eventToDeleteID
    }).then(() => {
        fetch("/add-event", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(dataToSubmit),
        })
            .then(loadPage).catch(error => console.log(error));
    })
}


const openEditingTable = eventObject => {

    while (eventSurgicalDiv.lastChild) {
        eventSurgicalDiv.removeChild(eventSurgicalDiv.lastChild);
    }

    let inputs = {
        title: eventObject.title,
        date: eventObject.date,
        dollars: '$  ' + ~~(eventObject.totalCostInCents / 100),
        cents: eventObject.totalCostInCents % 100 + '  cents',
        purpose: eventObject.purpose.title
    }


    for (let key in inputs) {
        let input = document.createElement('input');
        inputs[key] === null ? input.placeholder = '' : input.placeholder = inputs[key];
        input.classList.add('editingInput');
        input.id = key;
        eventSurgicalDiv.appendChild(input);
    }

    let submitEditing = document.createElement('button');
    submitEditing.innerText = 'Submit Edited Event';
    submitEditing.classList.add('submitEditing');
    eventSurgicalDiv.appendChild(submitEditing);
    submitEditing.addEventListener('click', submitEditedEvent);
}

async function loadPage() {

    while (eventsTable.lastChild) {
        eventsTable.removeChild(eventsTable.lastChild);
    }

    let headingRow = document.createElement('tr');
    let titleHeader = document.createElement('th');
    let dateHeader = document.createElement('th');
    let purposeHeader = document.createElement('th');
    let costHeader = document.createElement('th');

    titleHeader.innerText = 'Title';
    dateHeader.innerText = 'Date';
    purposeHeader.innerText = 'Purpose';
    costHeader.innerText = 'Cost';

    headingRow.appendChild(titleHeader);
    headingRow.appendChild(dateHeader);
    headingRow.appendChild(purposeHeader);
    headingRow.appendChild(costHeader);

    eventsTable.appendChild(headingRow);

    getListOfEvents().then(allEvents => {
        allEvents.forEach(event => {

            let eventDollars = ~~(event.totalCostInCents / 100)
            let eventCents =
                event.totalCostInCents % 100 === 0 ? '00' : event.totalCostInCents % 100;

            let tableRow = document.createElement('tr');
            let titleCell = document.createElement('td');
            let dateCell = document.createElement('td');
            let purposeCell = document.createElement('td');
            let costCell = document.createElement('td');

            titleCell.innerText = event.title;
            dateCell.innerText = event.date;
            purposeCell.innerText = event.purpose.title;


            costCell.innerText = `${eventDollars}.${eventCents}`;

            tableRow.appendChild(titleCell);
            tableRow.appendChild(dateCell);
            tableRow.appendChild(purposeCell);
            tableRow.appendChild(costCell);

            tableRow.addEventListener('click', () => {
                openEditingTable(event);
                eventToDeleteID = event.id;
            })

            eventsTable.appendChild(tableRow);
        })

    });
};

loadPage().catch(error => console.log(error));
