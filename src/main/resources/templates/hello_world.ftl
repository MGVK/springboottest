<!DOCTYPE HTML>
<html>

<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>


<body>


<div>
    <label>
        Name
        <input id="input_name">
    </label>
    <label>
        Pass
        <input id="input_pass">
    </label>
    <label>
        Role
        <input id="input_role">
    </label>
    <button onclick="addUser()">AddUser</button>

</div>
<p id="messages">
</p>
<label>
    ID
    <input id="input_id">
</label>
<button onclick="dUser()">DeleteUser</button>

<table border="1px" id="table_users">


</table>


<script language="javascript" src="script.js">

</script>
</body>

</html>