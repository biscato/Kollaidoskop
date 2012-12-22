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

	var answers = new Array();
	
    for(var i=0; i < biscatoQuestions.length; i++){
        
        var sliderString = "slider-"+i;
        answers[i] = new Array();
        answers[i]["questionId"] = biscatoQuestions[i].id;
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
    		"questionId" : answers[i].questionId,
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
}

function getTestQuestionsInJSONFormat(){
	
	var questionCatalogue = createQuestions();
	
	var jsonQuestions = {
		    question: []
		};
	
    for(var i in questionCatalogue){
    	var question = questionCatalogue[i];
    	jsonQuestions.question.push({
    		"language" : questionCatalogue[i].language,
    		"description" : questionCatalogue[i].description,
    		"category" : questionCatalogue[i].category,
    	});
    }

    var myString = JSON.stringify(jsonQuestions);
    return myString;

}

function createQuestions(){
	
	var langDe = "de";
	var langEn = "en";
	var categoryVisionDe = "Vision";
	var categoryInnovationDe = "UnterstŸtzung von Innvovation";
	var categoryTaskorientationDe = "Aufgabenorientierung";
	var categorySecurityDe = "Partizipative Sicherheit";
	var categoryStructureDe = "Struktur";
	var categoryVirtualCompetenceDe = "Virtuelle Kompetenz";
	
	var questions = new Array();
	
	questions[0] = new Array();
	questions[0]["language"] = langDe;
	questions[0]["description"] = "In diesem Team ist allen klar, was wir erreichen wollen.";
	questions[0]["category"] = categoryVisionDe;

	questions[1] = new Array();
	questions[1]["language"] = langDe;
	questions[1]["description"] = "Wir wissen, dass wir uns aufeinander verlassen kšnnen.";
	questions[1]["category"] = categoryInnovationDe;

	questions[2] = new Array();
	questions[2]["language"] = langDe;
	questions[2]["description"] = "Wir haben anregende Diskussionen darŸber, wie wir am besten arbeiten.";
	questions[2]["category"] = categoryTaskorientationDe;

	questions[3] = new Array();
	questions[3]["language"] = langDe;
	questions[3]["description"] = "Wir treffen uns ausreichend hŠufig, um effektiv zu kommunizieren und zu koordinieren.";
	questions[3]["category"] = categorySecurityDe;

	questions[4] = new Array();
	questions[4]["language"] = langDe;
	questions[4]["description"] = "Die Teammitglieder bieten einander immer schnell Hilfe an, um etwas Neues auszuprobieren.";
	questions[4]["category"] = categoryInnovationDe;

	questions[5] = new Array();
	questions[5]["language"] = langDe;
	questions[5]["description"] = "Wir haben alle Einfluss auf endgŸltige Entscheidungen im Team.";
	questions[5]["category"] = categorySecurityDe;

	questions[6] = new Array();
	questions[6]["language"] = langDe;
	questions[6]["description"] = "Wir halten uns Ÿber arbeitsrelevante Dinge gegenseitig auf dem Laufenden.";
	questions[6]["category"] = categorySecurityDe;

	questions[7] = new Array();
	questions[7]["language"] = langDe;
	questions[7]["description"] = "In unserem Team herrscht ein GefŸhl von Sicherheit und Vertrauen.";
	questions[7]["category"] = categorySecurityDe;

	questions[8] = new Array();
	questions[8]["language"] = langDe;
	questions[8]["description"] = "Wir sind jederzeit aufgeschlossen gegenŸber neuen Ideen.";
	questions[8]["category"] = categoryInnovationDe;

	questions[9] = new Array();
	questions[9]["language"] = langDe;
	questions[9]["description"] = "Alle Teammitglieder fŸhlen sich den Zielen des Teams verpflichtet.";
	questions[9]["category"] = categoryVisionDe;

	questions[10] = new Array();
	questions[10]["language"] = langDe;
	questions[10]["description"] = "Wir kšnnen offen Ÿber Fehler sprechen.";
	questions[10]["category"] = categoryTaskorientationDe;

	questions[11] = new Array();
	questions[11]["language"] = langDe;
	questions[11]["description"] = "Wir stimmen mit unsere Ziele Ÿberein.";
	questions[11]["category"] = categoryVisionDe;

	questions[12] = new Array();
	questions[12]["language"] = langDe;
	questions[12]["description"] = "Es herrscht bei uns eine AtmosphŠre, in der konstruktive Kritik geŸbt wird.";
	questions[12]["category"] = categoryTaskorientationDe;

	questions[13] = new Array();
	questions[13]["language"] = langDe;
	questions[13]["description"] = "Wir unterstŸtzen einander in Ideen über neue und verbesserte Arbeitsprozesse.";
	questions[13]["category"] = categoryInnovationDe;

	questions[14] = new Array();
	questions[14]["language"] = langDe;
	questions[14]["description"] = "Wir unterstŸtzen uns gegenseitig bei der Erledigung unserer Aufgabe.";
	questions[14]["category"] = categoryTaskorientationDe;

	questions[15] = new Array();
	questions[15]["language"] = langDe;
	questions[15]["description"] = "Jeder im Team trŠgt zur Entscheidungsfindung bei.";
	questions[15]["category"] = categorySecurityDe;

	questions[16] = new Array();
	questions[16]["language"] = langDe;
	questions[16]["description"] = "Unsere Teamregeln beinhalten auch Erwartungen zum Kommunikations- und RŸckmeldeverhalten. (Vereinbarungen)";
	questions[16]["category"] = categoryStructureDe;

	questions[17] = new Array();
	questions[17]["language"] = langDe;
	questions[17]["description"] = "Wir haben durchgŠngig die richtigen Werkzeuge fŸr effektive Zusammenarbeit verfŸgbar. (Infrastruktur)";
	questions[17]["category"] = categoryStructureDe;

	questions[18] = new Array();
	questions[18]["language"] = langDe;
	questions[18]["description"] = "Alle im Team haben ausreichende Kenntnisse fŸr die situativ angemessene Anwendung der bereitgestellten Kooperationswerkzeuge. (Medienkompetenz)";
	questions[18]["category"] = categoryVirtualCompetenceDe;

	questions[19] = new Array();
	questions[19]["language"] = langDe;
	questions[19]["description"] = "Unsere Teambesprechungen finden regelmŠ§ig statt und werden sorgfŠltig vorbereitet. Inhalte, Ziele und Ablauf sind klar.  (Regeln)";
	questions[19]["category"] = categoryStructureDe;

	questions[20] = new Array();
	questions[20]["language"] = langDe;
	questions[20]["description"] = "Im Team werden die vorhandenen KommunikationskanŠle gemŠ§ der getroffenen Absprachen  effizient eingesetzt.  (Kommunikation)";
	questions[20]["category"] = categoryVirtualCompetenceDe;

	questions[21] = new Array();
	questions[21]["language"] = langDe;
	questions[21]["description"] = "In unserem Team besteht eine angemessene Balance zwischen Autonomie / FlexibilitŠt und Zusammenhalt. (Selbstorganisation)";
	questions[21]["category"] = categoryVirtualCompetenceDe;

	questions[22] = new Array();
	questions[22]["language"] = langDe;
	questions[22]["description"] = "Wir haben eine klare Verteilung von Rollen, Aufgaben und Verantwortlichkeiten im Team. (Klarheit)";
	questions[22]["category"] = categoryStructureDe;

	questions[23] = new Array();
	questions[23]["language"] = langDe;
	questions[23]["description"] = "Es gibt auch regelmŠ§ig informelle Kontakte zwischen allen Teammitgliedern. (Vertrauen)";
	questions[23]["category"] = categoryVirtualCompetenceDe;

	return questions;
}

function questionsCreatedSuccess(questions){
	alert("Questions successfully created");
}

/******* Deletion of Questions ******************************/
function deleteAllQuestions(){
	var biscatoQuestionURL = getBiscatoQuestionURL();
	$.ajax(
            {
                type: "DELETE",
                url: biscatoQuestionURL,
                data: "{}",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    questionsDeletedSuccess(data);
                },
                error: function (msg, url, line) {
                    alert('error trapped in error: function(msg, url, line)');
                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

                }
            });	
}

function questionsDeletedSuccess(data){
	alert("All questions have been deleted successfully");
}
/******* Creation of Test Answers ******************************/
function createTestAnswers(){
	var biscatoQuestionaireURL = getBiscatoQuestionaireURL();
	
    $.ajax(
        {
            type: "GET",
            url: biscatoQuestionaireURL,
            data: "{}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
            	handleCreateTestAnswers(data.question);
            },
            error: function (msg, url, line) {
                alert('error trapped in error: function(msg, url, line)');
                alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

            }
        });
}

function handleCreateTestAnswers(questions){

	var users = getTestAnswerUsers();
//	var numberOfVotings = getTestNumberOfVotings(); TODO: implement test data for past votes (4 over a year or so) !Serverside!

	for(var usr in users){
		
		var answers = new Array();
		
		for(var question in questions){
			
	        answers[question] = new Array();
	        answers[question]["questionId"] = questions[question].id;
	        answers[question]["questionText"] = questions[question].description;
	        answers[question]["questionCategory"] = questions[question].category;
	        answers[question]["user"] = users[usr];
	        answers[question]["rating"] = getRandomIntBetweenZeroAndTen();
		}
		
		var votes = convertVoteToJSONFormat(answers);
		
		var biscatoAnswerURL = getBiscatoAnswerURL();
		$.ajax(
	            {
	                type: "POST",
	                url: biscatoAnswerURL,
	                data: votes,
	                contentType: "application/json; charset=utf-8",
	                dataType: "json",
	                success: function (data) {
	                    testAnswersCreatedSuccess(data.question);
	                },
	                error: function (msg, url, line) {
	                    alert('error trapped in error: function(msg, url, line)');
	                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

	                }
	            });
		
	}	
}

function getTestNumberOfVotings(){
	return 4;
}

function getTestAnswerUsers(){
	var users = new Array();
	users[0] = "Hans.Mueller@gmail.com";
	users[1] = "Georg.Friedrich@gmail.com";
	users[2] = "Marcel.Breitling@gmail.com";
	users[3] = "Uwe.Kunz@gmail.com";
	users[4] = "Trevor.Hoffmann@gmail.com";
	users[5] = "Wilhelm.Schmitt@gmail.com";
	users[6] = "Kevin.Krauth@gmail.com";
	users[7] = "Martin.Baumann@gmail.com";
	users[8] = "Matt.Cain@gmail.com";
	return users;
}

function testAnswersCreatedSuccess(data){
	console.log("Test Answers created successfully");
}

function getRandomIntBetweenZeroAndTen () {
    return Math.floor(Math.random() * (10 - 0 + 1)) + 0;
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





