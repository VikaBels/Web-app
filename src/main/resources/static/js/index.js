function data(){
    today = new Date();
    
    //month
    var dates = document.getElementsByClassName("calendar__header"),
    lastDate = dates[dates.length-1],
    months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    lastDate.innerText = months[today.getMonth()];

    //day
    var dates = document.getElementsByClassName("calendar__body");
    lastDate = dates[dates.length-1];
    lastDate.innerText = today.getDate();
}
data();

