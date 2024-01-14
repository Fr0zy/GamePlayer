const signIn = () => {
    const name = document.getElementById('name-field').value;
    const password = document.getElementById('password-field').value;

    if (name && password) {
        localStorage.setItem('playername', name);
    }
}
