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
document.querySelectorAll('.role-button').forEach(button => {
    button.addEventListener('click', () => {
        // Remove 'selected' class from all buttons
        document.querySelectorAll('.role-button').forEach(btn => btn.classList.remove('selected'));

        // Add 'selected' class to the clicked button
        button.classList.add('selected');

        // Set the role value for form submission
        document.getElementById('role').value = button.value;
    });
});
