document.addEventListener('DOMContentLoaded', function () {
    const cancelbtn = document.querySelector('.cancelbtn');
    const createEmployeeDiv = document.querySelector('#create-employee');
    const createbtn = document.querySelector('.createbtn');
    const employeeForm = createEmployeeDiv.querySelector('form');

    /* 직원 추가 버튼 이벤트 */
    cancelbtn.addEventListener('click', function () {
        createEmployeeDiv.classList.remove('create');
        createEmployeeDiv.classList.add('cancel');
        employeeForm.reset();
        document.querySelectorAll('.error').forEach(function(message) {
            message.classList.add('hide');
        });
    });

    createbtn.addEventListener('click', function () {
        createEmployeeDiv.classList.add('create');
    });

    /* 신규 직원 추가 유효성 검사 */
    let name = document.querySelector('#name');
    let nameFailureMessage = document.querySelector('.name-failure');

    let email = document.querySelector('#email');
    let emailFailureMessage = document.querySelector('.email-failure');

    let pass = document.querySelector('#pass');
    let passFailureMessage = document.querySelector('.pass-failure');

    let department = document.querySelector('#department');
    let position = document.querySelector('#position');
    let hireDate = document.querySelector('#hireDate');
    let status = document.querySelector('#status');

    /* 유효성 검사 함수 */
    function nameVerification(value) {
        return value.length >= 2 && /^[가-힣a-zA-Z]+$/.test(value);
    }

    function emailVerification(value) {
        return /^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(value);
    }

    function passVerification(value) {
        return value.length >= 6 && /[a-zA-Z\d!@$%*]/.test(value);
    }

    function isFormValid() {
        return (
            nameVerification(name.value) &&
            emailVerification(email.value) &&
            passVerification(pass.value) &&
            department.value &&
            position.value &&
            hireDate.value &&
            status.value
        );
    }

    /* 실시간 피드백 함수 */
    name.onkeyup = function() {
        if (name.value.length === 0 || nameVerification(name.value)) {
            nameFailureMessage.classList.add('hide');
        } else {
            nameFailureMessage.classList.remove('hide');
        }
    };

    email.onkeyup = function() {
        if (email.value.length === 0 || emailVerification(email.value)) {
            emailFailureMessage.classList.add('hide');
        } else {
            emailFailureMessage.classList.remove('hide');
        }
    };

    pass.onkeyup = function() {
        if (pass.value.length === 0 || passVerification(pass.value)) {
            passFailureMessage.classList.add('hide');
        } else {
            passFailureMessage.classList.remove('hide');
        }
    };

    /* 직원 목록을 로드하는 함수 */
    function loadEmployeeList() {
        $.ajax({
            url: '/api/employees',
            method: 'GET',
            success: function(response) {
                var employeeList = $('#cmposting-format ul');
                employeeList.find('li:gt(0)').remove();
                response.forEach(function(employee) {
                    employeeList.append(
                        '<li>' +
                        '<span>' + employee.id + '</span>' +
                        '<span>' + employee.department + '</span>' +
                        '<span>' + employee.position + '</span>' +
                        '<span>' + employee.name + '</span>' +
                        '<span>' + employee.contact + '</span>' +
                        '<span>' + employee.address + '</span>' +
                        '<span>' + employee.email + '</span>' +
                        '<span>' + employee.hireDate + '</span>' +
                        '<span><button class="cmbutton2">수정</button></span>' +
                        '</li>'
                    );
                });
            }
        });
    }

    /* 신규 직원 추가 함수 */
    function addEmployee() {
        var newEmployee = {
            name: name.value,
            email: email.value,
            password: pass.value,
            department: department.value,
            position: position.value,
            hireDate: hireDate.value,
            employeeStatus: status.value
        };

        $.ajax({
            url: '/api/employees',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(newEmployee),
            success: function(response) {
                loadEmployeeList();
                createEmployeeDiv.classList.remove('create');
                employeeForm.reset();
                document.querySelectorAll('.error').forEach(function(message) {
                    message.classList.add('hide');
                });
            }
        });
    }

    // 페이지 로드 시 직원 목록 로드
    loadEmployeeList();

    // 제출 이벤트
    employeeForm.onsubmit = function(event) {
        event.preventDefault();
        if (isFormValid()) {
            addEmployee();
        } else {
            alert('모든 입력란을 올바르게 작성해주세요.');
        }
    };
});
