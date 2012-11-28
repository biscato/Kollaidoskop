package com.biscato.kollaidoskop;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class QuestionaireOld {

	String[][] contentArray; 
	
	public QuestionaireOld(){
		createTestData2();
	}

	public String getQuestionaire(){
		return "Persistenz wurde erfolgreich angelegt. Gl&uuml;ckwunsch :-)";

	}
	
	private void createTestData2(){
		
		String questionairName = "Fragebogen";
		Key questionairKey = KeyFactory.createKey("Questionair Kollaidoskop", questionairName);
        Entity question1 = new Entity("Question", questionairKey);
        question1.setProperty("Language", "de");
        question1.setProperty("Question ID", "1");
        question1.setProperty("Question", "In diesem Team ist allen klar, was wir erreichen wollen.");
        question1.setProperty("Category", "Vision");
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(question1);
        
        Entity question2 = new Entity("Question", questionairKey);
        question2.setProperty("Language", "de");
        question2.setProperty("Question ID", "2");
        question2.setProperty("Question", "Wir wissen, dass wir uns aufeinander verlassen k&ouml;nnen.");
        question2.setProperty("Category", "Unterstützung von Innvovation");
        datastore.put(question2);
        
        Entity question3 = new Entity("Question", questionairKey);
        question3.setProperty("Language", "de");
        question3.setProperty("Question ID", "3");
        question3.setProperty("Question", "Wir haben anregende Diskussionen darüber, wie wir am besten arbeiten.");
        question3.setProperty("Category", "Aufgabenorientierung");
        datastore.put(question3);
        
        Entity question4 = new Entity("Question", questionairKey);
        question4.setProperty("Language", "de");
        question4.setProperty("Question ID", "4");
        question4.setProperty("Question", "Wir treffen uns ausreichend häufig, um effektiv zu kommunizieren und zu koordinieren.");
        question4.setProperty("Category", "Partizipative Sicherheit");
        datastore.put(question4);
        
        Entity question5 = new Entity("Question", questionairKey);
        question5.setProperty("Language", "de");
        question5.setProperty("Question ID", "5");
        question5.setProperty("Question", "Die Teammitglieder bieten einander immer schnell Hilfe an, um etwas Neues auszuprobieren.");
        question5.setProperty("Category", "Unterstützung von Innvovation");
        datastore.put(question5);
        
        Entity question6 = new Entity("Question", questionairKey);
        question6.setProperty("Language", "de");
        question6.setProperty("Question ID", "6");
        question6.setProperty("Question", "Wir haben alle Einfluss auf endgültige Entscheidungen im Team.");
        question6.setProperty("Category", "Partizipative Sicherheit");
        datastore.put(question6);
        
        Entity question7 = new Entity("Question", questionairKey);
        question7.setProperty("Language", "de");
        question7.setProperty("Question ID", "7");
        question7.setProperty("Question", "Wir halten uns über arbeitsrelevante Dinge gegenseitig auf dem Laufenden.");
        question7.setProperty("Category", "Partizipative Sicherheit");
        datastore.put(question7);
        
        Entity question8 = new Entity("Question", questionairKey);
        question8.setProperty("Language", "de");
        question8.setProperty("Question ID", "8");
        question8.setProperty("Question", "In unserem Team herrscht ein Gefühl von Sicherheit und Vertrauen.");
        question8.setProperty("Category", "Partizipative Sicherheit");
        datastore.put(question8);
        
        Entity question9 = new Entity("Question", questionairKey);
        question9.setProperty("Language", "de");
        question9.setProperty("Question ID", "9");
        question9.setProperty("Question", "Wir sind jederzeit aufgeschlossen gegenüber neuen Ideen.");
        question9.setProperty("Category", "Unterstützung von Innvovation");
        datastore.put(question9);
        
        Entity question10 = new Entity("Question", questionairKey);
        question10.setProperty("Language", "de");
        question10.setProperty("Question ID", "10");
        question10.setProperty("Question", "Alle Teammitglieder fühlen sich den Zielen des Teams verpflichtet.");
        question10.setProperty("Category", "Vision");
        datastore.put(question10);
        
        Entity question11 = new Entity("Question", questionairKey);
        question11.setProperty("Language", "de");
        question11.setProperty("Question ID", "11");
        question11.setProperty("Question", "Wir können offen über Fehler sprechen.");
        question11.setProperty("Category", "Aufgabenorientierung");
        datastore.put(question11);
        
        Entity question12 = new Entity("Question", questionairKey);
        question12.setProperty("Language", "de");
        question12.setProperty("Question ID", "12");
        question12.setProperty("Question", "Wir stimmen mit unsere Ziele überein.");
        question12.setProperty("Category", "Vision");
        datastore.put(question12);
        
        Entity question13 = new Entity("Question", questionairKey);
        question13.setProperty("Language", "de");
        question13.setProperty("Question ID", "13");
        question13.setProperty("Question", "Es herrscht bei uns eine Atmosphäre, in der konstruktive Kritik geübt wird.");
        question13.setProperty("Category", "Aufgabenorientierung");
        datastore.put(question13);
        
        Entity question14 = new Entity("Question", questionairKey);
        question14.setProperty("Language", "de");
        question14.setProperty("Question ID", "14");
        question14.setProperty("Question", "Wir unterstützen einander in Ideen über neue und verbesserte Arbeitsprozesse.");
        question14.setProperty("Category", "Unterstützung von Innvovation");
        datastore.put(question14);
        
        Entity question15 = new Entity("Question", questionairKey);
        question15.setProperty("Language", "de");
        question15.setProperty("Question ID", "15");
        question15.setProperty("Question", "Wir unterstützen uns gegenseitig bei der Erledigung unserer Aufgabe. ");
        question15.setProperty("Category", "Aufgabenorientierung");
        datastore.put(question15);
        
        Entity question16 = new Entity("Question", questionairKey);
        question16.setProperty("Language", "de");
        question16.setProperty("Question ID", "16");
        question16.setProperty("Question", "Jeder im Team trägt zur Entscheidungsfindung bei.");
        question16.setProperty("Category", "Partizipative Sicherheit");
        datastore.put(question16);
        
        Entity question17 = new Entity("Question", questionairKey);
        question17.setProperty("Language", "de");
        question17.setProperty("Question ID", "17");
        question17.setProperty("Question", "Unsere Teamregeln beinhalten auch Erwartungen zum Kommunikations- und Rückmeldeverhalten. (Vereinbarungen)");
        question17.setProperty("Category", "Struktur");
        datastore.put(question17);
        
        Entity question18 = new Entity("Question", questionairKey);
        question18.setProperty("Language", "de");
        question18.setProperty("Question ID", "18");
        question18.setProperty("Question", "Wir haben durchgängig die richtigen Werkzeuge für effektive Zusammenarbeit verfügbar. (Infrastruktur)");
        question18.setProperty("Category", "Struktur");
        datastore.put(question18);
        
        Entity question19 = new Entity("Question", questionairKey);
        question19.setProperty("Language", "de");
        question19.setProperty("Question ID", "19");
        question19.setProperty("Question", "Alle im Team haben ausreichende Kenntnisse für die situativ angemessene Anwendung der bereitgestellten Kooperationswerkzeuge. (Medienkompetenz)");
        question19.setProperty("Category", "Virtuelle Kompetenz");
        datastore.put(question19);
        
        Entity question20 = new Entity("Question", questionairKey);
        question20.setProperty("Language", "de");
        question20.setProperty("Question ID", "20");
        question20.setProperty("Question", "Unsere Teambesprechungen finden regelmäßig statt und werden sorgfältig vorbereitet. Inhalte, Ziele und Ablauf sind klar.  (Regeln)");
        question20.setProperty("Category", "Struktur");
        datastore.put(question20);
        
        Entity question21 = new Entity("Question", questionairKey);
        question21.setProperty("Language", "de");
        question21.setProperty("Question ID", "21");
        question21.setProperty("Question", "Im Team werden die vorhandenen Kommunikationskanäle gemäß der getroffenen Absprachen  effizient eingesetzt.  (Kommunikation)");
        question21.setProperty("Category", "Virtuelle Kompetenz");
        datastore.put(question21);
        
        Entity question22 = new Entity("Question", questionairKey);
        question22.setProperty("Language", "de");
        question22.setProperty("Question ID", "22");
        question22.setProperty("Question", "In unserem Team besteht eine angemessene Balance zwischen Autonomie /Flexibilität und Zusammenhalt. (Selbstorganisation)");
        question22.setProperty("Category", "Virtuelle Kompetenz");
        datastore.put(question22);
        
        Entity question23 = new Entity("Question", questionairKey);
        question23.setProperty("Language", "de");
        question23.setProperty("Question ID", "23");
        question23.setProperty("Question", "Wir haben eine klare Verteilung von Rollen, Aufgaben und Verantwortlichkeiten im Team. (Klarheit)");
        question23.setProperty("Category", "Struktur");
        datastore.put(question23);
        
        Entity question24 = new Entity("Question", questionairKey);
        question24.setProperty("Language", "de");
        question24.setProperty("Question ID", "24");
        question24.setProperty("Question", "Es gibt auch regelmäßig informelle Kontakte zwischen allen Teammitgliedern. (Vertrauen)");
        question24.setProperty("Category", "Virtuelle Kompetenz");
        datastore.put(question24);
        
        Entity question1b = new Entity("Question", questionairKey);
        question1b.setProperty("Language", "en");
        question1b.setProperty("Question ID", "1");
        question1b.setProperty("Question", "We all know our common objectives.");
        question1b.setProperty("Category", "vision");
        datastore.put(question1b);
        
        Entity question2b = new Entity("Question", questionairKey);
        question2b.setProperty("Language", "en");
        question2b.setProperty("Question ID", "2");
        question2b.setProperty("Question", "We know that we can rely on each other.");
        question2b.setProperty("Category", "support of innovation");
        datastore.put(question2b);
        
        Entity question3b = new Entity("Question", questionairKey);
        question3b.setProperty("Language", "en");
        question3b.setProperty("Question ID", "3");
        question3b.setProperty("Question", "We have inspiring discussions about how to best cooperate.");
        question3b.setProperty("Category", "task oriented");
        datastore.put(question3b);
        
        Entity question4b = new Entity("Question", questionairKey);
        question4b.setProperty("Language", "en");
        question4b.setProperty("Question ID", "4");
        question4b.setProperty("Question", "We meet often enough to effectively communicate and cooperate.");
        question4b.setProperty("Category", "security");
        datastore.put(question4b);
        
        Entity question5b = new Entity("Question", questionairKey);
        question5b.setProperty("Language", "en");
        question5b.setProperty("Question ID", "5");
        question5b.setProperty("Question", "Team members always quickly offer help in order to test new approaches.");
        question5b.setProperty("Category", "support of innovation");
        datastore.put(question5b);
        
        Entity question6b = new Entity("Question", questionairKey);
        question6b.setProperty("Language", "en");
        question6b.setProperty("Question ID", "6");
        question6b.setProperty("Question", "We all have an influence on final team decisions.");
        question6b.setProperty("Category", "security");
        datastore.put(question6b);
        
        Entity question7b = new Entity("Question", questionairKey);
        question7b.setProperty("Language", "en");
        question7b.setProperty("Question ID", "7");
        question7b.setProperty("Question", "We constantly keep each other up to date in regard to issues relevant to our work.");
        question7b.setProperty("Category", "security");
        datastore.put(question7b);
        
        Entity question8b = new Entity("Question", questionairKey);
        question8b.setProperty("Language", "en");
        question8b.setProperty("Question ID", "8");
        question8b.setProperty("Question", "In our team, there is an atmosphere of security and trust.");
        question8b.setProperty("Category", "security");
        datastore.put(question8b);
        
        Entity question9b = new Entity("Question", questionairKey);
        question9b.setProperty("Language", "en");
        question9b.setProperty("Question ID", "9");
        question9b.setProperty("Question", "We are receptive to new ideas at all times.");
        question9b.setProperty("Category", "support of innovation");
        datastore.put(question9b);
        
        Entity question10b = new Entity("Question", questionairKey);
        question10b.setProperty("Language", "en");
        question10b.setProperty("Question ID", "10");
        question10b.setProperty("Question", "All team members are comitted to the team's objectives.");
        question10b.setProperty("Category", "vision");
        datastore.put(question10b);
        
        Entity question11b = new Entity("Question", questionairKey);
        question11b.setProperty("Language", "en");
        question11b.setProperty("Question ID", "11");
        question11b.setProperty("Question", "We can openly adress mistakes.");
        question11b.setProperty("Category", "task oriented");
        datastore.put(question11b);
        
        Entity question12b = new Entity("Question", questionairKey);
        question12b.setProperty("Language", "en");
        question12b.setProperty("Question ID", "12");
        question12b.setProperty("Question", "We agree on our objectives.");
        question12b.setProperty("Category", "vision");
        datastore.put(question12b);
        
        Entity question13b = new Entity("Question", questionairKey);
        question13b.setProperty("Language", "en");
        question13b.setProperty("Question ID", "13");
        question13b.setProperty("Question", "The team atmosphere fosters constructive critisism.");
        question13b.setProperty("Category", "task oriented");
        datastore.put(question13b);
        
        Entity question14b = new Entity("Question", questionairKey);
        question14b.setProperty("Language", "en");
        question14b.setProperty("Question ID", "14");
        question14b.setProperty("Question", "We support each other in developing new and modified processes.");
        question14b.setProperty("Category", "support of innovation");
        datastore.put(question14b);
        
        Entity question15b = new Entity("Question", questionairKey);
        question15b.setProperty("Language", "en");
        question15b.setProperty("Question ID", "15");
        question15b.setProperty("Question", "We support each other in fullfilling our tasks. ");
        question15b.setProperty("Category", "task oriented");
        datastore.put(question15b);
        
        Entity question16b = new Entity("Question", questionairKey);
        question16b.setProperty("Language", "en");
        question16b.setProperty("Question ID", "16");
        question16b.setProperty("Question", "Every one in the team contributes to decision making.");
        question16b.setProperty("Category", "security");
        datastore.put(question16b);
        
        Entity question17b = new Entity("Question", questionairKey);
        question17b.setProperty("Language", "en");
        question17b.setProperty("Question ID", "17");
        question17b.setProperty("Question", "Our team rules include expectations respective... (agreements)");
        question17b.setProperty("Category", "structure");
        datastore.put(question17b);
        
        Entity question18b = new Entity("Question", questionairKey);
        question18b.setProperty("Language", "en");
        question18b.setProperty("Question ID", "18");
        question18b.setProperty("Question", "We have all the tools we need for working together effectively. (infrastructure)");
        question18b.setProperty("Category", "structure");
        datastore.put(question18b);
        
        Entity question19b = new Entity("Question", questionairKey);
        question19b.setProperty("Language", "en");
        question19b.setProperty("Question ID", "19");
        question19b.setProperty("Question", "Alle im Team haben ausreichenen Kenntnisse für die situativ angemessene Anwendung enr bereitgestellten Kooperationswerkzeuge. (Medienkompetenz)");
        question19b.setProperty("Category", "virtual competence");
        datastore.put(question19b);
        
        Entity question20b = new Entity("Question", questionairKey);
        question20b.setProperty("Language", "en");
        question20b.setProperty("Question ID", "20");
        question20b.setProperty("Question", "Unsere Teambesprechungen finenn regelmäßig statt und werenn sorgfältig vorbereitet. Inhalte, Ziele und Ablauf sind klar.  (Regeln)");
        question20b.setProperty("Category", "structure");
        datastore.put(question20b);
        
        Entity question21b = new Entity("Question", questionairKey);
        question21b.setProperty("Language", "en");
        question21b.setProperty("Question ID", "21");
        question21b.setProperty("Question", "Im Team werenn die vorhanennen Kommunikationskanäle gemäß enr getroffenen Absprachen  effizient eingesetzt.  (Kommunikation)");
        question21b.setProperty("Category", "virtual competence");
        datastore.put(question21b);
        
        Entity question22b = new Entity("Question", questionairKey);
        question22b.setProperty("Language", "en");
        question22b.setProperty("Question ID", "22");
        question22b.setProperty("Question", "In unserem Team besteht eine angemessene Balance zwischen Autonomie /Flexibilität und Zusammenhalt. (Selbstorganisation)");
        question22b.setProperty("Category", "virtual competence");
        datastore.put(question22b);
        
        Entity question23b = new Entity("Question", questionairKey);
        question23b.setProperty("Language", "en");
        question23b.setProperty("Question ID", "23");
        question23b.setProperty("Question", "Wir haben eine klare Verteilung von Rollen, Aufgaben und Verantwortlichkeiten im Team. (Klarheit)");
        question23b.setProperty("Category", "structure");
        datastore.put(question23b);
        
        Entity question24b = new Entity("Question", questionairKey);
        question24b.setProperty("Language", "en");
        question24b.setProperty("Question ID", "24");
        question24b.setProperty("Question", "Es gibt auch regelmäßig informelle Kontakte zwischen allen Teammitglieenrn. (Vertrauen)");
        question24b.setProperty("Category", "virtual competence");
        datastore.put(question24b);
        
	}
//	private void createTestData(){
//		contentArray = new String [3][24];
//		contentArray[0][0] = "1";
//		contentArray[0][1] = "2";
//		contentArray[0][2] = "3";
//		contentArray[0][3] = "4";
//		contentArray[0][4] = "5";
//		contentArray[0][5] = "6";
//		contentArray[0][6] = "7";
//		contentArray[0][7] = "8";
//		contentArray[0][8] = "9";
//		contentArray[0][9] = "10";
//		contentArray[0][10] = "11";
//		contentArray[0][11] = "12";
//		contentArray[0][12] = "13";
//		contentArray[0][13] = "14";
//		contentArray[0][14] = "15";
//		contentArray[0][15] = "16";
//		contentArray[0][16] = "17";
//		contentArray[0][17] = "18";
//		contentArray[0][18] = "19";
//		contentArray[0][19] = "20";
//		contentArray[0][20] = "21";
//		contentArray[0][21] = "22";
//		contentArray[0][22] = "23";
//		contentArray[0][23] = "24";
//		contentArray[1][0] = "In diesem Team ist allen klar, was wir erreichen wollen.";
//		contentArray[1][1] = "Wir wissen, dass wir uns aufeinander verlassen können.";
//		contentArray[1][2] = "Wir haben anregende Diskussionen darüber, wie wir am besten arbeiten.";
//		contentArray[1][3] = "Wir treffen uns ausreichend häufig, um effektiv zu kommunizieren und zu koordinieren.";
//		contentArray[1][4] = "Die Teammitglieder bieten einander immer schnell Hilfe an, um etwas Neues auszuprobieren.";
//		contentArray[1][5] = "Wir haben alle Einfluss auf endgültige Entscheidungen im Team.";
//		contentArray[1][6] = "Wir halten uns über arbeitsrelevante Dinge gegenseitig auf dem Laufenden.";
//		contentArray[1][7] = "In unserem Team herrscht ein Gefühl von Sicherheit und Vertrauen.";
//		contentArray[1][8] = "Wir sind jederzeit aufgeschlossen gegenüber neuen Ideen.";
//		contentArray[1][9] = "Alle Teammitglieder fühlen sich den Zielen des Teams verpflichtet.";
//		contentArray[1][10] = "Wir können offen über Fehler sprechen.";
//		contentArray[1][11] = "Wir stimmen mit unsere Ziele überein.";
//		contentArray[1][12] = "Es herrscht bei uns eine Atmosphäre, in der konstruktive Kritik geübt wird.";
//		contentArray[1][13] = "Wir unterstützen einander in Ideen über neue und verbesserte Arbeitsprozesse.";
//		contentArray[1][14] = "Wir unterstützen uns gegenseitig bei der Erledigung unserer Aufgabe.";
//		contentArray[1][15] = "Jeder im Team trägt zur Entscheidungsfindung bei.";
//		contentArray[1][16] = "Unsere Teamregeln beinhalten auch Erwartungen zum Kommunikations- und Rückmeldeverhalten. (Vereinbarungen)";
//		contentArray[1][17] = "Wir haben durchgängig die richtigen Werkzeuge für effektive Zusammenarbeit verfügbar. (Infrastruktur)";
//		contentArray[1][18] = "Alle im Team haben ausreichende Kenntnisse für die situativ angemessene Anwendung der bereitgestellten Kooperationswerkzeuge. (Medienkompetenz)";
//		contentArray[1][19] = "Unsere Teambesprechungen finden regelmäßig statt und werden sorgfältig vorbereitet. Inhalte, Ziele und Ablauf sind klar.  (Regeln)";
//		contentArray[1][20] = "Im Team werden die vorhandenen Kommunikationskanäle gemäß der getroffenen Absprachen  effizient eingesetzt.  (Kommunikation)";
//		contentArray[1][21] = "In unserem Team besteht eine angemessene Balance zwischen Autonomie /Flexibilität und Zusammenhalt. (Selbstorganisation)";
//		contentArray[1][22] = "Wir haben eine klare Verteilung von Rollen, Aufgaben und Verantwortlichkeiten im Team. (Klarheit)";
//		contentArray[1][23] = "Es gibt auch regelmäßig informelle Kontakte zwischen allen Teammitgliedern. (Vertrauen)";
//		contentArray[2][0] = "Vision";
//		contentArray[2][1] = "Unterstützung von Innvovation";
//		contentArray[2][2] = "Aufgabenorientierung";
//		contentArray[2][3] = "Partizipative Sicherheit";
//		contentArray[2][4] = "Unterstützung von Innvovation";
//		contentArray[2][5] = "Partizipative Sicherheit";
//		contentArray[2][6] = "Partizipative Sicherheit";
//		contentArray[2][7] = "Partizipative Sicherheit";
//		contentArray[2][8] = "Unterstützung von Innvovation";
//		contentArray[2][9] = "Vision";
//		contentArray[2][10] = "Aufgabenorientierung";
//		contentArray[2][11] = "Vision";
//		contentArray[2][12] = "Aufgabenorientierung";
//		contentArray[2][13] = "Unterstützung von Innvovation";
//		contentArray[2][14] = "Aufgabenorientierung";
//		contentArray[2][15] = "Partizipative Sicherheit";
//		contentArray[2][16] = "Struktur";
//		contentArray[2][17] = "Struktur";
//		contentArray[2][18] = "Virtuelle Kompetenz";
//		contentArray[2][19] = "Struktur";
//		contentArray[2][20] = "Virtuelle Kompetenz";
//		contentArray[2][21] = "Virtuelle Kompetenz";
//		contentArray[2][22] = "Struktur";
//		contentArray[2][23] = "Virtuelle Kompetenz";
//		
//	}
}
