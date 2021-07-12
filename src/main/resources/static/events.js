let eventsTable = document.getElementById('eventsTable');
let eventSurgicalDiv = document.getElementById('eventSurgicalDiv');

let idOfEventToEdit = 0;


async function getListOfEvents() {
    let eventsFromBackend = await fetch("/get-events");
    return await eventsFromBackend.json();
}

const submitEditedEvent = () => {

    let editedDollars = document.getElementById('dollars').value;


    let dataToSubmit = {
        id: idOfEventToEdit,
        title: document.getElementById('title').value,
        date: document.getElementById('date').value,
        totalCostInCents: +(editedDollars * 100) + +document.getElementById('cents').value,
        purpose: document.getElementById('purpose'),
    };

    fetch("/edit-event", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(dataToSubmit),
    }).catch(error => console.log(error))

    loadPage().catch(error => console.log(error));
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

const loadPage = async () => {
    getListOfEvents().then(allEvents => {
        allEvents.forEach(event => {
            let tableRow = document.createElement('tr');
            let titleCell = document.createElement('td');
            let dateCell = document.createElement('td');
            let purposeCell = document.createElement('td');

            titleCell.innerText = event.title;
            dateCell.innerText = event.date;
            purposeCell.innerText = event.purpose.title;

            tableRow.appendChild(titleCell);
            tableRow.appendChild(dateCell);
            tableRow.appendChild(purposeCell);

            tableRow.addEventListener('click', () => {
                openEditingTable(event);
                idOfEventToEdit = event.id;
            })

            eventsTable.appendChild(tableRow);
        })

    });
};

loadPage().catch(error => console.log(error));
