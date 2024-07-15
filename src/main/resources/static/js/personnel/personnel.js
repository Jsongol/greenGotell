document.addEventListener('DOMContentLoaded', function () {
    const cancelbtn = document.querySelector('.cancelbtn');
    const createEmployeeDiv = document.querySelector('#create-employee');
    const createbtn = document.querySelector('.createbtn');
    const employeeForm = createEmployeeDiv.querySelector('form');
    
    /*직원추가 버튼 이벤트*/
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
    arguments
    
    /*신규직원추가 유효성검사*/
    
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
    
    
    
    /*유효성검사 함수*/
    
    /*이름 검사*/
    function nameVerification(value) {
        return value.length >= 2 && /^[가-힣a-zA-Z]+$/.test(value);
    }
    
     /*이메일 검사*/
    function emailVerification(value) {
        return /^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(value);
    }
    
     /*비밀번호 검사*/
    function passVerification(value) {
        return value.length >= 6 && /[a-zA-Z\d!@$%*]/.test(value);
    }
    
     /*제출시 모든 유효성 검사처리*/
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
    
    /*실시간 피드백 함수*/
    
    /*이름*/
    name.onkeyup = function() {
        if (name.value.length === 0 || nameVerification(name.value)) {
            nameFailureMessage.classList.add('hide');
        } else {
            nameFailureMessage.classList.remove('hide');
        }
    };
    
    /*이메일*/
    email.onkeyup = function() {
        if (email.value.length === 0 || emailVerification(email.value)) {
            emailFailureMessage.classList.add('hide');
        } else {
            emailFailureMessage.classList.remove('hide');
        }
    };
    
    /*비밀번호*/
    pass.onkeyup = function() {
        if (pass.value.length === 0 || passVerification(pass.value)) {
            passFailureMessage.classList.add('hide');
        } else {
            passFailureMessage.classList.remove('hide');
        }
    };
    
    // 제출 이벤트
    employeeForm.onsubmit = function(event) {
        if (!isFormValid()) {
            event.preventDefault();
            alert('모든 입력란을 올바르게 작성해주세요.');
        }
    };
});
