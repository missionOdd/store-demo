$(function() {
    info();
});
function info() {
    $.ajax({
        "url":"/users/info",
        "type":"GET",
        "dataType":"json",
        "success":function(json) {
            if (json.state == 200) {
               $('a[href|="login.html"]').html("<span class=\"fa fa-user\"></span>"+json.data.username+"<img style='width: 30px' src='"+json.data.avatar+"'>");
            }
        },
        "error":function() {
            alert("您还没有登录，或登录信息已经过期，请重新登录！");
            location.href = "login.html";
        }
    });
}