
let foundationTable = document.getElementById('foundationTable');

async function getListOfFoundations() {
    let foundationsFromBackend = await fetch("/get-foundations");
    return await foundationsFromBackend.json();
}


async function loadPage() {


    getListOfFoundations().then(allFoundations => {
        allFoundations.forEach(foundation => {

            let row = document.createElement('tr');
            const { name, purpose, contributionInPennies } = foundation;

            let foundationDollars = ~~(contributionInPennies / 100)
            let foundationCents =
                contributionInPennies % 100 === 0 ? '00' : contributionInPennies % 100;

            let newFields = {
                nameCell: document.createElement('td'),
                purposeCell: document.createElement('td'),
                moneyCell: document.createElement('td')
            }

            newFields.nameCell.innerText = name;
            newFields.purposeCell.innerText = purpose.title;
            newFields.moneyCell.innerText = `${foundationDollars}.${foundationCents}`;

            for (let key in newFields) {
                row.appendChild(newFields[key]);
            }

            foundationTable.appendChild(row);
        })
    })


}


loadPage().catch(error => console.log(error));
