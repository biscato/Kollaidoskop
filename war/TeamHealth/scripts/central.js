var biscatoQuestions = new Array();
var biscatoHeader = "votingHeader";

$('#questions').live('pagebeforecreate',function(event, ui){
    $.ajax(
        {
            type: "GET",
            url:  'http://192.168.0.100:8888/questionaire',
            //url:  'http://localhost:8888/questionaire',
            data: "{}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                biscatoQuestions = data.questionaire;
                initDataForPage();
            },
            error: function (msg, url, line) {
                alert('error trapped in error: function(msg, url, line)');
                alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

            }
        });
});

function initDataForPage(){
    setHeader(biscatoHeader);
    displayAllQuestions();
}

function setHeader(headerDOMElement){
    var html = "Question 1 of 15";
    $(html).appendTo($("#votingHeader"));
}

function displayAllQuestions(targetDOMElement){

    var html = "";
    for(var i=0; i < biscatoQuestions.length; i++){
        html += "<div>Question#: "+i+"</div>";
        html += "<div>Question: " + biscatoQuestions[i].description + "</div>";
        html += "<div>Category: " + biscatoQuestions[i].category + "</div>";
        html += "<div>------------------</div>";
        $(html).appendTo($("#JSON"));
    }

}

function getQuestions(){
    return questions;
}
