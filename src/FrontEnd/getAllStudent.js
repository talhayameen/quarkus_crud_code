
function getAllStudents() {

    fetch('http://0.0.0.0:8080/danish/studentDetails')
    .then(response => response.text())
    .then(data =>{

        console.log(data)
        document.getElementById('studentDetail').innerHTML=data;
    } 
    );
        


}




function studentRegistration(){

    

    document.getElementById("registration").hidden=false
    console.log("This is working..")
    


}

function studentRegistrationScene(){


    // 0.0.0.0:8080/danish/addStudent?id=11225&name=RAHUL KUMAR&sclass=FIRST YEAR


    fetch('http://0.0.0.0:8080/danish/addStudent?id='+document.getElementById('sid')+'&name="'+document.getElementById('sname')+'"&sclass='"FIRST YEAR"'',{
        method:"POST"
    })
    .then(response => response.text())
    .then(data =>{

        console.log(data)
        document.getElementById('studentDetail').innerHTML=data;
    } 
    );
}
