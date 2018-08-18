function getKey() {
    document.getElementById("key").value = "";
    var exponent = document.getElementById("exponent").value;
    var modulus = document.getElementById("modulus").value;
    var password = document.getElementById("password").value;
// var exponent = 'AQAB';
// var modulus = 'AJGJQvGV5N9Q1nzryOrQAxqu7o/T0dIMOcIHDBZ1FArxKEj3qg1WKhgmdQ4dzem8WJfDA4cOT/H+WmwHGxADXt4aA2W3ZzOdSdEf2dCQDaJrO1baQCGeVi2jd669jHpOm+Gn2QaFzGY/PM19xmVN6gR3+wV0D2otQuFTqVSlT8db';
// var passwd = 'ldxz19980108!@'

    if(exponent != "" && modulus != "" && password != "") {
        var rsaKey = new RSAKey();
        rsaKey.setPublic(b64tohex(modulus), b64tohex(exponent));
        var enPassword = hex2b64(rsaKey.encrypt(password));
        if(enPassword != null){
            document.getElementById("key").value = enPassword;
        }
    }else {
        alert("请将表单填写完整");
    }

}
