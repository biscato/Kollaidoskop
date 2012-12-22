var biscatoQuestions = new Array();
var biscatoHeader = "votingHeader";
var biscatoProtocol;
var biscatoHost;
var biscatoPort;
var biscatoQuestionaireSubURL = "/teamhealth/questionaire";
var biscatoAnswerSubURL = "/teamhealth/answers";


/*************************************************************************************
*************** Vote section**********************************************************
*************************************************************************************/
$('#vote').live('pagebeforecreate',function(event, ui){
	
	var biscatoQuestionaireURL = getBiscatoQuestionaireURL();
	
    $.ajax(
        {
            type: "GET",
            url: biscatoQuestionaireURL,
            data: "{}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                biscatoQuestions = data.question;
                displayAllQuestions();
            },
            error: function (msg, url, line) {
                alert('error trapped in error: function(msg, url, line)');
                alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

            }
        });
});

function displayAllQuestions(targetDOMElement){

    var html = "";
    var sliderMinValue = 0;
    var sliderMaxValue = 10;
    var sliderStartValue = 5;
    var questionsCounter = 0;

    for(var i=0; i < biscatoQuestions.length; i++){
        questionsCounter++;
        html += "<div>Question # "+questionsCounter+ ": </div>"; //TODO: localize text
        html += "<div><label>" + biscatoQuestions[i].description + "</label></div>"; //TODO: localize text
        html += "<div data-role='fieldcontain'>";
        html += "<input type='range' name='slider-" + i + "' id='slider-" + i + "' value='" + sliderStartValue + "' min='" + sliderMinValue + "' max='" + sliderMaxValue + "' />";
        html += "<label for='slider-" + i + "'></label>"; //TODO: localize text
        html += "</div>";
        html += "<br>";
    }
    $("#voting").append(html).trigger('create');
    //TODO: check this some time: http://www.kelvinluck.com/assets/jquery/ui-slider/slider_test.html
}

function saveVote(){
	
	var biscatoAnswerURL = getBiscatoAnswerURL();
	var votes = getVotesFromUser();
	
	$.ajax(
            {
                type: "POST",
                url: biscatoAnswerURL,
                data: votes,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    answersCreatedSuccess(data.question);
                },
                error: function (msg, url, line) {
                    alert('error trapped in error: function(msg, url, line)');
                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

                }
            });
}

function getVotesFromUser(){
    var questionsCounter = 0;
	var answers = new Array();
	
    for(var i=0; i < biscatoQuestions.length; i++){
        
        var sliderString = "slider-"+i;
        answers[i] = new Array();
        answers[i]["id"] = biscatoQuestions[i].id;
        answers[i]["questionText"] = biscatoQuestions[i].description;
        answers[i]["questionCategory"] = biscatoQuestions[i].category;
        answers[i]["user"] = "janruessel@gmail.com";
        answers[i]["rating"] = document.getElementById(sliderString).value;

    }

	return convertVoteToJSONFormat(answers);
}

function convertVoteToJSONFormat(answers){
	var votes = {
		    answer: []
		};
	
    for(var i in answers){
    	var answer = answers[i];
    	votes.answer.push({
    		"id" : answers[i].id,
    		"questionText" : answers[i].questionText,
    		"questionCategory" : answers[i].questionCategory,
    		"user" : answers[i].user,
    		"rating" : answers[i].rating
    	});
    }
    var myString = JSON.stringify(votes);
    return myString;
}

function answersCreatedSuccess(responseData){
	alert("Answers successfully created");
}
/*************************************************************************************
*************** my past Votes section*************************************************
*************************************************************************************/
$('#myVotes').live('pageshow',function(event, ui){

    var dummyData = [['4',5],['5', 4],['6', 5],['7',7],['8',7],['9',8]];

    $.jqplot('myVotesChart', [dummyData],
        {
//            axesDefaults: {ticks: [0,2,4,6,8,10]},
//            axesDefaults: {ticks: [[2, 0],[4, 2],[6, 4],[5, 6],[8, 8]]},
            axes:{
                xaxis: {
//                    borderColor: "#222",
                    renderer: $.jqplot.DateAxisRenderer,
                    numberTicks:6,
                    tickOptions:{formatString:'%b'},
                    rendererOptions:{tickRenderer: $.jqplot.CanvasAxisTickRenderer}
                },
                yaxis:{min:0, max:10}},
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

function getBaseURL(){
	var baseURL;
	if(biscatoHost == null || biscatoHost == undefined){
		biscatoProtocol = window.location.protocol;
		biscatoHost = window.location.hostname;
		biscatoPort = window.location.port;
	}
	baseURL = biscatoProtocol + "//" + biscatoHost + ":" + biscatoPort;
	return baseURL;
}

function getBiscatoQuestionaireURL(){
	var url;
	url = getBaseURL();
	url += biscatoQuestionaireSubURL;
	return url;
}

function getBiscatoAnswerURL(){
	var url;
	url = getBaseURL();
	url += biscatoAnswerSubURL;
	return url;
}

/*************************************************************************************
*************** Test Stuff ***********************************************************
*************************************************************************************/

/******* Creation of Questions ******************************/
function createAllQuestions(){
    
	var biscatoQuestionaireURL = getBiscatoQuestionaireURL();
	var questionsInJSONFormat = getTestQuestionsInJSONFormat();
	$.ajax(
            {
                type: "POST",
                url: biscatoQuestionaireURL,
                data: questionsInJSONFormat,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    questionsCreatedSuccess(data.question);
                },
                error: function (msg, url, line) {
                    alert('error trapped in error: function(msg, url, line)');
                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

                }
            });
	
	
	alert("Create Questions Clicked");
}

function getTestQuestionsInJSONFormat(){

	var jsonFormattedQuestions = {
		  'question': [
			    {
			    	'active': 'true',
			    	'category': 'Test',
			    	'description': 'Dies ist eine Testfrage mit einem †mlaut.',
			    	'Language': 'de'
			    },
			    {
			    	'active': 'true',
			    	'category': 'Test',
			    	'description': 'Eine weitere Testfrage.',
			    	'language': 'de'
			    }
		  ]
	};
	var myString = JSON.stringify(jsonFormattedQuestions);
	return myString;
}

function questionsCreatedSuccess(questions){
	alert("Questions successfully created");
}

/******* Deletion of Questions ******************************/
function deleteAllQuestions(){
	alert("Delete All Questions clicked");
	
}


/******* Creation of Test Answers ******************************/
function createTestAnswers(){
	alert("Create Test Answers Clicked");
	
}

/******* Deletion of All Answers ******************************/
function deleteAllAnswers(){
	var biscatoAnswerURL = getBiscatoAnswerURL();
	$.ajax(
            {
                type: "DELETE",
                url: biscatoAnswerURL,
                data: "{}",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    answersDeletedSuccess(data);
                },
                error: function (msg, url, line) {
                    alert('error trapped in error: function(msg, url, line)');
                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

                }
            });
}
function answersDeletedSuccess(data){
	alert("All votes have been deleted successfully");
}





