let eventsTable = document.getElementById('eventsTable');
let eventSurgicalDiv = document.getElementById('eventSurgicalDiv');

let purposeHeader = document.getElementById('purposeHeader');

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

    getListOfEvents().then(allEvents => {
        allEvents.forEach(event => {

            let listOfTransactionElements = [];
            let clicked = false;

            let eventDollars = ~~(event.totalCostInCents / 100)
            let eventCents =
                event.totalCostInCents % 100 === 0 ? '00' : event.totalCostInCents % 100;

            let tableRow = document.createElement('tr');

            tableRow.classList.add('eventRow');

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

                if (!clicked) {
                    listOfTransactionElements.forEach(element => element.style.display = 'flex')
                    clicked = true;
                } else {
                    listOfTransactionElements.forEach(element => element.style.display = 'none');
                    clicked = false;
                }
            })

            eventsTable.appendChild(tableRow);

            event.transactions.forEach(transaction => {
                let transactionDiv = document.createElement('div');

                let dollars = ~~(transaction.totalPennies / 100);

                let cents =
                    transaction.totalPennies % 100 === 0 ? '00' : transaction.totalPennies % 100;

                transactionDiv.classList.add('accordionContainer');
                transactionDiv.style.display = 'none'

                let transactFoundationDiv = document.createElement('div');
                let transactAmountDiv = document.createElement('div');

                transactFoundationDiv.classList.add('accordionFoundationName');
                transactAmountDiv.classList.add('accordionAmount');

                transactFoundationDiv.innerText = transaction.foundation.name;
                transactAmountDiv.innerText = `${dollars}.${cents}`;

                transactionDiv.appendChild(transactFoundationDiv);
                transactionDiv.appendChild(transactAmountDiv);

                eventsTable.appendChild(transactionDiv)
                listOfTransactionElements.push(transactionDiv);
            })

        })

    });
};


purposeHeader.addEventListener('click', () => {
    while (eventsTable.querySelector('.eventRow')) {
        eventsTable.removeChild(document.querySelector('.eventRow'));
    }

})


loadPage().catch(error => console.log(error));
