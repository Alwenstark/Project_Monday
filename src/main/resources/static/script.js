document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission for validation

    // Get password values
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const passwordMessage = document.getElementById('passwordMessage');

    // Password validation regex (minimum 8 characters, uppercase, lowercase, and number)
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;

    if (password !== confirmPassword) {
        passwordMessage.textContent = 'Passwords do not match.';
        passwordMessage.style.display = 'block';
    } else if (!passwordRegex.test(password)) {
        passwordMessage.textContent = 'Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, and a number.';
        passwordMessage.style.display = 'block';
    } else {
        // If validation passes, redirect to the login page
        alert('Sign up successful!');
        window.location.href = 'login.html'; // Redirect to login page (change URL if needed)
    }
});
