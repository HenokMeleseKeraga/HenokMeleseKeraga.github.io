var accountlist = [];
var index = 0;
var account = function () {
    var accountname;
    var deposite;
    function create(accname, dept) {
        accountname = accname;
        deposite = dept;
    };

    return {
        set: function (name, dept) {
            create(name, dept);
        },

        get: function () {
            return {
                info: function () {
                    return `Account name : ${accountname}   Balance : ${deposite} `;
                }
            };
        }
    };

}


function createaccount() {

    var accname = document.getElementById("accname").value;
    var dept = document.getElementById("deposit").value;

    var newaccount = account();
    newaccount.set(accname, dept);
    var temp = newaccount.get();
    accountlist[index] = temp;
    index = index + 1;
    document.getElementById("txt").value = temp.info();
   
    
}
window.onload = function () {
    document.getElementById('btn').onclick = createaccount;
}
