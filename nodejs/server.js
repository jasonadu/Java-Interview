var http = require('http');
var querystring = require('querystring');
var fs = require("fs");
var path = require('path');

var hostname = 'localhost';
var port = 4000;
var url = 'fileRead';


var responseFileName = "";
var requestData = "";



var server = http.createServer(function (req, res) {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'application/json');
    var postdata = "";
    var fileName = "";
    const buf = Buffer.alloc(20);
    

    req.on("data", function (postchunk) {
        postdata += postchunk;
    });

    req.on("end", function () {
		
		if (postdata === "") {
			res.write("pls check");
			res.end();
			return;
		}
        requestData = JSON.parse(postdata);
        fileName = requestData.fileName;
        

        if (requestData.systemFlag === 'B') {
            responseFileName = "banking.json";
        } else if (requestData.systemFlag === 'I') {
            responseFileName = "cards.json";
        } else{
            responseFileName = "";
        }
		console.log("responseFileName=" + path.join(__dirname, responseFileName));
		
		fs.readFile(path.join(__dirname, responseFileName), function (err, data) {
		   
		   if (err) {
			   res.write(err);
			   return;
		   }
		   var respData=JSON.parse(data);
		   //console.log(JSON.stringify(respData));
		   console.log("data: " + respData.acUserId + " " + respData.sysInd);
		   
		   res.write(data);
		   res.end();
		});
		


    });


});

server.listen(port, hostname, url, function () {
    console.log('Server running at http://%s:%s/%s', hostname, port, url);
});
