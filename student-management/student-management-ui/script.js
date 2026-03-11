const API = "http://localhost:8080/students";

let editId = null;

async function loadStudents(){

const response = await fetch(API);
const students = await response.json();

let rows="";

students.forEach(s=>{

rows += `
<tr>
<td>${s.id}</td>
<td>${s.name}</td>
<td>${s.email}</td>
<td>${s.course}</td>

<td>
<button class="edit-btn" onclick="editStudent(${s.id},'${s.name}','${s.email}','${s.course}')">Edit</button>

<button class="delete-btn" onclick="deleteStudent(${s.id})">Delete</button>
</td>

</tr>
`;

});

document.getElementById("studentTable").innerHTML = rows;

}

async function saveStudent(){

const name=document.getElementById("name").value;
const email=document.getElementById("email").value;
const course=document.getElementById("course").value;

if(editId==null){

await fetch(API,{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({name,email,course})
});

}
else{

await fetch(API+"/"+editId,{
method:"PUT",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({name,email,course})
});

editId=null;
document.getElementById("addBtn").innerText="Add Student";

}

clearForm();
loadStudents();

}
function searchStudents(){

const input = document.getElementById("searchInput").value.toLowerCase();
const rows = document.querySelectorAll("#studentTable tr");

rows.forEach(row => {

const text = row.innerText.toLowerCase();

if(text.includes(input)){
row.style.display="";
}
else{
row.style.display="none";
}

});

}

function sortTable(column){

const table = document.getElementById("studentTable");
const rows = Array.from(table.rows);

rows.sort((a,b)=>{
return a.cells[column].innerText.localeCompare(
b.cells[column].innerText
);
});

table.innerHTML="";

rows.forEach(r=>{
table.appendChild(r);
});

}

function editStudent(id,name,email,course){

editId=id;

document.getElementById("name").value=name;
document.getElementById("email").value=email;
document.getElementById("course").value=course;

document.getElementById("addBtn").innerText="Update Student";

}

async function deleteStudent(id){

await fetch(API+"/"+id,{
method:"DELETE"
});

loadStudents();

}

function clearForm(){

document.getElementById("name").value="";
document.getElementById("email").value="";
document.getElementById("course").value="";

editId=null;
document.getElementById("addBtn").innerText="Add Student";

}

loadStudents();

let currentPage = 1;
const rowsPerPage = 5;

function showPage(){

const rows = document.querySelectorAll("#studentTable tr");

rows.forEach((row,index)=>{
if(index >= (currentPage-1)*rowsPerPage && index < currentPage*rowsPerPage){
row.style.display="";
}else{
row.style.display="none";
}
});

}

function nextPage(){
currentPage++;
showPage();
}

function prevPage(){
if(currentPage>1){
currentPage--;
showPage();
}
}