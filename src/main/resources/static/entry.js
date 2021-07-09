let foundationSubmit = document.getElementById('foundationSubmit');
let eventSubmit = document.getElementById('eventSubmit');


eventSubmit.addEventListener('click', ()=> {

    let eventTitle = document.getElementById('eventTitleInput').value;
    let eventDate = document.getElementById('eventDate').value;
    let eventDollars = document.getElementById('eventDollars').value;
    let eventCents = document.getElementById('eventCents').value;

    let dataToSubmit = {};

    if (eventDate === null && eventDollars === null && eventCents === null) {
        dataToSubmit = {
            title: eventTitle
        }
    };

    if 

})




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
});
