const Enum =require('enumify');
const rp = require('request-promise');

class HttpMethod extends Enum{}

HttpMethod.initEnum(['POST','GET','PUT','DELETE']);

class HttpCall {

	constructor(url, method, data){
		this.options = {
		    method: method.name,
		    uri: this.url,
		    form: this.data,
		    headers: {
		        /* 'content-type': 'application/x-www-form-urlencoded' */ // Set automatically
		    },
		    json : true
		};
	}
	call(){
		return rp(this.options).then(function(response){
			return response;
		}).catch(function(error){
			return error;
		});
	}
}


class Api extends HttpCall{
	constructor(url, method, data){
		super(url, method, data);
	}
}

export default Api;
module.export = HttpMethod;
