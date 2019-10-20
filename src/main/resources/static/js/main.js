$.fn.serializeObject = function() {
    var o = {"unique_id":new Date().getTime(),"state":false};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
var nav = {
    login: function () {
        $.ajax({
            url: "/user/api/login",
            type: "post",
            dataType: "json",
            data: $("#login-form").serialize(),
            success: function (res) {
                if (res.code == 1)
                    window.location.reload(true);
                new $.zui.Messager(res.message, {
                    icon: 'bell',
                    type: res.code == 1 ? 'success' : 'danger'
                }).show();
            }
        });
    },
    register: function () {
        if ($("#register-password").val() != $("#register-repassword").val()) {
            new $.zui.Messager("两次输入的密码不同, 请重新输入", {
                icon: 'bell',
                type: 'danger'
            }).show();

            return false;
        }
        $.ajax({
            url: "/user/api/register",
            type: "post",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify($("#register-form").serializeObject()),
            success: function (res) {
                if (res.code == 1)
                    window.location.reload(true);
                new $.zui.Messager(res.message, {
                    icon: 'bell',
                    type: res.code == 1 ? 'success' : 'danger'
                }).show();
            }
        });



    }

};
var script = {
    post: function () {
        alert("暂时没加用户个人发布脚本");

    }

};