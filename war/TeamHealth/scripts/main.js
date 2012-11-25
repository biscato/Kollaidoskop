//jQuery( function(){
//  var welcome = "hello";
    $(document).ready(function () {

        // See http://en.wikipedia.org/wiki/XMLHttpRequest to make this cross-browser compatible
        var req = new XMLHttpRequest();

        // Create a 'GET' request w/ an optional callback handler
        req.open('GET', 'http://192.168.178.23:8888/kollaidoskop');// + query, async);

            req.onreadystatechange = function() {
                if(req.readyState == 4 && req.status == 200) {
                    var response = null;
                    try {
                        response = JSON.parse(req.responseText);
                    } catch (e) {
                        response = req.responseText;
                    }
                    callback(response);
                }
            }
        function callback(response){
            var resp = response;
            var html = "<div>"+response.toString()+"</div>"
            $(resp).appendTo($("#JSON"));

        }
        // Make the actual request
        req.send(null);
        //        $.ajax(
//            {
//                type: "GET",
//                url:
//                    'http://fastmotorcycleservice.cloudapp.net/FastMotorcycleListService.svc/list/Bruno',
//
//                data: "{}",
//                contentType: "application/json; charset=utf-8",
//                dataType: "json",
//                success: function (data) {
//
//                    //alert('success');
//                    $.each(data, function (i, theItem) {
//                        var combo = document.getElementById("cboFastBikes");
//                        var option = document.createElement("option");
//                        option.text = theItem.toString();
//                        option.value = theItem.toString();
//                        try {
//                            //alert('success add combo');
//                            combo.add(option, null); // Other browsers
//                        }
//                        catch (error) {
//                            alert('error found');
//                            combo.add(option); // really old browser
//                        }
//
//                    });
//                },
//                error: function (msg, url, line) {
//                    alert('error trapped in error: function(msg, url, line)');
//                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);
//
//                }
//            });

    }  );
//            $.ajax(
//                {
//                    type: "GET",
//                    url: 'http://192.168.178.23:8888/kollaidoskop',
//                    contentType: "application/json; charset=utf-8",
////                    dataType: "json",
//                    success: function (data) {
//
//                        //alert('success');
//                        $.each(data, function (i, theItem) {
//                            var combo = document.getElementById("cboFastBikes");
//                            var option = document.createElement("option");
//                            option.text = theItem.toString();
//                            option.value = theItem.toString();
//                            try {
//                                //alert('success add combo');
//                                combo.add(option, null); // Other browsers
//                            }
//                            catch (error) {
//                                alert('error found');
//                                combo.add(option); // really old browser
//                            }
//
//                        });
//                    },
//                    error: function (msg, url, line) {
//                        alert('error trapped in error: function(msg, url, line)');
//                        alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);
//
//                    }
//                });
//    });

//        $('#butCallAjax').click(function () {
//            jQuery.support.cors = true;
//
//        $.getJSON("http://192.168.178.23:8888/kollaidoskop", function(data) {
//            var items = [];
//
//            $.each(data, function(key, val) {
//                items.push('<li id="' + key + '">' + val + '</li>');
//            });
//
//            $('<ul/>', {
//                'class': 'my-new-list',
//                html: items.join('')
//            }).appendTo('questions');
//        });
//    });


//            $.ajax(
//                {
//                    type: "GET",
//                    url: 'http://192.168.178.23:8888/kollaidoskop',
//                    data: "{}",
//                    contentType: "application/json; charset=utf-8",
//                    dataType: "json",
//                    success: function (data) {
//
//                        //alert('success');
//                        $.each(data, function (i, theItem) {
//                            var combo = document.getElementById("cboFastBikes");
//                            var option = document.createElement("option");
//                            option.text = theItem.toString();
//                            option.value = theItem.toString();
//                            try {
//                                //alert('success add combo');
//                                combo.add(option, null); // Other browsers
//                            }
//                            catch (error) {
//                                alert('error found');
//                                combo.add(option); // really old browser
//                            }
//
//                        });
//                    },
//                    error: function (msg, url, line) {
//                        alert('error trapped in error: function(msg, url, line)');
//                        alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);
//
//                    }
//                });
//
//
//            //alert('button click');
//
//        });
//    });

//
//    jQuery.getJSON()
//});