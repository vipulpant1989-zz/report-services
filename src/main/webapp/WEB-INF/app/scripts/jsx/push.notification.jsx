import React from 'React';

var express = require('express')
, app = express.createServer()
, io = require('socket.io').listen(app);


class PushNotification extends React.Component{
	 constructor(){
	 	
	 }
	 createNotification(){
		app.post('/message/:action/:to', function (req, res) {
			target = connections[req.params.to]
			if (target) {
				connections[req.params.to].emit(req.params.action, req.body);
				res.send(200);
			}
			else{
				res.send(404);
			}
		});
	 }
}