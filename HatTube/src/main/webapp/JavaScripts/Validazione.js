function validazioneFormRegistrazione() {
    return validaName(),validaSnome(),validaVia(),validaCitta(),validaCap(),validaEmail(),validaPassword(),
        validaNomeProprietario(),validaCVV(),validaNumeroCarta() , validaUsername()
};


function validaName() {
    var name = document.getElementById("name").value;
    var regName =  /^[a-zA-Zòàèùì ]*$/;

    if (!regName.test(name)||name.length===0) {
        document.getElementById("name").value = "NOME NON VALIDO";
        return false;
    }
}


function validaSnome() {
    var sname = document.getElementById("sname").value;
    var regName = /^[a-zA-Zòàèùì ]*$/;

    if (!regName.test(sname)||sname.length===0) {
        document.getElementById("sname").value = "COGNOME NON VALIDO";
        return false;
    }
}

function validaCitta() {
    var city = document.getElementById("city").value;
    var regName = /^[a-zA-Zòàèùì ]*$/;

    if (!regName.test(city)||city.length===0) {
        document.getElementById("city").value = "CITTA' NON VALIDA";
        return false;
    }
}

function validaVia() {
    var via = document.getElementById("via").value;
    var regName = /^[a-zA-Z]*$/;

    if (!regName.test(via)||via.length===0) {
        document.getElementById("via").value = "VIA NON VALIDA";
        return false;
    }
}

function validaCap() {
    var cap = document.getElementById("cap").value;
    var regName = /[0-9]*$/;

    if (!regName.test(cap)) {
        document.getElementById("cap").value = "CAP NON VALIDO (5 NUMERI)";
        return false;
    }
}


function validaEmail() {
    var email = document.getElementById("email").value;
    var regName = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (!regName.test(email)) {
        document.getElementById("email").value = "EMAIL NON VALIDA";
        return false;
    }
}


function validaPassword() {
    var password = document.getElementById("password").value;
    var regName = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[?!@#$%^&+=.,])(?=\S+$).{8,}/;

    if (!regName.test(password)||password.length<8) {
        document.getElementById("password").value = "PASSWORD NON VALIDA";
        return false;
    }
}


function validaNumeroCarta() {
    var carta = document.getElementById("numcarta").value;
    var regName = /^[0-9]*$/;

    if (!regName.test(carta)||carta.length!==16) {
        document.getElementById("numcarta").value = "NUMERO CARTA NON VALID0 (16 CIFRE)";
        return false;
    }
}

function validaCVV() {
    var cvv= document.getElementById("cvv").value;
    var regName = /^[0-9]*$/;

    if (!regName.test(codice)||codice.length!==3) {
        document.getElementById("cvv").value = "CODICE NON VALIDO";
        return false;
    }
}

function validaNomeProprietario() {
    var nomeI = document.getElementById("nomei").value;
    var regName = /^[a-zA-Zòàèùì ]*$/;

    if (!regName.test(nomeI)||nomeI.length===0) {
        document.getElementById("nomei").value = "INTESTATARIO NON VALIDO";
        return false;
    }
}
function validaUsername() {
    var username = document.getElementById("username").value;
    var regName = /^[a-zA-Zòàèùì ]*$/;

    if (!regName.test(username)||username.length===0) {
        document.getElementById("username").value = "USERNAME NON VALIDO";
        return false;
    }
}



