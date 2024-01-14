function DateGenerator(){
    const month = ["01","02","03","04","05","06","07","08","09","10","11","12"];

    for(var i=0;i<=12;i++){
        var x = document.getElementById("MeseS"); /*alterazione del dom */
        var option = document.createElement("option");
        option.text = month[i];
        x.add(option);
    }
    const d = new Date();
    let year = d.getFullYear()+1; /* anno corrente +1 alterazione del dom */

    for(var i=year;i<=(year+11);i++){
        var x = document.getElementById("AnnoS");
        var option = document.createElement("option");
        option.text = String(i);
        x.add(option);
    }

}
