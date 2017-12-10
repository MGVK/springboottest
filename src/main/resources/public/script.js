$(document).ready(function () {
    printAll();
});

function getIP() {
    $.ajax({

        url: 'ip',
        data: ({123: 123}),
        success: function (data) {
            $("p").text(data);
        }

    });
}

function addUser() {
    $.ajax({
        url: 'add',
        data: ({name: $("#input_name").val(), pass: $("#input_pass").val(),role: $("#input_role").val()}),
        // processData: false,
        success: function () {
            printAll();
            $("#messages").val("Success!")
        }

    }).fail(function () {
        $("#messages").val("Fail!")
    })
}

function dUser() {
    $.ajax({
        url: 'remove',
        data: ({id: $("#input_id").val()}),
        success: function () {
            $("#messages").val("Success!");
            printAll();
        }
    }).fail(function () {
        $("#messages").val("Fail!")
    })
}

function printAll() {
    $.ajax({
        url: 'all'
    }).done(function (data) {
        console.log(data);
        $("#table_users").text(' ');
        $.each(data, function (id, json) {
            $("#table_users").append(
                '<tr>' +
                '<td>' + json.id + '</td>' +
                '<td>' + json.username + '</td>' +
                '<td>' + json.password + '</td>' +
                '<td>' + json.role + '</td>' +
                '</tr>'
            );

        })
    })
}


