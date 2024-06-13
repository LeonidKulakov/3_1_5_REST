/*
* Заполнение таблицы пользователями
* innerHTML для передачи контента
* insertRow и insertCell для создания строк и столюцов соответственно
* */
function getUserList() {
    const tableBody = document.getElementById("usersTBody");
    fetch('/users')
        .then(response => response.json())
        .then(users => {
            tableBody.innerHTML = '';
            for (const user of users) {
                let row = tableBody.insertRow();
                row.insertCell().innerHTML = user.id
                row.insertCell().innerHTML = user.username
                row.insertCell().innerHTML = user.city
                row.insertCell().innerHTML = user.age
                row.insertCell().innerHTML = user.roles.map(function (role) {
                    return ' ' + role.name;
                });
                row.insertCell().innerHTML =
                    '<button class="btn btn-info" type="submit" onclick="getEditModal(' + user.id + ')" data-bs-toggle="modal" data-bs-target="#modalEdit">Edit</button>';
                row.insertCell().innerHTML =
                    '<button class="btn btn-danger" type="submit" onclick="" data-toggle="modal" data-target="#modalDelete">Delete</button>';
            }
        })
        .catch(error => console.error('Ошибка:', error));
}

//Заполнение таблицы пользователями(конец)
//первое заполнение при старте страницы
getUserList()

//Обработка изменения
function getEditModal(id) {
    let form = document.forms.namedItem("editForm");
    fillModal(id, form)
}

function getDeleteModal(id) {
    let form = document.forms.namedItem("deleteForm");
    fillModal(id, form)
}

function fillModal(id, form) {
    fetch('user/' + id)
        .then(response => response.json())
        .then(user => {
            form.elements.namedItem("id").value = user.id;
            form.elements.namedItem("username").value = user.username;
            form.elements.namedItem("city").value = user.city;
            form.elements.namedItem("age").value = user.age;
            if (form.elements.namedItem("password") != null) {
                form.elements.namedItem("password").value = "";
            }
        })
        .catch(error => console.error('Ошибка:', error));
}