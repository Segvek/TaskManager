var listItemPlanToNewGoal = [];
var point071120161153;
var addNewAccount = function (seorcePage) {
    point071120161153 = seorcePage;
    var content = document.getElementById("content");
    var viewNewAccount = new View("ViewNewAccount.html");

    content.innerHTML = viewNewAccount.getHTML();
     
    drawListItemPlan();
}

var addItemPlanToNewGoal = function(){
    var name = document.getElementById("nameitemmPlanToGoal").value;
    var beginDate = document.getElementById("beginDateItemPlan").value;
    var endDate = document.getElementById("endDateItemPlan").value;
    var ellist = document.getElementById("tableItemsPlan"); 
    var acount = 4;
    document.getElementById("nameitemmPlanToGoal").value="";
    document.getElementById("beginDateItemPlan").value="";
    document.getElementById("endDateItemPlan").value="";
    
    var it= {name:name,beginDate:beginDate,endDate:endDate,acount:acount};
    var itemView = document.createElement("tr");
    itemView.innerHTML = "<td>"+listItemPlanToNewGoal.length+"</td><td>"+it.name+"</td><td>"+it.beginDate+"</td><td>"+it.endDate+"</td><td><span class=\"badge bg-red\">acount</span>\n\
</td><td><a onclick=\"deleteItemPlanToNewGoal("+listItemPlanToNewGoal.length+");\" class=\"btn bg-red-gradient\"><i class=\"fa fa-trash-o\"></i></a> </td>";
    ellist.appendChild(itemView);
    
    listItemPlanToNewGoal.push(it);
    
}
var drawListItemPlan = function (){
    var ellist = document.getElementById("tableItemsPlan");
    var ViewHeaderTable=new View("IncludeView/ViewHeaderForTableCreatePlanToNewGoal.html");
    ellist.innerHTML = ViewHeaderTable.getHTML();
     $('#beginDateItemPlan').datepicker({
        autoclose: true
    });
    $('#endDateItemPlan').datepicker({
        autoclose: true
    });   
    for(var i=0; i<listItemPlanToNewGoal.length; i++){
        var it= listItemPlanToNewGoal[i];
        var itemView = document.createElement("tr");
        itemView.innerHTML = "<td>"+i+"</td><td>"+it.name+"</td><td>"+it.beginDate+
                "</td><td>"+it.endDate+"</td><td><span class=\"badge bg-red\">acount\n\
</span></td><td><a onclick=\"deleteItemPlanToNewGoal("+i+");\" class=\"btn bg-red-gradient\"><i class=\"fa fa-trash-o\"></i></a> </td>";
        ellist.appendChild(itemView);
    }
}

var deleteItemPlanToNewGoal = function(numberItem){
    listItemPlanToNewGoal.splice(numberItem,1);
    drawListItemPlan();
}
var createNewGoal = function (){
    var goalName = document.getElementById("nameNewGoal").value;
    var anotation = document.getElementById("shortAnotetionGoal").value;
    var bdate = document.getElementById("beginDatePlan").value;
    var edate = document.getElementById("endDatePlan").value;
    
    var goal = {goalName:goalName,anotation:anotation,bdate:bdate,edate:edate,plan:listItemPlanToNewGoal};
    saveNewGoal(goal);
    point071120161153();
}
var saveNewGoal = function (goal){
    var sessionID = getCookie("sessionID");    
    //генерация запроса
    var request = "<createGoal><sessionId>"+sessionID+"</sessionId><name>"+goal.goalName+"</name><anotation>"+goal.anotation+"</anotation><beginDate>"+goal.bdate+"</beginDate><endDate>"+goal.edate+"</endDate><plan>";
    for(var i=0; i<goal.plan.length; i++){
        var it = goal.plan[i];
        request+="<item><number>"+i+"</number><name>"+it.name+"</name><beginDate>"+it.beginDate+"</beginDate><endDate>"+it.endDate+"</endDate>";
        if(it.acount != undefined)
            request+="<idAcount>"+it.acount+"</idAcount>";
        request+="</item>";
    }      
    request+="</plan></createGoal>";
    console.log(request);
}