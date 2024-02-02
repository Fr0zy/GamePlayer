// Retrieve data from local storage
var playerScore = localStorage.getItem('playerscore');

// Define the URL of your Java servlet
var url = '/scoresend';

// Use the fetch API to send a POST request to the server
fetch(url, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify({ data: playerScore }),
})
    .then(response => response.json())
    .then(data => {
        console.log('Data sent to Java:', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });