var biscatoQuestions = new Array();
var biscatoHeader = "votingHeader";

$('#vote').live('pagebeforecreate',function(event, ui){
    $.ajax(
        {
            type: "GET",
            url:  'http://192.168.0.114:8888/teamhealth/questionaire',
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
    var html = "Question 1 of 15";    //TODO: localize text
    $(html).appendTo($("#votingHeader"));
}

function displayAllQuestions(targetDOMElement){

    var html = "";
    var sliderMinValue = 0;
    var sliderMaxValue = 10;
    var sliderStartValue = 5;
    var questionsCounter = 0;

    $('.ui-slider-handle').height(100);

    for(var i=0; i < biscatoQuestions.length; i++){
        questionsCounter++;
        html += "<div>Question # "+questionsCounter+ ": </div>"; //TODO: localize text
        html += "<div><label>" + biscatoQuestions[i].description + "</label></div>"; //TODO: localize text
        html += "<div data-role='fieldcontain'>";
        //html += "<input class='biscatoQuestionSlider' type='range' name='slider-" + i + "' id='slider-" + i + "' value='" + sliderStartValue + "' min='" + sliderMinValue + "' max='" + sliderMaxValue + "' />";
        html += "<input type='range' name='slider-" + i + "' id='slider-" + i + "' value='" + sliderStartValue + "' min='" + sliderMinValue + "' max='" + sliderMaxValue + "' />";
        html += "<label for='slider-" + i + "'></label>"; //TODO: localize text
        html += "</div>";
        html += "<br>";
    }
    //$(html).appendTo($("#voting"));
    $("#voting").append(html).trigger('create');
}

function getQuestions(){
    return questions;
}

$('#myVotes').live('pageshow',function(event, ui){

    $.jqplot('myVotesChart',  [[[7,5],[8, 4],[9, 5],[10,7],[11,7],[12,8]]],
        { title:'My Votes',
            axes:{yaxis:{min:0, max:10}},
            series:[{color:'#5FAB78'}]
        });
});

$('#teamResults').live('pageshow',function(event, ui){

    $.jqplot('teamResultsChart',  [[[7,5],[8, 4],[9, 5],[10,7],[11,7],[12,8]]],
        { title:'Team Votes',
            axes:{yaxis:{min:0, max:10}},
            series:[{color:'#5FAB78'}]
        });
});