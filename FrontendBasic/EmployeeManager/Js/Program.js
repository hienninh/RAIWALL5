
$(function () {
  $(".header").load("header.html");
  $(".main").load("home.html");
  $(".footer").load("footer.html");
});

function ClickNavHome() {
  $(".main").load("home.html");
}
function ClickNavViewList() {
  $(".main").load("viewListEmployee.html");
  buildTable();
}
var employees = [];
var counter = 0;
function Employee(name, department, phone) {
  this.id = counter++;
  this.name = name;
  this.department = department;
  this.phone = phone;
}
// Input data
function inputEmployee() {
  if (employees == null || employees.length == 0 || employees == undefined) {
    employees.push(new Employee("John Doe", "Administration", "(171) 555-2222"));
    employees.push(new Employee("Peter Parker", "Customer Service", "(313) 555-5735"));
    employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
  }
}
// Khởi tạo table
function buildTable() {

  setTimeout(function name(params) {
    // todo empty data befor insert new employee  
    $('tbody').empty();
    // sau 1s sẽ đổ dữ liệu từ server về
    inputEmployee();
    // Chạy vòng for để add từng employee vào
    employees.forEach(function (item) {

      $('tbody').append(
        '<tr> ' +
        '<td>' + item.name + '</td>' +
        '<td>' + item.department + '</td>' +
        '<td>' + item.phone + '</td>' +
        '<td>' +
        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateEmployee(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
        '<a class="delete" title="Delete" data-toggle="tooltip" onclick="ConfirmDeleteEmployee(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
        '</td>' +
        '</tr>')

    });

  }, 1000);

}
// Tạo 1 refresh cho cửa số để add thêm employee
function refresh() {
  document.getElementById("id").value = "";
  document.getElementById("Name").value = "";
  document.getElementById("Department").value = "";
  document.getElementById("Phone").value = "";
}
// Khởi tạo hàm open add new employee
function openAddEmployee() {
  refresh();
  showModel();
}

function showModel() {
  $('#myModal').modal('show');
}
function hideModer() {
  $('#myModal').modal('hide');
}
// Khởi tạo add employee sau khi đã nhập thông tin
function addEmployee() {

  //  lấy thông tin vửa nhập vào và có biến tương ứng để hứng
  var Name = document.getElementById("Name").value;
  var Department = document.getElementById("Department").value;
  var Phone = document.getElementById("Phone").value;
  // Todo Validate: java advanced sẽ hướng dẫn
  // Insert kết quả

  employees.push(new Employee(Name, Department, Phone));
  hideModer();
  buildTable();
}
// Chức năng update employee theo ID_employee
function openUpdateEmployee(id) {

  // get index (thông tin Employee )theo ID_Employee tuong duong la chay for
  var index = employees.findIndex(x => x.id == id);
  // fill data
  document.getElementById("id").value = employees[index].id;
  document.getElementById("Name").value = employees[index].name;
  document.getElementById("Department").value = employees[index].department;
  document.getElementById("Phone").value = employees[index].phone;
  showModel();
  // Điền thông tin cần update
}
// Update thong tin

function save() {
  var id = document.getElementById("id").value
  if (id == null || id == "") {
    addEmployee();
  }
  else {
    UpdateEmployee();
  }
}
function UpdateEmployee() {
  var id = document.getElementById("id").value;
  var Name = document.getElementById("Name").value;
  var Department = document.getElementById("Department").value;
  var Phone = document.getElementById("Phone").value;
  // get index (thông tin Employee )theo ID_Employee tuong duong la chay for
  var index = employees.findIndex(x => x.id == id);
  // fill data
  employees[index].name = Name;
  employees[index].department = Department;
  employees[index].phone = Phone;

  // Edit kết quả
  hideModer();
  showSuccessAlert();
  buildTable();
}
// Delete Employee
function ConfirmDeleteEmployee(id) {
  // get index (thông tin Employee )theo ID_Employee tuong duong la chay for
  var index = employees.findIndex(x => x.id == id);
  // fill data
  var name = employees[index].name;

  var result = confirm("Want to delete " + name + "?");
  if (result) {
    deleteEmployee(id);
  }
}
//  logic Delete
function deleteEmployee(id) {
  // get index (thông tin Employee )theo ID_Employee tuong duong la chay for
  var index = employees.findIndex(x => x.id === id);
  employees.splice(index, 1);

  showSuccessAlert();
  buildTable();
  //Todo Validate
}
// Alert success bootrab
function showSuccessAlert() {
  $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
    $("#success-alert").slideUp(500);
  });
}

