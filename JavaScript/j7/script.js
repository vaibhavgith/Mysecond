window.addEventListener('load',calculate)

function calculate(){
    var date=new Date();

   var dayNumber=date.getDay();
   var hour=date.getHours();
   var min=date.getMinutes();
   var ampm=hour>=12 ? 'PM': 'AM';
   var dayNames=["SUN","MON","TUE","THU","FRI","SAT","SUN"];


   hour=hour%12;
   hour=hour ? 12 : '12';
   hour =hour<10 ? '0'+hour:hour;
   min=min<10 ? '0'+min:min;

   document.getElementById("day").innerHTML=dayNames[dayNumber];
   document.getElementById("hour").innerHTML=hour;
   document.getElementById("min").innerHTML=min;
   document.getElementById("ampm").innerHTML=ampm;

   setTimeout(calculate,100);





}

