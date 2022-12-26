function checklogin(){
    var Username = document.getElementById("Username").value;//获取用户名
    var Password = document.getElementById("Password").value;//获取密码

    if(isEmpty(Username) || isEmpty(Password)){
        document.getElementById("msg").innerHTML = "输入不合法";
        return;
    }
    document.getElementById("LoginForm").submit();
    return;
}
