let eventsTable = document.getElementById('eventsTable');

async function getListOfEvents() {
    let eventsFromBackend = await fetch("/get-events");
    return await eventsFromBackend.json();
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

            eventsTable.appendChild(tableRow);
        })

    });
};

loadPage().catch(error => console.log(error));
