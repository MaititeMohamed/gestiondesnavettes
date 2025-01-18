<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-pzjw8f+ua7Kw1TIq0v8Fq6h2AihvhXY3AJe8xxl5xeREc5z6RFAWjt5gkdugdugG" crossorigin="anonymous">
    <style>
        body {
            background-color: #f4f7fc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-container .form-group input {
            font-size: 16px;
            border-radius: 5px;
            padding: 12px 15px;
            width: 100%;
            border: 1px solid #ced4da;
        }
        .login-container .form-group input:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.25);
        }
        .login-container button {
            font-size: 16px;
            padding: 10px 15px;
            width: 100%;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            border: none;
            transition: background-color 0.3s ease;
        }
        .login-container button:hover {
            background-color: #0056b3;
        }
        .login-container .alert {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="POST">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control mb-3" id="password" name="password" placeholder="Password" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block mt-3">Login</button>

            <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger mt-3" role="alert">
                    <%= request.getAttribute("error") %>
                </div>
            <% } %>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zyA7p8Bz4f0Iu0sbP3zM12n6vf1+X2dZ/x8Rexg6" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-ZvpUoO/+Pp8Z2Kn9V7h6ElfX4T4r+nQ9ddVp+GGz2XaRldHhdbBxMJ1oWqZFGxKP" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0v8Fq6h2AihvhXY3AJe8xxl5xeREc5z6RFAWjt5gkdugdugG" crossorigin="anonymous"></script>
</body>
</html>
